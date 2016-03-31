package com.hkbu.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value="sOrderMapper")
public interface SOrderMapper
{
	List<Map<String, Object>> getOrderDetail(Long uuid);

}
