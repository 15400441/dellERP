package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.POrderdetail;
import com.hkbu.dao.POrderdetailDao;
import com.hkbu.service.POrderdetailService;
import org.springframework.stereotype.Service;

@Service(value="pOrderdetailService")
@Transactional
public class POrderdetailServiceImpl implements POrderdetailService
{

	@Resource(name="pOrderdetailDao")
	private POrderdetailDao pOrderdetailDao;

}