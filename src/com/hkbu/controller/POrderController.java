package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.POrderService;
import com.hkbu.domain.POrder;

@Controller
@RequestMapping("/pOrder")
public class POrderController
{
	@Resource(name="pOrderService")
	private POrderService pOrderService;

}