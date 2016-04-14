package com.hkbu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import com.hkbu.domain.Components;
import com.hkbu.domain.SOrder;
import com.hkbu.domain.SOrderdetail;
import com.hkbu.domain.Transaction;
import com.hkbu.dao.ComponentsDao;
import com.hkbu.dao.EmpDao;
import com.hkbu.dao.SOrderDao;
import com.hkbu.dao.SOrderdetailDao;
import com.hkbu.dao.TransactionDao;
import com.hkbu.mapper.SOrderMapper;

import com.hkbu.queryModel.SOrderQueryModel;
import com.hkbu.service.EmpService;
import com.hkbu.service.SOrderService;
import com.hkbu.util.MyUtils;

import org.springframework.stereotype.Service;

@Service(value = "sOrderService")
@Transactional
public class SOrderServiceImpl implements SOrderService
{

	@Resource(name = "sOrderDao")
	private SOrderDao sOrderDao;

	@Resource(name = "sOrderMapper")
	private SOrderMapper sOrderMapper;
	
	@Resource(name="componentsDao")
	private ComponentsDao componentsDao;
	
	@Resource(name="sOrderdetailDao")
	private SOrderdetailDao sOrderdetailDao;
	
	@Resource(name="transactionDao")
	private TransactionDao transactionDao;
	

	@Override
	public List<SOrder> getOrderListByStatus(Integer status, Long empUuid, int pageNum, int pageSize)
	{
		SOrderQueryModel qm = new SOrderQueryModel();

		qm.setStatus(status);

		qm.setEmpUuid(empUuid);
		return sOrderDao.getAll(qm, pageNum, pageSize);
	}

	@Override
	public Integer getCount(Integer status, Long empUuid)
	{
		SOrderQueryModel qm = new SOrderQueryModel();

		qm.setStatus(status);

		qm.setEmpUuid(empUuid);
		return sOrderDao.getCount(qm);
	}

	@Override
	public List<Map<String, Object>> getOrderDetailViewList(Long uuid)
	{

		return sOrderMapper.getOrderDetail(uuid);
	}

	@Override
	public void update(Long uuid, int status)
	{
		SOrder sOrder=sOrderDao.get(uuid);
		sOrder.setStatus(status);
		
	}

	@Override
	public void assignOrder(Long empUuid, Long orderUuid)
	{
		SOrder sOrder=sOrderDao.get(orderUuid);
		sOrder.setEmpUuid(empUuid);
		sOrder.setStatus(1);
		
		List<SOrderdetail> sOrderdetails=sOrderdetailDao.getBySOrderUuid(orderUuid);
		for (SOrderdetail d : sOrderdetails)
		{
			Components components=componentsDao.get(d.getComponentsUuid());
			components.setInventory(components.getInventory()-d.getAmount());
		}
		
		
	}

	@Override
	public void generateOrder(Long[] uuid, Integer[] num,Long customerUuid)
	{
		List<SOrderdetail> sOrderdetailList=new ArrayList<SOrderdetail>();
		float totalPrice=0;
		for (int i = 0; i < uuid.length; i++)
		{
			
			if(uuid[i]!=null)
			{
				Components components=componentsDao.get(uuid[i]);
				float price=(float) (components.getOutPrice()*num[i]);
				SOrderdetail sOrderdetail=new SOrderdetail();
				sOrderdetail.setComponentsUuid(uuid[i]);
				sOrderdetail.setDate(new Date());
				sOrderdetail.setAmount(num[i]);
				sOrderdetail.setTotalPrice(price);
				sOrderdetailList.add(sOrderdetail);
				totalPrice=totalPrice+(float) (components.getOutPrice()*num[i]);
			}
		}
		SOrder sOrder=new SOrder();
		sOrder.setOrderNum(MyUtils.generateSOrderNum(customerUuid));
		sOrder.setCustomerUuid(customerUuid);
		sOrder.setStartTime(new Date());
		sOrder.setTotalPrice(totalPrice);
		sOrder.setStatus(0);
		sOrderDao.save(sOrder);
		
		for (SOrderdetail sOrderdetail : sOrderdetailList)
		{
			sOrderdetail.setSorderUuid(sOrder.getUuid());
			sOrderdetailDao.save(sOrderdetail);
		}
		
			
	}

	@Override
	public List<SOrder> getOrderListByCustomerUuid(Long uuid)
	{
		return sOrderDao.getOrderListByCustomerUuid(uuid);
	}

	@Override
	public void confirmOrder(Long uuid,Long customerUuid)
	{
		SOrder sOrder=sOrderDao.get(uuid);
		sOrder.setStatus(3);
		sOrder.setEndTime(new Date());
		
		//generate transaction
		Transaction transaction=new Transaction();
		transaction.setType("sale");
		transaction.setOrderUuid(sOrder.getUuid());
		transaction.setDate(new Date());
		transaction.setCustomerUuid(customerUuid);
		transaction.setMoneyIn(sOrder.getTotalPrice());
		transactionDao.save(transaction);
		
		
		
	}

}