package com.bill.dp.common.factory3;

import java.util.Map;

import com.bill.dp.dto.basic.BaseDtoReq;

public interface IPolicyFactory {
	BaseDtoReq createTravelPolicy(Map<String, ? extends Object> map);
	BaseDtoReq createVehiclePolicy(Map<String, ? extends Object> map);
	
}
