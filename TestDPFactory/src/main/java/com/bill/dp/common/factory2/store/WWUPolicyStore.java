package com.bill.dp.common.factory2.store;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory2.dto.IPolicyDto;
import com.bill.dp.common.factory2.factory.IPolicyFactory;
import com.bill.dp.common.factory2.factory.TravelPolicyFactory;
import com.bill.dp.common.factory2.factory.VehiclePolicyFactory;
import com.bill.dp.model.basic.BaseWebReq;

@Component
public class WWUPolicyStore extends PolicyStore {
	
	@Autowired
	private TravelPolicyFactory travelPolicyFactory;
	@Autowired
	private VehiclePolicyFactory vehiclePolicyFactory;
	
	@Override
	public IPolicyDto createPolicy(String insTypeId, BaseWebReq baseWebReq) {
        Map<String, IPolicyFactory> factoryType = new HashedMap<String, IPolicyFactory>(){{
            put("I01", travelPolicyFactory);
            put("I02", vehiclePolicyFactory);
            put("I03", vehiclePolicyFactory);
        }};
        IPolicyFactory policyFactory = factoryType.get(insTypeId);
        IPolicyDto policy = policyFactory.createPolicy(baseWebReq.getTranrq());
		return policy;
	}
}
