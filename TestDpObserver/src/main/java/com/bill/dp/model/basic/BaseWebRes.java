package com.bill.dp.model.basic;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseWebRes implements IBasePojo {
	
	@JsonProperty("MWHEADER")
	private BaseWebMwHeader mwHeader;
	
	@JsonProperty("TRANRS")
	private Map<String, ? extends Object> tranrs;
}
