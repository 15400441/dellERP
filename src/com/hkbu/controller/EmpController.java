package com.hkbu.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.EmpService;
import com.hkbu.domain.Customer;
import com.hkbu.domain.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController
{
	@Resource(name="empService")
	private EmpService empService;
	
	@RequestMapping("/login")
	public String login(Emp emp, HttpSession session ,String checkcode, Model model)
	{
		//检测用户是否已经登录
		Emp loginEmp=(Emp) session.getAttribute("loginEmp");
		if(loginEmp!=null)
		{
			return "admin/main";
		}
		
		
			loginEmp=empService.login(emp);
			if(loginEmp==null)
			{
				model.addAttribute("msg", "username or password wrong");
				return "forward:/ui/empLoginUI.do";
			}
			else
			{  
				
				session.setAttribute("loginEmp", loginEmp);
				Emp updateEmp=new Emp(loginEmp);
				if(loginEmp.getLoginTimes()==null)
				{
					loginEmp.setLoginTimes(0);
				}
				updateEmp.setLoginTimes(loginEmp.getLoginTimes()+1);
				updateEmp.setLastLoginTime(new Date());
				empService.update(updateEmp);
				return "admin/main";
			}
		
			
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		
		session.invalidate();
		return "forward:/ui/empLoginUI.do";
	}
	

}