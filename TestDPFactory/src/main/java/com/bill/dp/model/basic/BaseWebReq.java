package com.bill.dp.model.basic;

import java.util.Map;

import com.bill.dp.dto.basic.BaseDtoReq;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseWebReq implements IBasePojo {
	
	@JsonProperty("MWHEADER")
	private BaseWebMwHeader mwHeader;
	
	@JsonProperty("TRANRQ")
	private Map<String, ? extends Object> tranrq;
	
	@Data
	public static class BaseWebMwHeader {
		@JsonProperty("TXNSEQ")
		private String txnseq;
	}
}
