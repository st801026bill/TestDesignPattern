package com.bill.dp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.entity.TravelPolicyPo;
import com.bill.dp.model.TravelPolicyPojo;
import com.bill.dp.repository.TravelPolicyRepository;

@Service
public class TravelPolicyDao {
	
	@Autowired
	TravelPolicyRepository travelPolicyRepository;
	
//	public int addPolicy(TravelPolicyPojo pojo) {
//		TravelPolicyPo po = travelPolicyRepository.save(null);
//	}
	
}
