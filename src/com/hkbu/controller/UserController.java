package com.hkbu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbu.domain.Customer;
import com.hkbu.domain.User;

import com.hkbu.service.CustomerService;
import com.hkbu.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController
{
	@Resource(name="userService")
	private UserService userService;
	
	
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@RequestMapping("/userLoginUI")
	  public String customerLoginUI()
	  {
		 
		  return "/login";
	  }
	
	
	@RequestMapping("/login")
	public String login(User user, HttpSession session ,String checkcode, Model model)
	{
		//检测用户是否已经登录
		User loginUser=(User) session.getAttribute("user");
		if(loginUser!=null)
		{
			return "/main";
		}
		
		String code=(String) session.getAttribute("checkcode");
		
		if(code!=null && code.equalsIgnoreCase(checkcode))
		{
		    loginUser=userService.login(user);
			if(loginUser==null)
			{
				model.addAttribute("msg", "用户名或密码错误");
				return "forward:/user/userLoginUI.do";
			}
			else
			{  
				Customer customer=customerService.getCustomerById(loginUser.getCusId());
				session.setAttribute("user", loginUser);
				session.setAttribute("customer", customer);
				User updateUser=new User(loginUser);
				updateUser.setLastLoginTime(new Date());
			
				userService.updateUser(updateUser);
				return "/main";
			}
		}
		else 
		{
			
			model.addAttribute("msg", "验证码错误");
			return "forward:/user/userLoginUI.do";
		}
			
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "forward:/user/userLoginUI.do";
	}
	
	@RequestMapping("/test")
	public String test()
	{
		
		//User user=userService.getById(1l);
		//System.out.println(user);
		return "/index";
	}

}
