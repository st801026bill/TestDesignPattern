package com.bill.dp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.PolicyAddService;
import com.bill.dp.service.PolicyAddWithAbsFactoryService;
import com.bill.dp.service.PolicyAddWithFactoryService;
import com.bill.dp.service.PolicyAddWithSimpleFactoryService;

@RestController
public class DemoController {
	
	@Autowired
	private PolicyAddService policyAddService;
	@Autowired
	private PolicyAddWithSimpleFactoryService policyAddWithSimpleFactoryService;
	@Autowired
	private PolicyAddWithFactoryService policyAddWithFactoryService;
	@Autowired
	private PolicyAddWithAbsFactoryService policyAddWithAbsFactoryService;
	
	@RequestMapping(value = "/policy/add",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPolicy(@RequestBody BaseWebReq baseWebReq) {
		return policyAddService.process(baseWebReq);
	}
	
	@RequestMapping(value = "/policy/add/with_simple_factory",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPolicyWithSimpleFactory(@RequestBody BaseWebReq baseWebReq) {
		return policyAddWithSimpleFactoryService.process(baseWebReq);
	}
	
	@RequestMapping(value = "/policy/add/with_factory",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPolicyWithFactory(@RequestBody BaseWebReq baseWebReq) {
		return policyAddWithFactoryService.process(baseWebReq);
	}
	
	@RequestMapping(value = "/policy/add/with_abs_factory",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPolicyWithAbsFactory(@RequestBody BaseWebReq baseWebReq) {
		return policyAddWithAbsFactoryService.process(baseWebReq);
	}
	
}
