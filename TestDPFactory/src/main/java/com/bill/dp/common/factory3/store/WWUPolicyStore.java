package com.bill.dp.common.factory3.store;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory3.factory.WWUPolicyFactory;
import com.bill.dp.common.factory3.product.policy.IPolicyDto;
import com.bill.dp.model.basic.BaseWebReq;

@Component
public class WWUPolicyStore extends PolicyStore {
	
	@Autowired
	WWUPolicyFactory factory;
	
	@Override
	public IPolicyDto createPolicy(String insTypeId, BaseWebReq baseWebReq) {
		Map<String, IPolicyDto> policyMap = new HashedMap<String, IPolicyDto>(){{
			put("I01", factory.createTravelPolicy(baseWebReq.getTranrq()));
			put("I02", factory.createVehiclePolicy(factory, baseWebReq.getTranrq()));
			put("I03", factory.createVehiclePolicy(factory, baseWebReq.getTranrq()));
		}};
		IPolicyDto policy = policyMap.get(insTypeId);
		return policy;
	}
}
