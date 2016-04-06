package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.EmpDao;
import com.hkbu.domain.Emp;
import com.hkbu.queryModel.EmpQueryModel;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="empDao")
public class EmpDaoImpl extends BaseDaoImpl<Emp> implements EmpDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		EmpQueryModel eqm=(EmpQueryModel) qm;
		if(eqm.getDepUuid()!=null)
			dc.add(Restrictions.eq("depUuid", eqm.getDepUuid()));
		if(eqm.getName()!=null&&!eqm.getName().trim().equals(""))
			dc.add(Restrictions.like("name", "%"+eqm.getName()+"%"));
		if(eqm.getEmpNum()!=null&&!eqm.getEmpNum().trim().equals(""))
			dc.add(Restrictions.eq("empNum", eqm.getEmpNum()));
		dc.addOrder(Order.asc("depUuid"));
		
		
	}

	public Emp findByUsernameAndPwd(String userName, String pwd)
	{
		String hql="from Emp where userName=? and pwd=?";
		List<Emp> emps=getHibernateTemplate().find(hql,userName,pwd);
		return emps.size()!=0 ?emps.get(0):null;
	}

}