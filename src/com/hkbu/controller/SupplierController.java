package com.hkbu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.service.SupplierService;
import com.hkbu.domain.Supplier;

@Controller
@RequestMapping("/supplier")
public class SupplierController
{
	@Resource(name="supplierService")
	private SupplierService supplierService;
	
	//Ajax------------------------------------
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Supplier> getAll()
	{
		List<Supplier> list=supplierService.getAll();
		return list;
	}

}