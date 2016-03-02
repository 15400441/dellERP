package com.hkbu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.SOrderDao;
import com.hkbu.domain.SOrder;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value=" sOrderDao")
public class SOrderDaoImpl extends BaseDaoImpl<SOrder> implements SOrderDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

}