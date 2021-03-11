package com.bill.dp.service;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.factory3.dto.IPolicyDto;
import com.bill.dp.common.factory3.factory.IPolicyFactory;
import com.bill.dp.common.factory3.store.PolicyStore;
import com.bill.dp.common.factory3.store.TSBPolicyStore;
import com.bill.dp.common.factory3.store.WWUPolicyStore;
import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.basic.IBaseService;
import com.bill.dp.util.HttpDataTransferUtil;
import com.bill.dp.util.PojoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyAddWithAbsFactoryService implements IBaseService {

	@Autowired
	private PojoUtil pojoUtil;
	@Autowired
	private HttpDataTransferUtil httpDataTransferUtil;
	
	@Autowired
	private WWUPolicyStore WWUPolicyStore;
	@Autowired
	private TSBPolicyStore TSBPolicyStore;
	
	@Override
	public ResponseEntity<?> process(BaseWebReq baseWebReq) {
		
		String company 	 = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "COMPANY", String.class);
		String insTypeId = httpDataTransferUtil.getTranrqUnderlyingType(baseWebReq, "INS_TYPE_ID", String.class);
		log.info("company: {}, insTypeId: {}", company, insTypeId);
		
		/*
		//透過 COMPANY 取得 對應的 FACTORY (產品族)
		Map<String, IPolicyFactory> companyFactoryType = new HashedMap<String, IPolicyFactory>(){{
			put("WWU", WWUPolicyFactory);
			put("TSB", TSBPolicyFactory);
		}};
		IPolicyFactory companyFactory = companyFactoryType.get(company);
		
		//透過 INS_TYPE_ID 取得 對應的 BaseDtoReq (產品)
		Map<String, IPolicyDto> policyMap = new HashedMap<String, IPolicyDto>(){{
			put("I01", companyFactory.createTravelPolicy(baseWebReq.getTranrq()));
			put("I02", companyFactory.createVehiclePolicy(baseWebReq.getTranrq()));
			put("I03", companyFactory.createVehiclePolicy(baseWebReq.getTranrq()));
		}};
		IPolicyDto policy = policyMap.get(insTypeId);
		*/
		
		/* 取得保單商店 */
		Map<String, PolicyStore> storeType = new HashedMap<String, PolicyStore>(){{
			put("WWU", WWUPolicyStore);
			put("TSB", TSBPolicyStore);
		}};
		PolicyStore store = storeType.get(company);
		IPolicyDto policy = store.buyPolicy(insTypeId, baseWebReq);
		
		policy.description();
		log.info("req: {}", policy);
			
		Map<String,Object> resBodyMap = pojoUtil.transBean2Map(policy, "");
		
		return httpDataTransferUtil.boxingResEntity(baseWebReq, resBodyMap, HttpStatus.OK);
	}
}
