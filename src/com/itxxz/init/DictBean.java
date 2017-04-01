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
		// ��ʼ�������ֵ��
		dictProvider.InitSysDict();

		// ��ʼ��������
		//paramProvider.InitSysParam();

	}
}
