package com.hkbu.dao;

import com.hkbu.base.BaseDao;
import com.hkbu.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>
{

	Customer getByUserNameAndPwd(Customer customer);

}
