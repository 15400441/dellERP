package com.hkbu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkbu.dao.CustomerDao;
import com.hkbu.domain.Customer;
import com.hkbu.service.CustomerService;
import com.hkbu.util.MD5Utils;

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
	
	public void update(Customer customer)
	{
	 customerDao.update(customer);
		
	}

	
	public Customer login(Customer customer)
	{
		customer.setPwd((MD5Utils.md5(customer.getPwd())));
		return customerDao.getByUserNameAndPwd(customer);
	}

}
