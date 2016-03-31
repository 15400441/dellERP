package com.hkbu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Emp;
import com.hkbu.dao.EmpDao;
import com.hkbu.mapper.EmpMapper;
import com.hkbu.service.EmpService;
import com.hkbu.util.MD5Utils;

import org.springframework.stereotype.Service;

@Service(value="empService")
@Transactional
public class EmpServiceImpl implements EmpService
{

	@Resource(name="empDao")
	private EmpDao empDao;
	@Resource(name="empMapper")
	private EmpMapper empMapper;

	@Override
	public Emp login(Emp emp)
	{
		String encodePwd=MD5Utils.md5(emp.getPwd());
		Emp e=empDao.findByUsernameAndPwd(emp.getUserName(),encodePwd);
		return e;
	}

	@Override
	public void update(Emp emp)
	{
		empDao.update(emp);
		
	}

	@Override
	public List<Map<String, Object>> getRoleList(Long uuid)
	{
		return empMapper.getRoleList(uuid);
	}

}