package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Transaction;
import com.hkbu.dao.TransactionDao;
import com.hkbu.service.TransactionService;
import org.springframework.stereotype.Service;

@Service(value="transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService
{

	@Resource(name="transactionDao")
	private TransactionDao transactionDao;

}