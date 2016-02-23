package com.hkbu.base;

import java.util.List;

public class Page<T>
{
	private List<T> records;// 查询出来的分页记录
	private int totalRecordsNum;
	private int totalPageSize;
	private int pageSize;
	private int startIndex; // 要显示页面的第一条数据在数据库中的索引
	private int currentPageNum;
	private int prePageNum;
	private int nextPageNum;
	private int startPage; // 页面上显示的开始页码
	private int endPage;
	private String url;

	public Page(int pageSize,int currentPageNum, int totalRecordsNum)
	{
		this.pageSize=pageSize;
		// 如果没有记录，则默认都为0，前台进行判断后进行操作。
		if (totalRecordsNum != 0)
		{
			this.currentPageNum = currentPageNum;
			this.totalRecordsNum = totalRecordsNum;
			if (totalRecordsNum < pageSize)
				totalPageSize = 1;
			totalPageSize = totalRecordsNum % pageSize == 0 ? totalRecordsNum / pageSize : totalRecordsNum / pageSize + 1;

			startIndex = pageSize * (currentPageNum - 1);

			prePageNum = currentPageNum - 1;
			if (prePageNum <= 0)
				prePageNum = 1;

			nextPageNum = currentPageNum + 1;
			if (nextPageNum > totalPageSize)
				nextPageNum = totalPageSize;

			// 放8个页码
			if (totalPageSize <= 8)
			{
				startPage = 1;
				endPage = totalPageSize;
			} else
			{
				startPage = currentPageNum - 4;
				endPage = currentPageNum + 4;
				if (startPage < 1)
				{
					startPage = 1;
					endPage = 8;
				}
				if (endPage > totalPageSize)
				{
					endPage = totalPageSize;
					startPage = endPage - 7;
				}
			}
		}

	}
	

	public List<T> getRecords()
	{
		return records;
	}

	public void setRecords(List<T> records)
	{
		this.records = records;
	}

	public int getTotalRecordsNum()
	{
		return totalRecordsNum;
	}

	public void setTotalRecordsNum(int totalRecordsNum)
	{
		this.totalRecordsNum = totalRecordsNum;
	}

	public int getTotalPageSize()
	{
		return totalPageSize;
	}

	public void setTotalPageSize(int totalPageSize)
	{
		this.totalPageSize = totalPageSize;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getStartIndex()
	{
		return startIndex;
	}

	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}

	public int getCurrentPageNum()
	{
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum)
	{
		this.currentPageNum = currentPageNum;
	}

	public int getPrePageNum()
	{
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum)
	{
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum()
	{
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum)
	{
		this.nextPageNum = nextPageNum;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public int getEndPage()
	{
		return endPage;
	}

	public void setEndPage(int endPage)
	{
		this.endPage = endPage;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
