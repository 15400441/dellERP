package com.hkbu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.POrderDao;
import com.hkbu.domain.POrder;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value=" pOrderDao")
public class POrderDaoImpl extends BaseDaoImpl<POrder> implements POrderDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

}