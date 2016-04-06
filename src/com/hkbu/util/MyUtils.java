package com.hkbu.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class MyUtils
{
	public static String getValidCode()
	{
		String code="";
		Random random = new Random();
		for(int i=0; i<=5;i++)
		{
        int a=random.nextInt(10);
        code+=a;
		}		
		return code;
	}
	
	public static String generatePOrderNum(Long uuid)
	{
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		Date date=new Date();
		String num=dateFormat.format(date);
		num=num.replace(" ", "").replace("-", "").replace(":", "")+uuid+2;
		
		System.out.println(num);
		return num;
		
	}
	
	public static String generateSOrderNum(Long uuid)
	{
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		Date date=new Date();
		String num=dateFormat.format(date);
		num=num.replace(" ", "").replace("-", "").replace(":", "")+uuid+1;
		
		System.out.println(num);
		return num;
		
	}
	
	
	
	public static void main(String[] args)
	{
		Long l=new Long("50.0");
		//generatePOrderNum(l);
		System.out.println(l);
	}
	
	

}
