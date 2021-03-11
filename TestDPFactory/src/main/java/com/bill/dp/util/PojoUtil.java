package com.bill.dp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dp.dto.basic.IBaseDto;
import com.bill.dp.entity.basic.IBasePo;
import com.bill.dp.model.basic.IBasePojo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PojoUtil {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * 	將Pojo轉換為Map
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
	 * 	將Map轉換為Pojo
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
	
	/**
	 * 	將 Pojo 轉換為 Po
	 */
	public <T extends IBasePojo, S extends IBasePo> S transPojo2Po(T pojo, String... ignoreFields) {
		if(null == pojo) return null;
		List<T> pojoList = new ArrayList<>();
		pojoList.add(pojo);
		List<S> poList = transPojo2Po(pojoList, ignoreFields);
		if(poList.isEmpty()) {
			return null;
		} else {
			return poList.get(0);
		}
	}
	
	/**
	 * 	將 Pojos 轉換為 Pos
	 */
	public <T extends IBasePojo, S extends IBasePo> List<S> transPojo2Po(List<T> pojos, String... ignoreFields) {
		if(pojos.isEmpty()) return new ArrayList<>();
		List<S> pos = new ArrayList<>();
		try {
			pos = transPojo2Po(pojos, pojos.get(0).getClass(), ignoreFields);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pos;
	}
	
	/**
	 *	 將 Pojos 轉換為 Pos
	 */
	private <T extends IBasePojo, S extends IBasePo> List<S> transPojo2Po(List<T> pojos, Class<? extends IBasePojo> pojoClass, String... ignoreFields)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		
		String poClassName = pojoClass.getName().substring(0, pojoClass.getName().length() - 2).replace(".model.", ".entity.");
		Class<S> poClass = (Class<S>) Class.forName(poClassName);
		
		List<S> pos = new ArrayList<>();
		for(int i=0; i<pojos.size(); i++) {
			pos.add(poClass.newInstance());
		}
		
		for(int i=0; i< pojos.size(); i++) {
			BeanUtils.copyProperties(pojos.get(i), pos.get(i), ignoreFields);
		}
		
		return pos;
	}
	
	//=======================================================
	/**
	 *	 將 Po 轉換為 Pojo
	 */
	public <T extends IBasePo, S extends IBasePojo> S transPo2Pojo(T pos, String... ignoreFields) {
		if(null == pos) return null;
		List<T> posList = Collections.singletonList(pos);
		List<S> pojos = transPo2Pojo(posList, ignoreFields);
		if(pojos.isEmpty()) {
			return null;
		} else {
			return pojos.get(0);
		}
	}
	
	/**
	 * 	將 Pos 轉換為 Pojos
	 */
	public <T extends IBasePo, S extends IBasePojo> List<S> transPo2Pojo(List<T> pos, String... ignoreFields) {
		if(pos.isEmpty()) return new ArrayList<>();
		List<S> pojos = new ArrayList<>();
		try {
			pojos = transPo2Pojo(pos, pos.get(0).getClass(), ignoreFields);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojos;
	}
	
	/**
	 * 將 Po 轉換為 Pojo
	 */
	private <T extends IBasePo, S extends IBasePojo> List<S> transPo2Pojo(List<T> pos, Class<? extends IBasePo> poClass, String... ignoreFields)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		
		String pojoClassName = poClass.getName().replace(".entity.", ".model.") + "jo";
		Class<S> pojoClass = (Class<S>) Class.forName(pojoClassName);
		
		List<S> pojos = new ArrayList<>();
		for(int i=0; i<pos.size(); i++) {
			pojos.add(pojoClass.newInstance());
		}
		
		for(int i=0; i<pos.size(); i++) {
			BeanUtils.copyProperties(pos.get(i), pojos.get(i), ignoreFields);
		}
		
		return pojos;
	}
	
	/**
	 * 	將Dtos擷取出Pojos
	 */
	public <T extends IBaseDto, S extends IBasePojo> S transDto2Bean(T dto, Class<S> pojoClass, String... ignoreFields) {
		if(null == dto) return null;
		List<T> dtoList = Collections.singletonList(dto);
		List<S> pojos = transDto2Bean(dtoList, pojoClass, ignoreFields);
		if(pojos.isEmpty()) {
			return null;
		} else {
			return pojos.get(0);
		}
	}
	
	/**
	 * 	將Dtos擷取出Pojos
	 */
	public <T extends IBaseDto, S extends IBasePojo> List<S> transDto2Bean(List<T> dtos, Class<S> pojoClass, String... ignoreFields) {
		if(dtos.isEmpty()) return new ArrayList<>();
		List<S> pojos = new ArrayList<>();
		try {
			pojos = transDto2BeanExecutor(dtos, pojoClass, ignoreFields);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.error("Dto轉換Pojo Error", e);
		}
		return pojos;
	}
	
	/**
	 * 將Dto擷取出Pojo
	 */
	private <T extends IBaseDto, S extends IBasePojo> List<S> transDto2BeanExecutor(List<T> dtos, Class<S> pojoClass, String... ignoreFields)
			throws InstantiationException, IllegalAccessException {
		
		List<S> pojos = new ArrayList<>();
		for(int i=0; i<dtos.size(); i++) {
			pojos.add(pojoClass.newInstance());
		}
		
		for(int i=0; i< dtos.size(); i++) {
			BeanUtils.copyProperties(dtos.get(i), pojos.get(i), ignoreFields);
		};
		return pojos;
	}
}
