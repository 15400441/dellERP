package com.hkbu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.service.ComponentsService;
import com.hkbu.domain.Components;

@Controller
@RequestMapping("/components")
public class ComponentsController
{
	@Resource(name="componentsService")
	private ComponentsService componentsService;
	
	
	@RequestMapping("/getInsufficientComponents")
	public String getInsufficientComponents(Model model)
	{
		List<Components> list=componentsService.getInsufficientComponents();
		model.addAttribute("components", list);
		return "admin/components";
	}
	
	@RequestMapping("/purchase")
	public String purchase(Long componentsUuid,Long supplierUuid,int num, float inPrice)
	{
		componentsService.purchase(componentsUuid,supplierUuid,num,inPrice);
		return "redirect:/components/getInsufficientComponents";
	}
	
	
	
	//Ajax------------------------------------------------
	@RequestMapping("/getInsufficientComponentCount")
	@ResponseBody
	public Map<String, Object> getInsufficientComponentCount()
	{
		return componentsService.getInsufficientComponentCount();
	}

}