package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.EmpRoleService;
import com.hkbu.domain.EmpRole;

@Controller
@RequestMapping("/empRole")
public class EmpRoleController
{
	@Resource(name="empRoleService")
	private EmpRoleService empRoleService;

}