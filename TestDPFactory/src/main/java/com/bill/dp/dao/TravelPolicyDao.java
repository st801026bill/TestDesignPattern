package com.bill.dp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.dp.dao.basic.IBaseDao;
import com.bill.dp.entity.TravelPolicyPo;
import com.bill.dp.model.TravelPolicyPojo;
import com.bill.dp.repository.TravelPolicyRepository;
import com.bill.dp.util.PojoUtil;

@Service
public class TravelPolicyDao implements IBaseDao {
	
	@Autowired
	PojoUtil pojoUtil;
	
	@Autowired
	TravelPolicyRepository travelPolicyRepository;
	
	@Transactional(rollbackFor = Exception.class)
	public TravelPolicyPojo addPolicy(TravelPolicyPojo pojo) {
		TravelPolicyPo po = travelPolicyRepository.save(pojoUtil.transPojo2Po(pojo));
		return pojoUtil.transPo2Pojo(po, "");
	}
}
