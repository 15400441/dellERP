           package com.hkbu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Components;
import com.hkbu.dao.ComponentsDao;
import com.hkbu.mapper.ComponentsMapper;
import com.hkbu.service.ComponentsService;
import org.springframework.stereotype.Service;

@Service(value="componentsService")
@Transactional
public class ComponentsServiceImpl implements ComponentsService
{

	@Resource(name="componentsDao")
	private ComponentsDao componentsDao;
	@Resource(name="componentsMapper")
	private ComponentsMapper componentsMapper;

	@Override
	public List<Components> getInsufficientComponents()
	{
		
		return componentsDao.getInsufficientComponents();
	}

	@Override
	public Map<String, Object> getInsufficientComponentCount()
	{
		
		Map<String,Object > map= componentsMapper.getInsufficientComponentsCount();
		return map;
	}

	@Override
	public void purchase(Long componentsUuid, Long supplierUuid, int num)
	{
		//get supplier email and send email to supplier
		
		//add num to the purchasing components(the process have been simplified)
		Components components=componentsDao.get(componentsUuid);
		if(components.getInventory()==null)
			components.setInventory(0);
		components.setInventory(components.getInventory()+num);
		
	}

}