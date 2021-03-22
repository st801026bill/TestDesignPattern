package com.bill.dp.service;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory2.factory.IPolicyFactory;
import com.bill.dp.common.factory2.factory.TravelPolicyFactory;
import com.bill.dp.common.factory2.factory.VehiclePolicyFactory;
import com.bill.dp.common.factory2.product.IPolicyDto;
import com.bill.dp.common.factory2.store.WWUPolicyStore;
import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.basic.IBaseService;
import com.bill.dp.util.HttpDataTransferUtil;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyAddWithFactoryService implements IBaseService {

	@Autowired
	PojoUtil pojoUtil;
	@Autowired
	HttpDataTransferUtil httpDataTransferUtil;
	
	@Autowired
	@Qualifier("PolicyStore")
	WWUPolicyStore store;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("insTypeId: {}", insTypeId);

		//購買保單
		IPolicyDto policy = store.buyPolicy(insTypeId, baseWebReq);
		
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(policy, "");
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
