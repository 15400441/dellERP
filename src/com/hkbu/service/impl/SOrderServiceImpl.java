package com.hkbu.service.impl;

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

}