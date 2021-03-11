package com.bill.dp.common.factory3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper=false)
public class WWUTravelPolicyDtoReq implements IPolicyDto{
	
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("COMPANY")
	private String company;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
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

	@Override
	public String description() {
		return this.description = "HI~我是旺旺 - 旅遊險保單!!";
	}

	@Override
	public void save() {
		log.info("旺旺 - 旅遊險保單 已新增");
	}
}
