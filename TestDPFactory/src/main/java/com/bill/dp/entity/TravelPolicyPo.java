package com.bill.dp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.bill.dp.entity.basic.IBasePo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Entity
@Table(name = "travel_policy")
public class TravelPolicyPo implements IBasePo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SN", nullable = false)
	private Integer sn;
	
	@Column(name = "APPLY_NO", length = 20, nullable = false)
	private String applyNo;

	@Column(name = "INS_TYPE_ID", length = 1, nullable = false)
	private String insTypeId;
	
	@Column(name = "NAME", length = 1, nullable = false)
	private String name;
	
}
