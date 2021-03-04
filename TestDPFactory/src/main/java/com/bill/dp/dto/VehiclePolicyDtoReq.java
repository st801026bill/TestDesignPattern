package com.bill.dp.dto;

import com.bill.dp.dto.basic.BaseDtoReq;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VehiclePolicyDtoReq extends BaseDtoReq{
	
	@JsonProperty("APPLY_NO")
	private String applyNo;
	
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("NAME")
	private String name;
	
	@JsonProperty("CAR_ID")
	private String carId;
	
}
