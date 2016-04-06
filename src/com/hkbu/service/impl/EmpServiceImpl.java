package com.hkbu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Emp;
import com.hkbu.domain.SOrder;
import com.hkbu.dao.EmpDao;
import com.hkbu.mapper.EmpMapper;
import com.hkbu.queryModel.EmpQueryModel;
import com.hkbu.service.EmpService;
import com.hkbu.util.MD5Utils;

import org.springframework.stereotype.Service;

@Service(value = "empService")
@Transactional
public class EmpServiceImpl implements EmpService
{

	@Resource(name = "empDao")
	private EmpDao empDao;
	@Resource(name = "empMapper")
	private EmpMapper empMapper;

	@Override
	public Emp login(Emp emp)
	{
		String encodePwd = MD5Utils.md5(emp.getPwd());
		Emp e = empDao.findByUsernameAndPwd(emp.getUserName(), encodePwd);
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

	@Override
	public List<Map<String, Object>> getEmpInfo()
	{

		return empMapper.getEmpInfo();
	}

	@Override
	public int getCount(Emp emp)
	{
		EmpQueryModel qm = new EmpQueryModel();
		if (emp != null)
		{
			qm.setDepUuid(emp.getDepUuid());
			qm.setName(emp.getName());
			qm.setEmpNum(emp.getEmpNum());
		}
		return empDao.getCount(qm);
	}

	@Override
	public List<Emp> getEmpList(Emp emp, Integer pageNum, int pageSize)
	{
		EmpQueryModel qm = new EmpQueryModel();
		if (emp != null)
		{

			qm.setDepUuid(emp.getDepUuid());
			qm.setName(emp.getName());
			qm.setEmpNum(emp.getEmpNum());
		}
		return empDao.getAll(qm, pageNum, pageSize);

	}

	@Override
	public Emp findEmp(Long uuid)
	{
		return empDao.get(uuid);
	}

	@Override
	public void updateEmp(Emp emp)
	{
		Emp updateEmp = empDao.get(emp.getUuid());
		updateEmp.setDepUuid(emp.getDepUuid());
		updateEmp.setName(emp.getName());
		updateEmp.setEmpNum(emp.getEmpNum());
		updateEmp.setUserName(emp.getUserName());
		if (emp.getPwd() != null && !emp.getPwd().trim().equals("originalPwd"))
			updateEmp.setPwd(MD5Utils.md5(emp.getPwd()));
		updateEmp.setSalary(emp.getSalary());

	}

	@Override
	public void add(Emp emp)
	{
		emp.setPwd(MD5Utils.md5(emp.getPwd()));
		empDao.save(emp);
		
	}

	@Override
	public void deleteEmp(Long uuid)
	{
		Emp emp=empDao.get(uuid);	
		empDao.delete(emp);
		
	}

}