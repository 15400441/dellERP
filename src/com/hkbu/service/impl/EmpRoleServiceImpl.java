package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.EmpRole;
import com.hkbu.dao.EmpRoleDao;
import com.hkbu.service.EmpRoleService;
import org.springframework.stereotype.Service;

@Service(value="empRoleService")
@Transactional
public class EmpRoleServiceImpl implements EmpRoleService
{

	@Resource(name="empRoleDao")
	private EmpRoleDao empRoleDao;

}