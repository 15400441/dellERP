package com.hkbu.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hkbu.dao.TransactionDao;
import com.hkbu.domain.Transaction;
import com.hkbu.exception.AppException;
import com.hkbu.queryModel.TransactionQueryModel;
import com.hkbu.util.MyUtils;
import com.hkbu.base.BaseDao;
import com.hkbu.base.BaseDaoImpl;
import com.hkbu.base.BaseQueryModel;

@Repository(value="transactionDao")
public class TransactionDaoImpl extends BaseDaoImpl<Transaction> implements TransactionDao
{

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)
	{
		TransactionQueryModel tqm=(TransactionQueryModel) qm;
		if(tqm.getType()!=null && !tqm.getType().trim().equals(""))
			dc.add(Restrictions.eq("type", tqm.getType()));
		if(tqm.getStartDate()!=null 
				&& !tqm.getStartDate().trim().equals("")
				&& tqm.getEndDate()!=null
				&& !tqm.getEndDate().trim().equals(""))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
			
			Date startDate = sdf.parse(tqm.getStartDate());
			Date endDate = sdf.parse(tqm.getEndDate());
			dc.add(Restrictions.between("date", startDate, endDate));
			}
			catch (Exception e) {
				throw new RuntimeException();
			}
			
		}
		
	}

	@Override
	public List<Transaction> getThisMonthTransactionList()
	{
		Map<String, String> dateMap=MyUtils.getStringDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
		
		Date startDate = sdf.parse(dateMap.get("startDate"));
		Date endDate = sdf.parse(dateMap.get("endDate"));
		String hql="from Transaction where date between ? and ?";
		return getHibernateTemplate().find(hql,startDate,endDate);
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
				
	}

	
	

}