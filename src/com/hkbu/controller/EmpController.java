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

import com.hkbu.service.DepService;
import com.hkbu.service.EmpService;
import com.hkbu.service.SOrderService;
import com.hkbu.base.Page;
import com.hkbu.base.Result;
import com.hkbu.domain.Customer;
import com.hkbu.domain.Dep;
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
	@Resource(name="depService")
	private DepService depService;

	@RequestMapping("/login")
	public String login(Emp emp, HttpSession session, String checkcode, Model model)
	{
		// 检测用户是否已经登录
		Emp loginEmp = (Emp) session.getAttribute("loginEmp");
		if (loginEmp != null)
		{
			String loginRole=(String) session.getAttribute("role");
			//for order manager
			if ("001".equals(loginRole))
				return "admin/main";
			//for Assembly department employee
			if ("002".equals(loginRole))
			{
				int status = 1;
				int totalCount = sOrderService.getCount(status, loginEmp.getUuid());
				Page page = new Page<List<Map<String, Object>>>(5, 1, totalCount);
				List<SOrder> list = sOrderService.getOrderListByStatus(status, loginEmp.getUuid(), 1, page.getPageSize());
				page.setRecords(list);
				model.addAttribute("page", page);
				return "admin/empAssembly";
			}
			//for Human Resources department manager
			if ("003".equals(loginRole))
			{
				
				return "forward:/emp/getEmpList.do";
			}
			//for financial department manager
			if ("004".equals(loginRole))
			{
				return "admin/financialMain";
			}
			
		}

		if(emp.getPwd()==null)
		{
			return "forward:/ui/empLoginUI.do";
		}
		loginEmp = empService.login(emp);
		if (loginEmp == null)
		{
			model.addAttribute("msg", "username or password wrong");
			return "forward:/ui/empLoginUI.do";
		} 
		
		//username and password are right
		else
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
				//for order manager
				if ("001".equals(map.get("code")))
				{
					session.setAttribute("role", "001");
					return "admin/main";
				}
				//for aeeembly department employes
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
				//for Human Resources department manager
				if ("003".equals(map.get("code")))
				{
					session.setAttribute("role", "003");
					return "forward:/emp/getEmpList.do";
				}
				//for financial department manager
				if ("004".equals(map.get("code")))
				{
					session.setAttribute("role", "004");
					return "admin/financialMain";
				}
			}

			return "/ui/404";

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
	
	@RequestMapping("/getEmpList")
	public  String getEmpList(Emp emp, Integer pageNum,Model model,HttpSession session)
	{
		//get department
		List<Dep> depList=depService.getAll();
		
		session.setAttribute("searchEmp", emp);
		if(pageNum==null || pageNum==0)
			pageNum=1;
		int totalCount = empService.getCount(emp);
		Page page = new Page<List<Map<String, Object>>>(5, pageNum, totalCount);
		List<Emp> list = empService.getEmpList(emp, pageNum, page.getPageSize());
		page.setRecords(list);
		model.addAttribute("depList",depList);
		model.addAttribute("page", page);
		return "admin/humanResourcesMain";
	}
	
	
	@RequestMapping("/empUpdateUI")
	public String empUpdateUI(Long uuid,Model model)
	{
		Emp emp=empService.findEmp(uuid);
		List<Dep> depList=depService.getAll();
		
		model.addAttribute("depList", depList);
		model.addAttribute("updateEmp", emp);
		return "admin/empInfo";
	}
	
	@RequestMapping("/empUpdate")
	public String empUpdate(Emp emp,Model model)
	{
		empService.updateEmp(emp);
		model.addAttribute("msg", "update successfully");
		return empUpdateUI(emp.getUuid(), model);
	}
	
	@RequestMapping("/empAddUI")
	public String empAddUI(Model model)
	{
		
		List<Dep> depList=depService.getAll();		
		model.addAttribute("depList", depList);
		model.addAttribute("add", "add");
		return "admin/empInfo"; 
	}
	
	
	@RequestMapping("/empAdd")
	public String empAdd(Emp emp,Model model)
	{
		empService.add(emp);
		model.addAttribute("msg", "add successfully");
		return "forward:/emp/getEmpList.do";
	}
	
	@RequestMapping("/empDelete")
	public String empDelete(Long uuid,Model model)
	{
		empService.deleteEmp(uuid);
		model.addAttribute("msg", "delete successfully");
		return "forward:/emp/getEmpList.do";
	}
	
	//ajax------------------------------------------------------------
	@ResponseBody
	@RequestMapping("/getEmpInfo")
	public List<Map<String, Object>> getEmpInfo(Integer pageNum, Integer pageSize)
	{
		if(null==pageNum)
			pageNum=1;
		Result<Map<String, Object>> result=new Result<Map<String,Object>>();
		List<Map<String, Object>> rows= empService.getEmpInfo();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		result.setMap(map);
		result.setRows(rows);
		return rows;
	}

}