package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Components;
import com.hkbu.dao.ComponentsDao;
import com.hkbu.service.ComponentsService;
import org.springframework.stereotype.Service;

@Service(value="componentsService")
@Transactional
public class ComponentsServiceImpl implements ComponentsService
{

	@Resource(name="componentsDao")
	private ComponentsDao componentsDao;

}