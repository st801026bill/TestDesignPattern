package com.bill.dp.common.factory3;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory3.dto.TSBTravelPolicyDtoReq;
import com.bill.dp.common.factory3.dto.TSBVehiclePolicyDtoReq;
import com.bill.dp.dto.basic.IPolicyDto;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TPIPolicyFactory implements IPolicyFactory {
	
	private static PojoUtil pojoUtil;
	@Autowired
	private PojoUtil tempPojoUtil;
	@PostConstruct
    public void init() {
		pojoUtil = tempPojoUtil;
    }

	@Override
	public IPolicyDto createTravelPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TSBTravelPolicyDtoReq.class);
	}

	@Override
	public IPolicyDto createVehiclePolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TSBVehiclePolicyDtoReq.class);
	}

	@Override
	public IPolicyDto createMobilePolicy(Map<String, ? extends Object> map) {
		return null;
	}
}
