package com.hkbu.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value="componentsMapper")
public interface ComponentsMapper
{
	Map<String, Object> getInsufficientComponentsCount();
}
