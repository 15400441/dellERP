package com.hkbu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Supplier;
import com.hkbu.dao.SupplierDao;
import com.hkbu.service.SupplierService;
import org.springframework.stereotype.Service;

@Service(value="supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService
{

@Resource(name="supplierDao")
private SupplierDao supplierDao;

@Override
public List<Supplier> getAll()
{
	
	return supplierDao.getAll();
}

}