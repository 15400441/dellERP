package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.EmpService;
import com.hkbu.domain.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController
{
	@Resource(name="empService")
	private EmpService empService;

}