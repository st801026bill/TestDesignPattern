package com.bill.dp.service.basic;

import org.springframework.http.ResponseEntity;

import com.bill.dp.dto.basic.BaseDtoReq;
import com.bill.dp.model.basic.BaseWebReq;

public interface IBaseService {
	public abstract ResponseEntity<?> process(BaseWebReq baseWebReq); 
}
