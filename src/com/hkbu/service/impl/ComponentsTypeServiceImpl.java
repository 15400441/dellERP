package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.ComponentsType;
import com.hkbu.dao.ComponentsTypeDao;
import com.hkbu.service.ComponentsTypeService;
import org.springframework.stereotype.Service;

@Service(value="componentsTypeService")
@Transactional
public class ComponentsTypeServiceImpl implements ComponentsTypeService
{

	@Resource(name="componentsTypeDao")
	private ComponentsTypeDao componentsTypeDao;

}