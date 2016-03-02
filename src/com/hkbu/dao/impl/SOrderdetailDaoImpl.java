package com.hkbu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.SOrderdetailDao;
import com.hkbu.domain.SOrderdetail;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value=" sOrderdetailDao")
public class SOrderdetailDaoImpl extends BaseDaoImpl<SOrderdetail> implements SOrderdetailDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

}