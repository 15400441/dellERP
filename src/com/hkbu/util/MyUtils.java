package com.hkbu.util;

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
	
	
	
	
	public static void main(String[] args)
	{
		
	}
	
	

}
