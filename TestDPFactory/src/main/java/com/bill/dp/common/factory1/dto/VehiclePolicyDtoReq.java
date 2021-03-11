package com.bill.dp.common.factory1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
public class VehiclePolicyDtoReq implements IPolicyDto{
		
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("VEHICLE_POLICY")
	private VehiclePolicy vehiclePolicy;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class VehiclePolicy {
		
		@JsonProperty("APPLY_NO")
		private String applyNo;
		
		@JsonProperty("NAME")
		private String name;
		
		@JsonProperty("CAR_ID")
		private String carId;
	}
	
	@Override
	public String description() {
		return this.description = "HI~我是車險保單!!";
	}
}
