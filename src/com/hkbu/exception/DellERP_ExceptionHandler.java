package com.hkbu.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hkbu.exception.AppException;

public class DellERP_ExceptionHandler implements HandlerExceptionResolver
{

	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o , Exception ex)
	{      
		   ModelAndView modelAndView=new ModelAndView();
		      
	        // 根据不同错误转向不同页面  
	        if(ex instanceof AppException) 
	        {  
	        	ex.printStackTrace();
	            modelAndView.setViewName("error");
	            modelAndView.addObject("msg", ex.getMessage());
	            return modelAndView;
	        }
	        else 
	        {
	        	 ex.printStackTrace();
	        	 modelAndView.setViewName("error");
		         modelAndView.addObject("msg","服务器忙");
		         return modelAndView;
			}
	            	
		
	}

}
