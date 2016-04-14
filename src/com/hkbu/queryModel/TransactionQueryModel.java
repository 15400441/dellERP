package com.hkbu.queryModel;

import com.hkbu.base.BaseQueryModel;
import com.hkbu.domain.Transaction;

public class TransactionQueryModel extends Transaction implements BaseQueryModel
{
    private String startDate;
    private String endDate;
    public TransactionQueryModel(String startDate,String endDate)
    {
    	super();
    	this.setStartDate(startDate);
    	this.setEndDate(endDate);
    }
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
}
