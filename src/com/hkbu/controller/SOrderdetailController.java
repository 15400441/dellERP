package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.SOrderdetailService;
import com.hkbu.domain.SOrderdetail;

@Controller
@RequestMapping("/sOrderdetail")
public class SOrderdetailController
{
	@Resource(name="sOrderdetailService")
	private SOrderdetailService sOrderdetailService;
	
	

}