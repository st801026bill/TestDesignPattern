package com.bill.dp.common.factory3;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.dto.WWUTravelPolicyDtoReq;
import com.bill.dp.dto.WWUVehiclePolicyDtoReq;
import com.bill.dp.dto.basic.BaseDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WWUPolicyFactory implements IPolicyFactory {
	
	private static PojoUtil pojoUtil;
	@Autowired
	private PojoUtil tempPojoUtil;
	@PostConstruct
    public void init() {
		pojoUtil = tempPojoUtil;
    }

	@Override
	public BaseDtoReq createTravelPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, WWUTravelPolicyDtoReq.class);
	}

	@Override
	public BaseDtoReq createVehiclePolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, WWUVehiclePolicyDtoReq.class);
	}

	@Override
	public BaseDtoReq createMobilePolicy(Map<String, ? extends Object> map) {
		return null;
	}
}
