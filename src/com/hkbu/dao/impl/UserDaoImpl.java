package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;
import com.hkbu.dao.UserDao;
import com.hkbu.domain.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao
{

	
	public void doQbc(DetachedCriteria dc, BaseQueryModel qm)
	{
		// TODO Auto-generated method stub
		
	}

	
	public User getByUsernameAndPassword(User user)
	{
		String hql="from User where username=? and password=?";
		List<User> list= getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		return list.size()!=0? list.get(0):null;
	}

}
