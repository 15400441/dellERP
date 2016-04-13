package com.hkbu.service;

import java.util.List;
import java.util.Map;

import com.hkbu.domain.SOrder;
public interface SOrderService
{

	List<SOrder> getOrderListByStatus(Integer status, Long empUuid, int pageNum, int  pageSize);

	Integer getCount(Integer status, Long empUuid);

	List<Map<String, Object>> getOrderDetailViewList(Long uuid);

	void update(Long uuid, int status);

	void assignOrder(Long empUuid, Long orderUuid);

	void generateOrder(Long[] uuid, Integer[] num, Long customerUuid);

	List<SOrder> getOrderListByCustomerUuid(Long uuid);

	void confirmOrder(Long uuid, Long customerUuid);

	

}