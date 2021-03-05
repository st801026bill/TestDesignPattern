package com.bill.dp.common.factory2;

import java.util.Map;

import com.bill.dp.dto.basic.BaseDtoReq;

public interface IPolicyFactory {
	BaseDtoReq createPolicy(Map<String, ? extends Object> map);
}
