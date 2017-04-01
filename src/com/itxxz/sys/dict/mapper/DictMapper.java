package com.itxxz.sys.dict.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itxxz.sys.dict.entity.SysAllDict;

@Repository("dictMapper")
public interface DictMapper {
	List<SysAllDict> findAllDict();
}
