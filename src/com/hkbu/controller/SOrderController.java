package com.hkbu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.service.SOrderService;
import com.hkbu.base.Page;
import com.hkbu.base.Result;
import com.hkbu.domain.Customer;
import com.hkbu.domain.Emp;
import com.hkbu.domain.SOrder;

@Controller
@RequestMapping("/sOrder")
public class SOrderController
{
	@Resource(name = "sOrderService")
	private SOrderService sOrderService;

	@RequestMapping("orderList")
	public String orderList(Integer status, Long empUuid, Model model, Integer pageNum, HttpSession session)
	{
		String role = (String) session.getAttribute("role");
		if(role==null)
			return "redirect:/ui/empLoginUI.do";
		if (null == pageNum)
			pageNum = 1;
		if (null == status)
			status = 0;
		empUuid = ((Emp) session.getAttribute("loginEmp")).getUuid();
		if ("001".equals(role))
			;
		empUuid = null;
		int totalCount = sOrderService.getCount(status, empUuid);
		Page page = new Page<List<Map<String, Object>>>(5, pageNum, totalCount);
		List<SOrder> list = sOrderService.getOrderListByStatus(status, empUuid, pageNum, page.getPageSize());
		page.setRecords(list);
		model.addAttribute("page", page);
		model.addAttribute("status", status);

		if ("001".equals(role))
			return "admin/sOrders";
		if ("002".equals(role))
			return "admin/empAssembly";
		return null;

	}

	@RequestMapping("getDetail")
	public String getDetail(Long uuid, Model model, HttpSession session)
	{
		String role = (String) session.getAttribute("role");
		List<Map<String, Object>> orderDetailViewList = sOrderService.getOrderDetailViewList(uuid);
		model.addAttribute("orderDetailViewList", orderDetailViewList);
		
		if ("001".equals(role))
			return "admin/sOrderDetail";
		if ("002".equals(role))
			return "admin/sOrderDetailForAssemblyEmp";
		return null;
		
	}

	@RequestMapping("assignOrder")
	public String assignOrder(Long empUuid, Long orderUuid, Model model, HttpSession session)
	{
		sOrderService.assignOrder(empUuid, orderUuid);

		return "redirect:/sOrder/orderList";
	}

	@RequestMapping("/generateOrder")
	public String generateOrder(Long[] uuid, Integer[] num, HttpSession session, Model model)
	{
		Customer customer = (Customer) session.getAttribute("customer");

		if (customer == null)
		{
			model.addAttribute("info", "please login first");
			return "forward:/customer/main";
		}
		boolean flag = false;
		
		for (int i = 0; i < uuid.length; i++)
		{
			if (uuid[i] != null)
			{
				flag = true;
			}

		}
		if (!flag)
		{
			model.addAttribute("info", "please choose components first");
			return "forward:/customer/main";
		} else
		{

			for (int i = 0; i < uuid.length; i++)
			{
				if (uuid[i] != null && !(num[i] >= 1))
				{
					model.addAttribute("info", "please input correct components number");
					return "forward:/customer/main";
				}

			}

			sOrderService.generateOrder(uuid, num, customer.getUuid());
			
			return "redirect:/sOrder/getOrderListByCustomerUuid.do";
		}
	}

	@RequestMapping("/getOrderListByCustomerUuid")
	public String getOrderListByCustomerUuid(Model model,HttpSession session)
	{
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer==null)
		{
			return "redirect:/customer/main.do";
		}
		List<SOrder> sOrderList = sOrderService.getOrderListByCustomerUuid(customer.getUuid());
		model.addAttribute("sOrderList", sOrderList);
		return "/sOrders";
	}
	
	
	@RequestMapping("/confirmOrder")
	public String confirmOrder(Long uuid, Model model, HttpSession session)
	{
		Customer customer = (Customer) session.getAttribute("customer");
		sOrderService.confirmOrder(uuid,customer.getUuid());
		return "redirect:/sOrder/getOrderListByCustomerUuid.do";
	}

	// ajax----------------------------------------------------------------------------
	@RequestMapping("getCount")
	@ResponseBody
	public Map<String, Object> getCount(Integer status, Long empUuid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = sOrderService.getCount(status, empUuid);
		map.put("count", count);
		return map;

	}

}