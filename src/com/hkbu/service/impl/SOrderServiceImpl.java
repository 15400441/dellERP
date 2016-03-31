package com.hkbu.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.SOrder;
import com.hkbu.dao.SOrderDao;
import com.hkbu.mapper.SOrderMapper;

import com.hkbu.queryModel.SOrderQueryModel;
import com.hkbu.service.SOrderService;
import org.springframework.stereotype.Service;

@Service(value = "sOrderService")
@Transactional
public class SOrderServiceImpl implements SOrderService
{

	@Resource(name = "sOrderDao")
	private SOrderDao sOrderDao;

	@Resource(name = "sOrderMapper")
	private SOrderMapper sOrderMapper;

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

}