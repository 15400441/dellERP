package com.hkbu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkbu.dao.CustomerDao;
import com.hkbu.domain.Customer;
import com.hkbu.service.CustomerService;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService
{
    @Resource(name="customerDao")
	private CustomerDao customerDao;
	public Customer getCustomerById(Long id)
	{	
		return customerDao.get(id);
	}

}
