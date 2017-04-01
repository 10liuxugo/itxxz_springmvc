package com.itxxz.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itxxz.sys.dict.service.DictProvider;


public class DictBean {
	private static final Logger LOG = LoggerFactory.getLogger(DictBean.class);

	@Autowired
	private DictProvider dictProvider;

	@Autowired
	//private ParamProvider paramProvider;

	public void init() {
		// 初始化所有字典表
		dictProvider.InitSysDict();

		// 初始化参数表
		//paramProvider.InitSysParam();

	}
}
