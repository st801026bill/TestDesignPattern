package com.bill.dp.common.factory3.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory3.product.compulsory.Compulsory_21;
import com.bill.dp.common.factory3.product.compulsory.Compulsory_47;
import com.bill.dp.common.factory3.product.compulsory.Compulsory_49;
import com.bill.dp.common.factory3.product.compulsory.ICompulsory;
import com.bill.dp.common.factory3.product.policy.IPolicyDto;
import com.bill.dp.common.factory3.product.policy.WWUTravelPolicyDtoReq;
import com.bill.dp.common.factory3.product.policy.WWUVehiclePolicyDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WWUPolicyFactory implements IPolicyFactory {
	
	@Autowired
	private PojoUtil pojoUtil;
	
	@Override
	public IPolicyDto createTravelPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, WWUTravelPolicyDtoReq.class);
	}
	@Override
	public IPolicyDto createVehiclePolicy(IPolicyFactory factory, Map<String, ? extends Object> map) {
		IPolicyDto policy =  pojoUtil.transMap2Bean(map, WWUVehiclePolicyDtoReq.class);
		policy.createFactory(factory);
		return policy;
	}

	@Override
	public ICompulsory createCompulsory_21() {
		return new Compulsory_21();
	}
	@Override
	public ICompulsory createCompulsory_47() {
		return new Compulsory_47();
	}
	@Override
	public ICompulsory createCompulsory_49() {
		return new Compulsory_49();
	}
}
