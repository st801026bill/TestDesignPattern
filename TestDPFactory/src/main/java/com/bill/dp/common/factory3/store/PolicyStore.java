package com.bill.dp.common.factory3.store;

import com.bill.dp.common.factory3.dto.IPolicyDto;
import com.bill.dp.model.basic.BaseWebReq;

public abstract class PolicyStore {
	
	public IPolicyDto buyPolicy(String insTypeId, BaseWebReq baseWebReq) {
		IPolicyDto policy = createPolicy(insTypeId, baseWebReq);
		
		//設定Description
		policy.description();
		//save policy
		policy.save();
		
		return policy;
	}
	
	public abstract IPolicyDto createPolicy(String insString, BaseWebReq baseWebReq);
}
