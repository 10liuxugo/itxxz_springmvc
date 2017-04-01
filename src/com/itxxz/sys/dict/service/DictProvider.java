package com.itxxz.sys.dict.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itxxz.sys.dict.entity.SysAllDict;




@Component("dictProvider")
public class DictProvider {
	private static final Logger LOG = LoggerFactory.getLogger(DictProvider.class);

	private static HashMap<String,CopyOnWriteArrayList<SysAllDict>> typecodes = new HashMap<String,CopyOnWriteArrayList<SysAllDict>>();
	
	@Autowired
	private DictService dictService;
	
	public void InitSysDict()
	{
		LOG.debug("初始化字典表");
		
		List<SysAllDict> dicts = dictService.findAllDict();
		Iterator<SysAllDict> sdi = dicts.iterator();
		SysAllDict sd;
		CopyOnWriteArrayList<SysAllDict> lists;
		while(sdi.hasNext())
		{
			sd = sdi.next();
			if(!typecodes.containsKey(sd.getDictTypeCode()))
			{
				typecodes.put(sd.getDictTypeCode(), new CopyOnWriteArrayList<SysAllDict>());
			}
			lists = typecodes.get(sd.getDictTypeCode());
			lists.add(sd);
		}
	}
	
	/*
	 * 获得type下的所有List
	 */
	public static CopyOnWriteArrayList<SysAllDict> getSysDict(String typecode)
	{
		return typecodes.get(typecode);
	}
	
	/*
	 * 根据typecode,value获得值
	 */
	public static String getSysDict(String typecode,String value)
	{
		CopyOnWriteArrayList<SysAllDict> ca = typecodes.get(typecode);
		SysAllDict sd = null;
		Iterator<SysAllDict> sdi = ca.iterator();
		while(sdi.hasNext())
		{
			sd =  sdi.next();
		    if(sd.getDictValue().equals(value))
		    {
		    	return sd.getDictName();
		    }
		}
		return null;
	}
	
}
