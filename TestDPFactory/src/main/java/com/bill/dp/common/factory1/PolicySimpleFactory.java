package com.bill.dp.common.factory1;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory1.dto.TravelPolicyDtoReq;
import com.bill.dp.common.factory1.dto.VehiclePolicyDtoReq;
import com.bill.dp.dto.basic.IPolicyDto;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicySimpleFactory {
	
	private static PojoUtil pojoUtil;
	@Autowired
	private PojoUtil tempPojoUtil;
	@PostConstruct
    public void init() {
		pojoUtil = tempPojoUtil;
    }
	
	public static IPolicyDto createPolicy(String insTypeId, Map<String, ? extends Object> map) {
		
		Map<String, Class<? extends IPolicyDto>> policyType = new HashedMap<String, Class<? extends IPolicyDto>>(){{
			put("I01", TravelPolicyDtoReq.class);
			put("I02", VehiclePolicyDtoReq.class);
			put("I03", VehiclePolicyDtoReq.class);
		}};
		
		IPolicyDto policy = pojoUtil.transMap2Bean(map, policyType.get(insTypeId));
		
//		BaseDtoReq policy = null;
//		switch(insTypeId) {
//			case "I01": 
//				policy = pojoUtil.transMap2Bean(map, TravelPolicyDtoReq.class);
//				break;
//			case "I02":
//			case "I03":
//				policy = pojoUtil.transMap2Bean(map, VehiclePolicyDtoReq.class);
//				break;
//		}
		
		log.info("createPolicy: {}", policy.toString());
		return policy;
	}
}
