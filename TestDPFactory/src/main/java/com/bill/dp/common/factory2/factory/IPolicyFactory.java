package com.bill.dp.common.factory2.factory;

import java.util.Map;

import com.bill.dp.common.factory2.dto.IPolicyDto;

public interface IPolicyFactory {
	IPolicyDto createPolicy(Map<String, ? extends Object> map);
}
