package com.bill.dp.common.factory2.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.dp.common.factory2.product.IPolicyDto;
import com.bill.dp.common.factory2.product.TravelPolicyDtoReq;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TravelPolicyFactory implements IPolicyFactory {
	
	@Autowired
	private PojoUtil pojoUtil;
	
	@Override
	public IPolicyDto createPolicy(Map<String, ? extends Object> map) {
		return pojoUtil.transMap2Bean(map, TravelPolicyDtoReq.class);
	}
}
