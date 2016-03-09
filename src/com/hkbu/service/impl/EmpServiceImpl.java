package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Emp;
import com.hkbu.dao.EmpDao;
import com.hkbu.service.EmpService;
import org.springframework.stereotype.Service;

@Service(value="empService")
@Transactional
public class EmpServiceImpl implements EmpService
{

	@Resource(name="empDao")
	private EmpDao empDao;

}