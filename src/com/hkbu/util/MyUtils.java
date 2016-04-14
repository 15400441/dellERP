package com.hkbu.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class MyUtils
{
	public static String getValidCode()
	{
		String code = "";
		Random random = new Random();
		for (int i = 0; i <= 5; i++)
		{
			int a = random.nextInt(10);
			code += a;
		}
		return code;
	}

	public static String generatePOrderNum(Long uuid)
	{
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		Date date = new Date();
		String num = dateFormat.format(date);
		num = num.replace(" ", "").replace("-", "").replace(":", "") + uuid + 2;

		System.out.println(num);
		return num;

	}

	public static String generateSOrderNum(Long uuid)
	{
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		Date date = new Date();
		String num = dateFormat.format(date);
		num = num.replace(" ", "").replace("-", "").replace(":", "") + uuid + 1;

		System.out.println(num);
		return num;

	}

	public static Map<String, String> getStringDate()
	{
		Map map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		// 设置时间,当前时间不用设置
		// calendar.setTime(new Date());
		// 设置日期为本月最大日期
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		// 打印
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String endDate = format.format(calendar.getTime());

		// 设置日期为本月最小日期
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		String startDate = format.format(calendar.getTime());
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		System.out.println(startDate + "  " + endDate);

		return map;
	}
	
	public static String dateToString(Date date)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d = format.format(date);
		return d;
	}

	public static void main(String[] args)
	{
		getStringDate();
	}

}
