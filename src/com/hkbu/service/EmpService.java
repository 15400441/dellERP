package com.hkbu.service;

import java.util.List;
import java.util.Map;

import com.hkbu.domain.Emp;
import com.hkbu.domain.SOrder;
public interface EmpService
{

	Emp login(Emp emp);

	void update(Emp emp);

	List<Map<String, Object>> getRoleList(Long uuid);

	List<Map<String, Object>> getEmpInfo();

	int getCount(Emp emp);

	List<Emp> getEmpList(Emp emp, Integer pageNum, int pageSize);

	Emp findEmp(Long uuid);

	void updateEmp(Emp emp);

	
	

}