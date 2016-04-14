package com.hkbu.service;

import java.util.List;

import com.hkbu.base.Page;
import com.hkbu.domain.Transaction;
public interface TransactionService
{

	int getCount(Transaction transaction, String startDate, String endDate);

	Page<Transaction> getTransactionList(Transaction transaction, Integer pageNum, int totalCount, String startDate, String endDate);

	List<Transaction> downloadTransactions();

}