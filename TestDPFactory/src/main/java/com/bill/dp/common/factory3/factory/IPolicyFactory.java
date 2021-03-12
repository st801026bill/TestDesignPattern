package com.bill.dp.common.factory3.factory;

import java.util.Map;

import com.bill.dp.common.factory3.product.compulsory.ICompulsory;
import com.bill.dp.common.factory3.product.policy.IPolicyDto;

public interface IPolicyFactory {
	
	/*
	 * IPolicyDto
	 * 1. 旅遊險保單
	 * 2. 車險保單
	 */
	IPolicyDto createTravelPolicy(Map<String, ? extends Object> map);
	IPolicyDto createVehiclePolicy(IPolicyFactory factory, Map<String, ? extends Object> map);
	
	/*
	 * IVehiclePolicy
	 * 1. 強制險_21
	 * 2. 強制險_47
	 * 3. 強制險_49
	 */
	ICompulsory createCompulsory_21();
	ICompulsory createCompulsory_47();
	ICompulsory createCompulsory_49();
	
}
