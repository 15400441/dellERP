package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.ComponentsTypeService;
import com.hkbu.domain.ComponentsType;

@Controller
@RequestMapping("/componentsType")
public class ComponentsTypeController
{
	@Resource(name="componentsTypeService")
	private ComponentsTypeService componentsTypeService;

}