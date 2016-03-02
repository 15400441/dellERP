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
	private Long totalPrice;
	private String status;
	private Long empUuid;
	private Date endTime;

	// Constructors

	/** default constructor */
	public SOrder()
	{
	}

	/** minimal constructor */
	public SOrder(String orderNum, Long customerUuid, String status)
	{
		this.orderNum = orderNum;
		this.customerUuid = customerUuid;
		this.status = status;
	}

	/** full constructor */
	public SOrder(String orderNum, Long customerUuid, Date startTime, Long totalPrice, String status, Long empUuid, Date endTime)
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uuid", unique = true, nullable = false)
	public Long getUuid()
	{
		return this.uuid;
	}

	public void setUuid(Long uuid)
	{
		this.uuid = uuid;
	}

	@Column(name = "orderNum", nullable = false, length = 30)
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
	public Long getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(Long totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	@Column(name = "status", nullable = false, length = 10)
	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
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

}