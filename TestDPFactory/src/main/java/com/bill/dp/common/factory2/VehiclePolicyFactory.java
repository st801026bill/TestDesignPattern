package com.bill.dp.common.factory2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory2.dto.IPolicyDto;
import com.bill.dp.common.factory2.dto.VehiclePolicyDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VehiclePolicyFactory implements IPolicyFactory {
	
	@Autowired
	private PojoUtil pojoUtil;
	
	@Override
	public IPolicyDto createPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, VehiclePolicyDtoReq.class);
	}
}
