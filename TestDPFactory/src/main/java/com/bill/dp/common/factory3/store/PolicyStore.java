package com.bill.dp.common.factory3.store;

import com.bill.dp.common.factory3.product.policy.IPolicyDto;
import com.bill.dp.model.basic.BaseWebReq;

public abstract class PolicyStore {
	
	public IPolicyDto buyPolicy(String insTypeId, BaseWebReq baseWebReq) {
		IPolicyDto policy = createPolicy(insTypeId, baseWebReq);
		policy.prepare();
		policy.save();
		return policy;
	}
	
	public abstract IPolicyDto createPolicy(String insString, BaseWebReq baseWebReq);
}
