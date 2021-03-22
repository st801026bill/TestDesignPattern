package com.bill.dp.common.factory3.product.policy;

import com.bill.dp.common.factory3.factory.IPolicyFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper=false)
public class TSBVehiclePolicyDtoReq implements IPolicyDto{

	@JsonIgnore
	private IPolicyFactory factory;
	
	@JsonProperty("INS_TYPE_ID")
	private String insTypeId;
	
	@JsonProperty("COMPANY")
	private String company;
	
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
	public void prepare() {
		this.description = "HI~我是台新 - 車險保單!!";
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
