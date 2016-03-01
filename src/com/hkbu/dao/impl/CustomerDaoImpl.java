package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;
import com.hkbu.dao.CustomerDao;
import com.hkbu.domain.Customer;


@Repository(value="customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao
{	
	public void doQbc(DetachedCriteria dc, BaseQueryModel qm)
	{
				
	}

	@Override
	public Customer getByUserNameAndPwd(Customer customer)
	{
		String hql="from Customer where userName=? and pwd=?";
		List<Customer> list= getHibernateTemplate().find(hql, customer.getUserName(),customer.getPwd());
		return list.size()!=0? list.get(0):null;
	}

}
