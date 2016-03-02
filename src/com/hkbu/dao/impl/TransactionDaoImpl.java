package com.hkbu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.TransactionDao;
import com.hkbu.domain.Transaction;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value=" transactionDao")
public class TransactionDaoImpl extends BaseDaoImpl<Transaction> implements TransactionDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		// TODO 添加自定义查询条件
	}

}