package com.hkbu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.SOrderDao;
import com.hkbu.domain.SOrder;
import com.hkbu.queryModel.SOrderQueryModel;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="sOrderDao")
public class SOrderDaoImpl extends BaseDaoImpl<SOrder> implements SOrderDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		SOrderQueryModel sqm=(SOrderQueryModel)qm;
		if (sqm.getStatus()!=null)
		{
			dc.add(Restrictions.eq("status", sqm.getStatus()));
		}
		if(sqm.getEmpUuid()!=null)
		{
			dc.add(Restrictions.eq("empUuid", sqm.getEmpUuid()));
		}
			
	}


}