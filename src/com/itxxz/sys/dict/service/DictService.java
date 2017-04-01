package com.itxxz.sys.dict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.sys.dict.entity.SysAllDict;
import com.itxxz.sys.dict.mapper.DictMapper;

@Service("DictService")
public class DictService {

	@Autowired
	private DictMapper dictMapper;
	
	public List<SysAllDict> findAllDict()
	{
		return dictMapper.findAllDict();
	}
}
