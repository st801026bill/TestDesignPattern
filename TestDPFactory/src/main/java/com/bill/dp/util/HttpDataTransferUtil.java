package com.bill.dp.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bill.dp.common.exception.ErrorType;
import com.bill.dp.common.exception.ModuleException;
import com.bill.dp.model.basic.BaseWebReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HttpDataTransferUtil {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	PojoUtil pojoUtil;
	
	private HttpHeaders headers;
	
	/**
	 * <pre>
	 * 從 BaseWebReq 取出 TRANRQ 裡的基本型態資料
	 * 若資料格式錯誤或無此key則return null
	 */
	public <T extends Object> T getTranrqUnderlyingType(BaseWebReq baseWebReq, String key, Class<T> underlyingType) {
		
		if(baseWebReq == null) return null;
		
		Object obj = StringUtils.isBlank(key)? baseWebReq.getTranrq() : baseWebReq.getTranrq().get(key);
		T value = null;
		try {
			value = (T) obj;
		} catch(ClassCastException e) {
			log.debug("Get tranrs value from HttpDataTransferObject fail", e);
		}
		return value;
	}
	
	/**
	 * <pre>
	 * 包裝ResponseEntity
	 */
	public ResponseEntity<String> boxingResEntity(BaseWebReq baseWebReq, Map<String, ? extends Object> resBodyMap, HttpStatus status) {
		String resBodyJsonStr = boxingResContent(baseWebReq, resBodyMap);
		return generateResEntity(resBodyJsonStr, status);
	}
	
	/**
	 * <pre>
	 * 包裝執行成功的ResponseBody
	 * @param reqHdto	HttpDataTransferObject
	 * @param resBodyMap	Map
	 * @return resJsonStr
	 * </pre>
	 */
	public String boxingResContent(BaseWebReq baseWebReq, Map<String, ? extends Object> resBodyMap) {
//		if(StringUtils.isBlank(baseWebReq.getMwHeader().getReturnCode())) {
//			baseWebReq.getMwHeader().setReturnCode(ErrorType.SUCCESS.getCode());
//		}
//		if(StringUtils.isBlank(baseWebReq.getMwHeader().getReturnDesc())) {
//			baseWebReq.getMwHeader().setReturnDesc(ErrorType.SUCCESS.getMessage());
//		}
		baseWebReq.setTranrq(resBodyMap);
		String resJsonStr = null;
		try {
			resJsonStr = objectMapper.writeValueAsString(baseWebReq);
		} catch (JsonProcessingException e) {
			throw new ModuleException(ErrorType.UNKNOW_ERROR, e);
		}
		return resJsonStr;
	}
	
	/**
	 * 產生含有 header 的 responseEntity
	 */
	public ResponseEntity<String> generateResEntity(String resBodyJsonStr, HttpStatus status) {
		return ResponseEntity.status(status).headers(headers).body(resBodyJsonStr);
	}
}
