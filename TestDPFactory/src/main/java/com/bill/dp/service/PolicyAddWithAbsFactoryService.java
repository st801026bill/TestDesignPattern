package com.bill.dp.service;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory3.IPolicyFactory;
import com.bill.dp.common.factory3.TPIPolicyFactory;
import com.bill.dp.common.factory3.WWUPolicyFactory;
import com.bill.dp.dto.basic.BaseDtoReq;
import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.basic.IBaseService;
import com.bill.dp.util.HttpDataTransferUtil;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyAddWithAbsFactoryService implements IBaseService {

	@Autowired
	PojoUtil pojoUtil;
	@Autowired
	HttpDataTransferUtil httpDataTransferUtil;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String company 	 = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "COMPANY", String.class);
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("company: {}, insTypeId: {}", company, insTypeId);
		
		//透過 COMPANY 取得 對應的 FACTORY
		Map<String, IPolicyFactory> companyFactoryType = new HashedMap<String, IPolicyFactory>(){{
			put("WWU", new WWUPolicyFactory());
			put("TPI", new TPIPolicyFactory());
		}};
		IPolicyFactory companyFactory = companyFactoryType.get(company);
		
		//透過 INS_TYPE_ID 取得 對應的 BaseDtoReq
		Map<String, BaseDtoReq> policyMap = new HashedMap<String, BaseDtoReq>(){{
			put("I01", companyFactory.createTravelPolicy(baseWebReq.getTranrq()));
			put("I02", companyFactory.createVehiclePolicy(baseWebReq.getTranrq()));
			put("I03", companyFactory.createVehiclePolicy(baseWebReq.getTranrq()));
		}};
		
		BaseDtoReq req = policyMap.get(insTypeId);
		log.info("req: {}", req);
			
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(req, "");
		
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
