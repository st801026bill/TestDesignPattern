package com.bill.dp.model.basic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseWebMwHeader {
	@JsonProperty("TXNSEQ")
	private String txnseq;
	
	@JsonProperty("RETURN_CODE")
	private String returnCode;
	
	@JsonProperty("RETURN_MSG")
	private String returnMsg;
}
