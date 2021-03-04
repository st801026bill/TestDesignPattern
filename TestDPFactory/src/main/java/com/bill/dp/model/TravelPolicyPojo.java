package com.bill.dp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPolicyPojo {

	@JsonProperty(value = "SN")
	private Integer sn;
	
	@JsonProperty(value = "APPLY_NO")
	private String applyNo;
	
	@JsonProperty(value = "INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty(value = "NAME")
	private String name;
	
}
