package com.bill.dp.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dp.model.basic.BaseWebReq;
import com.bill.dp.service.ObserverByCustomService;

@RestController
public class DemoController {
	
	ObserverByCustomService observerByCustomService;
	
	@RequestMapping(value = "/observer/custom",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> observerCustom(@RequestBody BaseWebReq baseWebReq) {
		return observerByCustomService.process(baseWebReq);
	}
}
