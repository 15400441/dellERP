package com.hkbu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.service.EmpService;
import com.hkbu.service.SOrderService;
import com.hkbu.base.Page;
import com.hkbu.domain.Customer;
import com.hkbu.domain.Emp;
import com.hkbu.domain.SOrder;

@Controller
@RequestMapping("/emp")
public class EmpController
{
	@Resource(name = "empService")
	private EmpService empService;
	@Resource(name = "sOrderService")
	private SOrderService sOrderService;

	@RequestMapping("/login")
	public String login(Emp emp, HttpSession session, String checkcode, Model model)
	{
		// 检测用户是否已经登录
		Emp loginEmp = (Emp) session.getAttribute("loginEmp");
		if (loginEmp != null)
		{
			if ("001".equals(session.getAttribute("role")))
				return "admin/main";
			if ("002".equals(session.getAttribute("role")))
			{
				int status = 1;
				int totalCount = sOrderService.getCount(status, loginEmp.getUuid());
				Page page = new Page<List<Map<String, Object>>>(5, 1, totalCount);
				List<SOrder> list = sOrderService.getOrderListByStatus(status, loginEmp.getUuid(), 1, page.getPageSize());
				page.setRecords(list);
				model.addAttribute("page", page);
				return "admin/empAssembly";
			}
		}

		loginEmp = empService.login(emp);
		if (loginEmp == null)
		{
			model.addAttribute("msg", "username or password wrong");
			return "forward:/ui/empLoginUI.do";
		} else
		{

			session.setAttribute("loginEmp", loginEmp);
			Emp updateEmp = new Emp(loginEmp);
			if (loginEmp.getLoginTimes() == null)
			{
				loginEmp.setLoginTimes(0);
			}
			updateEmp.setLoginTimes(loginEmp.getLoginTimes() + 1);
			updateEmp.setLastLoginTime(new Date());
			empService.update(updateEmp);

			// get the roles of the login emp
			List<Map<String, Object>> roleList = empService.getRoleList(loginEmp.getUuid());
			for (Map map : roleList)
			{
				if ("001".equals(map.get("code")))
				{
					session.setAttribute("role", "001");
					return "admin/main";
				}
				if ("002".equals(map.get("code")))
				{
					session.setAttribute("role", "002");
					// load orders have been assigned
					int status = 1;
					int totalCount = sOrderService.getCount(status, loginEmp.getUuid());
					Page page = new Page<List<Map<String, Object>>>(5, 1, totalCount);
					List<SOrder> list = sOrderService.getOrderListByStatus(status, loginEmp.getUuid(), 1, page.getPageSize());
					page.setRecords(list);
					model.addAttribute("page", page);
					return "admin/empAssembly";
				}
			}

			return null;

		}

	}
	
	@RequestMapping("/changeSorderStatus")
	public String changeSOrderStatus(Long uuid,int status,Model model)
	{
		sOrderService.update(uuid,status);
		return "forward:/emp/login.do";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{

		session.invalidate();
		return "forward:/ui/empLoginUI.do";
	}
	
	
	
	//ajax------------------------------------------------------------
	@ResponseBody
	@RequestMapping("/getEmpInfo")
	public Map<String, Object> getEmpInfo()
	{
		Map map=new HashMap<String, Object>();
		
		return map;
	}

}