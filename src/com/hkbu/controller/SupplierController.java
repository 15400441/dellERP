package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.SupplierService;
import com.hkbu.domain.Supplier;

@Controller
@RequestMapping("/supplier")
public class SupplierController
{
	@Resource(name="supplierService")
	private SupplierService supplierService;

}