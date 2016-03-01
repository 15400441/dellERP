package com.hkbu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbu.domain.Customer;
import com.hkbu.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController
{
	
	
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@RequestMapping("/customerLoginUI")
	  public String customerLoginUI()
	  {
		 
		  return "/customerLogin";
	  }
	
	
	@RequestMapping("/customerLogin")
	public String login(Customer customer, HttpSession session ,String checkcode, Model model)
	{
		//检测用户是否已经登录
		Customer loginCustomer=(Customer) session.getAttribute("customer");
		if(loginCustomer!=null)
		{
			return "/main";
		}
		
		String code=(String) session.getAttribute("checkcode");
		
		if(code!=null && code.equalsIgnoreCase(checkcode))
		{
			loginCustomer=customerService.login(customer);
			if(loginCustomer==null)
			{
				model.addAttribute("msg", "用户名或密码错误");
				return "forward:/customer/customerLoginUI.do";
			}
			else
			{  
				
				session.setAttribute("customer", customer);
				Customer updateCustomer=new Customer(customer);
				updateCustomer.setLastLoginTime(new Date());
			
				customerService.update(customer);
				return "/main";
			}
		}
		else 
		{
			
			model.addAttribute("msg", "验证码错误");
			return "forward:/customer/customerLoginUI.do";
		}
			
	}
	
	@RequestMapping("/customerLogout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "forward:/customer/customerLoginUI.do";
	}
	
	@RequestMapping("/test")
	public String test()
	{
		
		//User user=userService.getById(1l);
		//System.out.println(user);
		return "/index";
	}

}
