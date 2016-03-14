package com.hkbu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.SOrder;
import com.hkbu.dao.SOrderDao;
import com.hkbu.service.SOrderService;
import org.springframework.stereotype.Service;

@Service(value="sOrderService")
@Transactional
public class SOrderServiceImpl implements SOrderService
{

	@Resource(name="sOrderDao")
	private SOrderDao sOrderDao;

	@Override
	public List<SOrder> getOrderListByStatus(String status)
	{
		
		return sOrderDao.getOrderListByStatus(status);
	}

}