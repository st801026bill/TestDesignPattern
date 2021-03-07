package com.bill.dp.dto;

import com.bill.dp.dto.basic.BaseDtoReq;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
public class TPIVehiclePolicyDtoReq implements BaseDtoReq{
		
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("COMPANY")
	private String company;
	
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
}
