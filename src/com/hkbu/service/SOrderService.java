package com.hkbu.service;

import java.util.List;

import com.hkbu.domain.SOrder;
public interface SOrderService
{

	List<SOrder> getOrderListByStatus(String status);

}