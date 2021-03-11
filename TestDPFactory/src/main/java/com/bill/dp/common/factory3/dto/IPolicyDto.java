package com.bill.dp.common.factory3.dto;

import com.bill.dp.dto.basic.IBaseDto;

public interface IPolicyDto extends IBaseDto{
	public abstract String description();
	public abstract void save();
}
