package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.POrderdetailService;
import com.hkbu.domain.POrderdetail;

@Controller
@RequestMapping("/pOrderdetail")
public class POrderdetailController
{
	@Resource(name="pOrderdetailService")
	private POrderdetailService pOrderdetailService;

}