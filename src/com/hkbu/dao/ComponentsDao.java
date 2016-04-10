package com.hkbu.dao;

import java.util.List;

import com.hkbu.base.BaseDao;
import com.hkbu.domain.Components;

public interface ComponentsDao extends BaseDao<Components>
{

	List<Components> getInsufficientComponents();

	List<Components> getComponentsByTypeId(Long uuid);

}
