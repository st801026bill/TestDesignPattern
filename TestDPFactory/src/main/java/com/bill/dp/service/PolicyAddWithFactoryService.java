package com.bill.dp.service;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory2.IPolicyFactory;
import com.bill.dp.common.factory2.TravelPolicyFactory;
import com.bill.dp.common.factory2.VehiclePolicyFactory;
import com.bill.dp.common.factory3.factory.TSBPolicyFactory;
import com.bill.dp.common.factory3.factory.WWUPolicyFactory;
import com.bill.dp.dto.basic.IPolicyDto;
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
	
	@Autowired
	private TravelPolicyFactory travelPolicyFactory;
	@Autowired
	private VehiclePolicyFactory vehiclePolicyFactory;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("insTypeId: {}", insTypeId);

		//透過Factory取得Policy
		Map<String, IPolicyFactory> factoryType = new HashedMap<String, IPolicyFactory>(){{
			put("I01", travelPolicyFactory);
			put("I02", vehiclePolicyFactory);
			put("I03", vehiclePolicyFactory);
		}};
		IPolicyFactory policyFactory = factoryType.get(insTypeId);
		IPolicyDto policy = policyFactory.createPolicy(baseWebReq.getTranrq());
		policy.description();
		
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(policy, "");
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
