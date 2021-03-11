package com.bill.dp.common.factory3.factory;

import java.util.Map;

import com.bill.dp.dto.basic.IPolicyDto;

public interface IPolicyFactory {
	/**	旅遊險保單	**/
	IPolicyDto createTravelPolicy(Map<String, ? extends Object> map);
	/**	車險保單	 **/
	IPolicyDto createVehiclePolicy(Map<String, ? extends Object> map);
	/**	行動險保單	 **/
	IPolicyDto createMobilePolicy(Map<String, ? extends Object> map);
}
