package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.ComponentsDao;
import com.hkbu.domain.Components;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="componentsDao")
public class ComponentsDaoImpl extends BaseDaoImpl<Components> implements ComponentsDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		
	}

	@Override
	public List<Components> getInsufficientComponents()
	{
		String hql="from Components where inventory < sufficientLevel";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<Components> getComponentsByTypeId(Long uuid)
	{
		String hql="from Components where componentsTypeUuid=?";
		
		return getHibernateTemplate().find(hql, uuid);
	}

}