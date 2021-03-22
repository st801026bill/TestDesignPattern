package com.bill.dp.common.factory1;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory1.product.IPolicyDto;
import com.bill.dp.common.factory1.product.TravelPolicyDtoReq;
import com.bill.dp.common.factory1.product.VehiclePolicyDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
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
		
		log.info("createPolicy: {}", policy.toString());
		return policy;
	}
}
