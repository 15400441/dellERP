package com.hkbu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/ui")
public class UIController
{
	
	@RequestMapping("/code404")
	public String code404()
	{
		return "/404";
	}
	
	@RequestMapping("/empLoginUI")
	public String empLogin()
	{
		return "/admin/login";
	}
	
	

}
