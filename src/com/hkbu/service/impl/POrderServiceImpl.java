package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.POrder;
import com.hkbu.dao.POrderDao;
import com.hkbu.service.POrderService;
import org.springframework.stereotype.Service;

@Service(value="pOrderService")
@Transactional
public class POrderServiceImpl implements POrderService
{

	@Resource(name="pOrderDao")
	private POrderDao pOrderDao;

}