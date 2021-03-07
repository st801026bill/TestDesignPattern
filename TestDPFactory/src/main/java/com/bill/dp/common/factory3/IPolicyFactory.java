package com.bill.dp.common.factory3;

import java.util.Map;

import com.bill.dp.dto.basic.BaseDtoReq;

public interface IPolicyFactory {
	/**	旅遊險保單	**/
	BaseDtoReq createTravelPolicy(Map<String, ? extends Object> map);
	/**	車險保單	 **/
	BaseDtoReq createVehiclePolicy(Map<String, ? extends Object> map);
	/**	行動險保單	 **/
	BaseDtoReq createMobilePolicy(Map<String, ? extends Object> map);
}
