package com.bill.dp.common.factory3.product.policy;

import com.bill.dp.common.factory3.factory.IPolicyFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper=false)
public class TSBTravelPolicyDtoReq implements IPolicyDto{
	
	private IPolicyFactory factory;
	
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
	public void prepare() {
		this.description = "HI~我是台新 - 旅遊險保單!!";
	}

	@Override
	public void save() {
		this.description += "(新增成功)";
	}

	@Override
	public void createFactory(IPolicyFactory factory) {
		this.factory = factory;
	}
}
