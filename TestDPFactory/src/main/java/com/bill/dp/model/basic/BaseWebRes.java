package com.bill.dp.model.basic;

import java.util.Map;

import com.bill.dp.dto.basic.IPolicyDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseWebRes implements IBasePojo {
	
	@JsonProperty("MWHEADER")
	private BaseWebMwHeader mwHeader;
	
	@JsonProperty("TRANRS")
	private Map<String, ? extends Object> tranrs;
	
	@Data
	public static class BaseWebMwHeader {
		@JsonProperty("TXNSEQ")
		private String txnseq;
		
		@JsonProperty("RETURNCODE")
		private String returnCode;
		
		@JsonProperty("RETURNDESC")
		private String returnDesc;
	}
}
