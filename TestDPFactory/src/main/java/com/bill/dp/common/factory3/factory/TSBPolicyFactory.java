package com.bill.dp.common.factory3.factory;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory3.dto.TSBTravelPolicyDtoReq;
import com.bill.dp.common.factory3.dto.TSBVehiclePolicyDtoReq;
import com.bill.dp.dao.basic.IBaseDao;
import com.bill.dp.dto.basic.IPolicyDto;
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
	public IPolicyDto createVehiclePolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TSBVehiclePolicyDtoReq.class);
	}

	@Override
	public IPolicyDto createMobilePolicy(Map<String, ? extends Object> map) {
		return null;
	}
}
