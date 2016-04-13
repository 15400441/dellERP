package com.hkbu.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_order", catalog = "dellerp")
public class SOrder implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String orderNum;
	private Long customerUuid;
	private Date startTime;
	private Float totalPrice;
	private Integer status;
	private Long empUuid;
	private Date endTime;
	private String des;
	private String statusView;

	// Constructors

	

	/** default constructor */
	public SOrder()
	{
	}

	/** minimal constructor */
	public SOrder(String orderNum, Long customerUuid)
	{
		this.orderNum = orderNum;
		this.customerUuid = customerUuid;
	}

	/** full constructor */
	public SOrder(String orderNum, Long customerUuid, Date startTime, Float totalPrice, Integer status, Long empUuid, Date endTime)
	{
		this.orderNum = orderNum;
		this.customerUuid = customerUuid;
		this.startTime = startTime;
		this.totalPrice = totalPrice;
		this.status = status;
		this.empUuid = empUuid;
		this.endTime = endTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "uuid", unique = true, nullable = false)
	public Long getUuid()
	{
		return this.uuid;
	}

	public void setUuid(Long uuid)
	{
		this.uuid = uuid;
	}

	@Column(name = "orderNum", nullable = false, length = 38)
	public String getOrderNum()
	{
		return this.orderNum;
	}

	public void setOrderNum(String orderNum)
	{
		this.orderNum = orderNum;
	}

	@Column(name = "customerUuid", nullable = false)
	public Long getCustomerUuid()
	{
		return this.customerUuid;
	}

	public void setCustomerUuid(Long customerUuid)
	{
		this.customerUuid = customerUuid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startTime", length = 0)
	public Date getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	@Column(name = "totalPrice", precision = 10, scale = 0)
	public Float getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	@Column(name = "status")
	public Integer getStatus()
	{
		return this.status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
		if(0==status)
		{
			this.statusView="new order";
		}
		if(1==status)
		{
			this.statusView="order need assmble";
		}
		if(2==status)
		{
			this.statusView="deliver";
		}
		if(3==status)
		{
			this.statusView="finished";
		}
		
	}
	
	
	
	@Transient
	public String getStatusView()
	{
		return statusView;
	}


	@Column(name = "empUuid")
	public Long getEmpUuid()
	{
		return this.empUuid;
	}

	public void setEmpUuid(Long empUuid)
	{
		this.empUuid = empUuid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endTime", length = 0)
	public Date getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	@Column(name = "des")
	public String getDes()
	{
		return des;
	}

	public void setDes(String des)
	{
		this.des = des;
	}

}