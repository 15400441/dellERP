package com.hkbu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbu.service.SOrderService;
import com.hkbu.base.Page;
import com.hkbu.base.Result;
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
		if (null == pageNum)
			pageNum = 1;
		if(null==status)
			status=0;
		empUuid=((Emp)session.getAttribute("loginEmp")).getUuid();
		int totalCount = sOrderService.getCount(status, empUuid);
		Page page = new Page<List<Map<String, Object>>>(5, pageNum, totalCount);
		List<SOrder> list = sOrderService.getOrderListByStatus(status, empUuid, pageNum, page.getPageSize());
		page.setRecords(list);
		model.addAttribute("page", page);
        model.addAttribute("status", status);
		String role = (String) session.getAttribute("role");
		if ("001".equals(role))
			return "admin/sOrders";
		if ("002".equals(role))
			return "admin/empAssembly";
		return null;

	}

	@RequestMapping("getDetail")
	public String getDetail(Long uuid, Model model)
	{
		List<Map<String, Object>> orderDetailViewList = sOrderService.getOrderDetailViewList(uuid);
		model.addAttribute("orderDetailViewList", orderDetailViewList);
		return "admin/sOrderDetail";
	}
	
	
	@RequestMapping("assignOrder")
	public String assignOrder(Long empUuid, Long orderUuid,Model model,HttpSession session)
	{
		sOrderService.assignOrder(empUuid,orderUuid);
		
		return "redirect:/sOrder/orderList";
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