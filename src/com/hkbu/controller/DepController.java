package com.hkbu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hkbu.service.DepService;
import com.hkbu.domain.Dep;

@Controller
@RequestMapping("/dep")
public class DepController
{
	@Resource(name="depService")
	private DepService depService;

}