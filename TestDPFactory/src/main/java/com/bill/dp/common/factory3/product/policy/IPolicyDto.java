package com.bill.dp.common.factory3.product.policy;

import com.bill.dp.common.factory3.factory.IPolicyFactory;
import com.bill.dp.dto.basic.IBaseDto;

public interface IPolicyDto extends IBaseDto{
	
	public abstract void createFactory(IPolicyFactory factory);
	
	public abstract void prepare();
	public abstract void save();
}
