package com.bill.dp.dto;

import com.bill.dp.dto.basic.BaseDtoReq;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
public class TPITravelPolicyDtoReq implements BaseDtoReq{
	
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("COMPANY")
	private String company;
	
	@JsonProperty("TRAVEL_POLICY")
	private TravelPolicy travelPolicy;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class TravelPolicy {
		
		@JsonProperty("APPLY_NO")
		private String applyNo;
		
		@JsonProperty("NAME")
		private String name;
		
		@JsonProperty("TRAVEL_COUNTRY")
		private String travelCountry;
	}
}
