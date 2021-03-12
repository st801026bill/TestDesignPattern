package com.bill.dp.common.factory3.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory3.product.compulsory.Compulsory_21;
import com.bill.dp.common.factory3.product.compulsory.Compulsory_47;
import com.bill.dp.common.factory3.product.compulsory.Compulsory_49;
import com.bill.dp.common.factory3.product.compulsory.ICompulsory;
import com.bill.dp.common.factory3.product.policy.IPolicyDto;
import com.bill.dp.common.factory3.product.policy.TSBTravelPolicyDtoReq;
import com.bill.dp.common.factory3.product.policy.TSBVehiclePolicyDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TSBPolicyFactory implements IPolicyFactory {
	
	@Autowired
	private PojoUtil pojoUtil;

	@Override
	public IPolicyDto createTravelPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TSBTravelPolicyDtoReq.class);
	}

	@Override
	public IPolicyDto createVehiclePolicy(IPolicyFactory factory, Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TSBVehiclePolicyDtoReq.class);
	}

	@Override
	public ICompulsory createCompulsory_21() {
		return null;
	}

	@Override
	public ICompulsory createCompulsory_47() {
		return null;
	}

	@Override
	public ICompulsory createCompulsory_49() {
		return null;
	}
}
