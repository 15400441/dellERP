package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.TransactionService;
import com.hkbu.domain.Transaction;

@Controller
@RequestMapping("/transaction")
public class TransactionController
{
	@Resource(name="transactionService")
	private TransactionService transactionService;

}