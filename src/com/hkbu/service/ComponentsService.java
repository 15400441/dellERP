package com.hkbu.service;

import java.util.List;
import java.util.Map;

import com.hkbu.domain.Components;
public interface ComponentsService
{

	List<Components> getInsufficientComponents();

	Map<String, Object> getInsufficientComponentCount();

	void purchase(Long componentsUuid, Long supplierUuid, int num, float inPrice);

}