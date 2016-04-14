package com.hkbu.dao;

import java.util.List;

import com.hkbu.domain.SOrderdetail;
import com.hkbu.base.BaseDao;

public interface SOrderdetailDao extends BaseDao<SOrderdetail>
{

	List<SOrderdetail> getBySOrderUuid(Long orderUuid);

}
