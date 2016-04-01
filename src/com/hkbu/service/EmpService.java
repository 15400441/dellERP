package com.hkbu.service;

import java.util.List;
import java.util.Map;

import com.hkbu.domain.Emp;
public interface EmpService
{

	Emp login(Emp emp);

	void update(Emp emp);

	List<Map<String, Object>> getRoleList(Long uuid);

	List<Map<String, Object>> getEmpInfo();
	

}