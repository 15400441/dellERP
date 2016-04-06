package com.hkbu.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_order", catalog = "dellerp")
public class POrder implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String orderNum;
	private Long supplierUuid;
	private Date startTime;
	private Long totalPrice;
	private Integer status;
	private Long empUuid;
	private Date endTime;

	// Constructors

	/** default constructor */
	public POrder()
	{
	}

	/** minimal constructor */
	public POrder(String orderNum)
	{
		this.orderNum = orderNum;
	}

	/** full constructor */
	public POrder(String orderNum, Long supplierUuid, Date startTime, Long totalPrice, Integer status, Long empUuid, Date endTime)
	{
		this.orderNum = orderNum;
		this.supplierUuid = supplierUuid;
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

	@Column(name = "orderNum", nullable = false, length = 30)
	public String getOrderNum()
	{
		return this.orderNum;
	}

	public void setOrderNum(String orderNum)
	{
		this.orderNum = orderNum;
	}

	@Column(name = "supplierUuid")
	public Long getSupplierUuid()
	{
		return this.supplierUuid;
	}

	public void setSupplierUuid(Long supplierUuid)
	{
		this.supplierUuid = supplierUuid;
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

	@Column(name = "status")
	public Integer getStatus()
	{
		return this.status;
	}

	public void setStatus(Integer status)
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