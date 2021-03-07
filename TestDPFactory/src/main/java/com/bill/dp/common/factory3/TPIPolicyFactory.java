package com.bill.dp.common.factory3;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.dto.TPITravelPolicyDtoReq;
import com.bill.dp.dto.TPIVehiclePolicyDtoReq;
import com.bill.dp.dto.basic.BaseDtoReq;
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
	public BaseDtoReq createTravelPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TPITravelPolicyDtoReq.class);
	}

	@Override
	public BaseDtoReq createVehiclePolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TPIVehiclePolicyDtoReq.class);
	}

	@Override
	public BaseDtoReq createMobilePolicy(Map<String, ? extends Object> map) {
		return null;
	}
}
