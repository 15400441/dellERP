package com.hkbu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.domain.ComponentsType;
import com.hkbu.domain.Customer;
import com.hkbu.service.ComponentsTypeService;
import com.hkbu.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController
{
	
	@Resource(name="customerService")
	private CustomerService customerService;
	@Resource(name="componentsTypeService")
	private ComponentsTypeService componentsTypeService;
	
	@RequestMapping("/main")
	  public String customerLoginUI(Model model)
	  {
		List<ComponentsType> list=componentsTypeService.getAll();
		model.addAttribute("componentsTypeList", list);
		return "/main";
	  }
	
	
	
	@ResponseBody
	@RequestMapping("/customerLogin")
	public Map<String, Object> login(Customer customer, HttpSession session ,String checkcode, Model model)
	{
		
		
		    Map<String, Object> map=new HashMap<String, Object>();
			Customer loginCustomer=customerService.login(customer);
			if(loginCustomer==null)
			{
				map.put("msg", "Wrong username or password");
				map.put("success", "0");
			}
			else
			{  
				
				session.setAttribute("customer", loginCustomer);
				Customer updateCustomer=new Customer(loginCustomer);
				updateCustomer.setLastLoginTime(new Date());		
				customerService.update(updateCustomer);
				map.put("msg", "Login successfully");
				map.put("success", "1");
				map.put("customer", loginCustomer);
			}
		
			return map;
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public String register(Customer customer)
	{
		Customer c=customerService.getCustomerByUserName(customer.getUserName().trim());
		if (c!=null)
		{
			return "The username already existed, please change to another one";
		}
		else 
		{
			customerService.register(customer);
			return "Regist successfully";
		}
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/customer/main.do";
	}
	
	@RequestMapping("/test")
	public String test()
	{
		
		//User user=userService.getById(1l);
		//System.out.println(user);
		return "/index";
	}

}
