package com.hkbu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.hkbu.base.Page;
import com.hkbu.domain.Transaction;
import com.hkbu.dao.TransactionDao;
import com.hkbu.queryModel.TransactionQueryModel;
import com.hkbu.service.TransactionService;
import org.springframework.stereotype.Service;

@Service(value="transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService
{

	@Resource(name="transactionDao")
	private TransactionDao transactionDao;

	@Override
	public int getCount(Transaction transaction, String startDate, String endDate)
	{
		TransactionQueryModel tqm=new TransactionQueryModel(startDate,endDate);
		tqm.setType(transaction.getType());
		return transactionDao.getCount(tqm);	
	}

	@Override
	public Page<Transaction> getTransactionList(Transaction transaction, Integer pageNum, int totalCount, String startDate, String endDate)
	{
		TransactionQueryModel tqm=new TransactionQueryModel(startDate,endDate);
		tqm.setType(transaction.getType());
		Page<Transaction> page=new Page<Transaction>(5, pageNum, totalCount);
		List<Transaction> list=transactionDao.getAll(tqm, pageNum, 5 );
		page.setRecords(list);
		return page;
	}
	

	@Override
	public List<Transaction> downloadTransactions()
	{
		List<Transaction> list=transactionDao.getThisMonthTransactionList();
		return list;
	}

	

}