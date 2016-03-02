package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.ComponentsService;
import com.hkbu.domain.Components;

@Controller
@RequestMapping("/components")
public class ComponentsController
{
	@Resource(name="componentsService")
	private ComponentsService componentsService;

}