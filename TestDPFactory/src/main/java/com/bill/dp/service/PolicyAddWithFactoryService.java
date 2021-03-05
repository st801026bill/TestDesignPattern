package com.bill.dp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory2.IPolicyFactory;
import com.bill.dp.common.factory2.TravelPolicyFactory;
import com.bill.dp.common.factory2.VehiclePolicyFactory;
import com.bill.dp.dto.basic.BaseDtoReq;
import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.basic.IBaseService;
import com.bill.dp.util.HttpDataTransferUtil;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyAddWithFactoryService implements IBaseService {

	@Autowired
	PojoUtil pojoUtil;
	@Autowired
	HttpDataTransferUtil httpDataTransferUtil;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("insTypeId: {}", insTypeId);
		
		//透過Factory取得Policy
		IPolicyFactory travelPolicyFactory = new TravelPolicyFactory();
		BaseDtoReq travelPolicy = travelPolicyFactory.createPolicy(baseWebReq.getTranrq());
		log.info("travelPolicy: {}", travelPolicy);
		
//		IPolicyFactory vehiclePolicyFactory = new VehiclePolicyFactory();
//		BaseDtoReq vevehiclePolicy = vehiclePolicyFactory.createPolicy(baseWebReq.getTranrq());
		
		
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(travelPolicy, "");
		
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
