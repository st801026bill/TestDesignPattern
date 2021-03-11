package com.bill.dp.common.factory2;

import java.util.Map;

import com.bill.dp.dto.basic.IPolicyDto;

public interface IPolicyFactory {
	IPolicyDto createPolicy(Map<String, ? extends Object> map);
}
