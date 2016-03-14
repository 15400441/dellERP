package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.EmpDao;
import com.hkbu.domain.Emp;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="empDao")
public class EmpDaoImpl extends BaseDaoImpl<Emp> implements EmpDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		
	}

	@Override
	public Emp findByUsernameAndPwd(String userName, String pwd)
	{
		String hql="from Emp where userName=? and pwd=?";
		List<Emp> emps=getHibernateTemplate().find(hql,userName,pwd);
		return emps.size()!=0 ?emps.get(0):null;
	}

}