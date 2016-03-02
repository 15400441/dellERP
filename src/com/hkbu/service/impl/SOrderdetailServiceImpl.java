package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.SOrderdetail;
import com.hkbu.dao.SOrderdetailDao;
import com.hkbu.service.SOrderdetailService;
import org.springframework.stereotype.Service;

@Service(value="sOrderdetailService")
@Transactional
public class SOrderdetailServiceImpl implements SOrderdetailService
{

	@Resource(name="sOrderdetailDao")
	private SOrderdetailDao sOrderdetailDao;

}