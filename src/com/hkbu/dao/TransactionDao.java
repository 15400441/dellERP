package com.hkbu.dao;

import java.util.List;

import com.hkbu.domain.Transaction;
import com.hkbu.base.BaseDao;

public interface TransactionDao extends BaseDao<Transaction>
{

	List<Transaction> getThisMonthTransactionList();

	

}
