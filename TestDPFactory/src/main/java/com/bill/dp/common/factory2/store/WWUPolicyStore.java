package com.bill.dp.common.factory2.store;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory2.factory.IPolicyFactory;
import com.bill.dp.common.factory2.factory.TravelPolicyFactory;
import com.bill.dp.common.factory2.factory.VehiclePolicyFactory;
import com.bill.dp.common.factory2.product.IPolicyDto;
import com.bill.dp.model.basic.BaseWebReq;
import com.fasterxml.jackson.core.sym.Name;

@Component("PolicyStore")
public class WWUPolicyStore {
	
	@Autowired
	private TravelPolicyFactory travelPolicyFactory;
	@Autowired
	private VehiclePolicyFactory vehiclePolicyFactory;
	
	public IPolicyDto buyPolicy(String insTypeId, BaseWebReq baseWebReq) {
		IPolicyDto policy = createPolicy(insTypeId, baseWebReq);
		policy.prepare();
		policy.save();
		return policy;
	}
	
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
