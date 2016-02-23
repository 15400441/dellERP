package com.hkbu.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T>
{
	private Boolean status;
	private Map<String, Object> map=new HashMap<String, Object>();
	private String msg;
	private List<T> rows=new ArrayList<T>();
	private T t;
	
	public Boolean getStatus()
	{
		return status;
	}
	public void setStatus(Boolean status)
	{
		this.status = status;
	}
	public Map<String, Object> getMap()
	{
		return map;
	}
	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public List<T> getRows()
	{
		return rows;
	}
	public void setRows(List<T> rows)
	{
		this.rows = rows;
	}
	public T getT()
	{
		return t;
	}
	public void setT(T t)
	{
		this.t = t;
	}
	
	

}
