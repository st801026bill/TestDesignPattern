package com.bill.dp.common.factory3.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory3.dto.IPolicyDto;
import com.bill.dp.common.factory3.dto.WWUTravelPolicyDtoReq;
import com.bill.dp.common.factory3.dto.WWUVehiclePolicyDtoReq;
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
	public IPolicyDto createVehiclePolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, WWUVehiclePolicyDtoReq.class);
	}

	@Override
	public IPolicyDto createMobilePolicy(Map<String, ? extends Object> map) {
		return null;
	}
}
