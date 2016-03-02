package com.hkbu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.ComponentsTypeDao;
import com.hkbu.domain.ComponentsType;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value=" componentsTypeDao")
public class ComponentsTypeDaoImpl extends BaseDaoImpl<ComponentsType> implements ComponentsTypeDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

}