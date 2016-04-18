           package com.hkbu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Components;
import com.hkbu.domain.POrder;
import com.hkbu.domain.POrderdetail;
import com.hkbu.domain.Transaction;
import com.hkbu.dao.ComponentsDao;
import com.hkbu.dao.POrderDao;
import com.hkbu.dao.POrderdetailDao;
import com.hkbu.dao.TransactionDao;
import com.hkbu.mapper.ComponentsMapper;
import com.hkbu.service.ComponentsService;
import com.hkbu.util.MyUtils;

import org.springframework.stereotype.Service;

@Service(value="componentsService")
@Transactional
public class ComponentsServiceImpl implements ComponentsService
{

	@Resource(name="componentsDao")
	private ComponentsDao componentsDao;
	@Resource(name="componentsMapper")
	private ComponentsMapper componentsMapper;
	@Resource(name="pOrderDao")
	private POrderDao pOrderDao;
	@Resource(name="pOrderdetailDao")
	private POrderdetailDao pOrderdetailDao;
    @Resource(name="transactionDao")
	private  TransactionDao transactionDao;

	@Override
	public List<Components> getInsufficientComponents()
	{
		
		return componentsDao.getInsufficientComponents();
	}

	@Override
	public Map<String, Object> getInsufficientComponentCount()
	{
		
		Map<String,Object > map= componentsMapper.getInsufficientComponentsCount();
		return map;
	}

	@Override
	public void purchase(Long componentsUuid, Long supplierUuid, int num,float inPrice)
	{
		//generate order
		POrder pOrder=new POrder();
		pOrder.setOrderNum(MyUtils.generatePOrderNum(supplierUuid));
		pOrder.setSupplierUuid(supplierUuid);
		pOrder.setStartTime(new Date());
		pOrder.setStatus(0);
		pOrder.setTotalPrice(inPrice*num);
		pOrderDao.save(pOrder);
		
		
		//generate order Detail
		POrderdetail pOrderdetail=new POrderdetail();
		pOrderdetail.setPorderUuid(pOrder.getUuid());
		pOrderdetail.setComponentsUuid(componentsUuid);
		pOrderdetail.setDate(new Date());
		pOrderdetail.setAmount(num);
		pOrderdetail.setTotalPrice(inPrice*num);
		pOrderdetailDao.save(pOrderdetail);
		
		//get supplier email and send email to supplier
		
		
		//add num to the purchasing components(the process have been simplified)
		Components components=componentsDao.get(componentsUuid);
		if(components.getInventory()==null)
			components.setInventory(0);
		components.setInventory(components.getInventory()+num);
		
		//generate Transaction
		Transaction transaction=new Transaction();
		transaction.setType("buy");
		transaction.setDate(new Date());
		transaction.setMoneyOut(inPrice*num);
		transaction.setporderUuid(pOrder.getUuid());
		transaction.setSupplierUuid(supplierUuid);
		transactionDao.save(transaction);	
	}

	@Override
	public List<Components> getComponentsByTypeId(Long uuid)
	{
		return componentsDao.getComponentsByTypeId(uuid);
	}

}