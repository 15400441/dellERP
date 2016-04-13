package com.hkbu.dao;

import java.util.List;

import com.hkbu.domain.SOrder;
import com.hkbu.base.BaseDao;

public interface SOrderDao extends BaseDao<SOrder>
{

	List<SOrder> getOrderListByCustomerUuid(Long uuid);

	

}
