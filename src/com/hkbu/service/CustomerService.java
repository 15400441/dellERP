package com.hkbu.service;

import com.hkbu.domain.Customer;

public interface CustomerService
{
    Customer getCustomerById(Long id);

	void update(Customer customer);

	Customer login(Customer customer);

	
}
