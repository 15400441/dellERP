package com.hkbu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.TransactionService;
import com.hkbu.util.ExcelUtils;
import com.hkbu.base.Page;
import com.hkbu.domain.Transaction;

@Controller
@RequestMapping("/transaction")
public class TransactionController
{
	@Resource(name="transactionService")
	private TransactionService transactionService;
	
	@RequestMapping("/getTransactionList")
	public String getTransactionList(Model model,Transaction transaction,Integer pageNum,String startDate,String endDate)
	{
		if(pageNum==null)
			pageNum=1;
		int totalCount=transactionService.getCount(transaction,startDate,endDate);
		Page<Transaction> page=transactionService.getTransactionList(transaction,pageNum,totalCount,startDate,endDate);
		model.addAttribute("page",page);
		model.addAttribute("transaction",transaction);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		return "admin/financialMain";
	}
	
	@RequestMapping("/downloadTransactions")
	public void downloadTransactions(HttpServletResponse response)
	{
		List<Transaction> list=transactionService.downloadTransactions();
		byte[] bytes=null;
		try
		{
			bytes=ExcelUtils.generateExcel(list);
			
		
		response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename="  + "transactions.xlsx");
        response.setContentLength(bytes.length);
        response.getOutputStream().write(bytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}