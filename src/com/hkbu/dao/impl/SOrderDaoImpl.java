package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.SOrderDao;
import com.hkbu.domain.SOrder;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="sOrderDao")
public class SOrderDaoImpl extends BaseDaoImpl<SOrder> implements SOrderDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

	@Override
	public List<SOrder> getOrderListByStatus(String status)
	{
		String hql="from SOrder where status=?";
		return getHibernateTemplate().find(hql, status);
	}

}