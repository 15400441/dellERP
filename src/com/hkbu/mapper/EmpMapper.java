package com.hkbu.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value="empMapper")
public interface EmpMapper
{
	List<Map<String, Object>> getRoleList(Long uuid);
}
