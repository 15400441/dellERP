package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.SOrderService;
import com.hkbu.domain.SOrder;

@Controller
@RequestMapping("/sOrder")
public class SOrderController
{
	@Resource(name="sOrderService")
	private SOrderService sOrderService;

}