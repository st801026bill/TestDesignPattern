package com.bill.dp.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.model.basic.IBasePojo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PojoUtil {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * <pre>
	 * 將Pojo轉換為Map
	 */
	public <T extends IBasePojo>Map<String, Object> transBean2Map(T pojo, String ...ignoreFields) {
		if(pojo == null) return null;

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<String> ignoreFieldList = Arrays.asList(ignoreFields);
		try {
			map = objectMapper.convertValue(pojo, Map.class);
			if(!ignoreFieldList.isEmpty()) {
				for(String ignoreField: ignoreFieldList) {
					map.remove(ignoreField);
				}
			}
		} catch (Exception e) {
			log.error("Pojo轉換Map Error", e);
		}
		return map;
	}
	
	/**
	 * <pre>
	 * 將Map轉換為Pojo
	 */
	public<T extends IBasePojo> T transMap2Bean(Map<String, ? extends Object> map, Class<T> pojoClass) {
		if(null == map) {
			return null;
		}
		T pojo = null;
		try {
			pojo = objectMapper.convertValue(map, pojoClass);
		} catch (Exception e) {
			log.error("Map轉換Pojo Error", e);
		}
		return pojo;
	}
}
