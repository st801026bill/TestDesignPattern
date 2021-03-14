package com.bill.dp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.dto.TravelPolicyDtoReq;
import com.bill.dp.dto.VehiclePolicyDtoReq;
import com.bill.dp.dto.basic.IPolicyDto;
import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.basic.IBaseService;
import com.bill.dp.util.HttpDataTransferUtil;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyAddService implements IBaseService {

	@Autowired
	PojoUtil pojoUtil;
	@Autowired
	HttpDataTransferUtil httpDataTransferUtil;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("insTypeId: {}", insTypeId);
		
		//建立 IPolicyDto 實體物件
		IPolicyDto policy = null;
		switch(insTypeId) {
			case "I01": 
				policy = pojoUtil.transMap2Bean(baseWebReq.getTranrq(), TravelPolicyDtoReq.class);
				break;
			case "I02":
			case "I03":
				policy = pojoUtil.transMap2Bean(baseWebReq.getTranrq(), VehiclePolicyDtoReq.class);
				break;
		}
		
		policy.prepare();
		policy.save();
		
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(policy, "");
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
