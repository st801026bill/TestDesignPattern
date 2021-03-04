package com.bill.dp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill.dp.entity.TravelPolicyPo;

@Repository
public interface TravelPolicyRepository extends JpaRepository<TravelPolicyPo, Integer> {
	public TravelPolicyPo findByApplyNo(String applyNo);
}
