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
	private Long customerUuid;
	private Date date;
	private Long totalPrice;
	private String status;
	private Long empUuid;

	// Constructors

	/** default constructor */
	public SOrder()
	{
	}

	/** minimal constructor */
	public SOrder(Long customerUuid, String status)
	{
		this.customerUuid = customerUuid;
		this.status = status;
	}

	/** full constructor */
	public SOrder(Long customerUuid, Date date, Long totalPrice, String status, Long empUuid)
	{
		this.customerUuid = customerUuid;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
		this.empUuid = empUuid;
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
	@Column(name = "date", length = 0)
	public Date getDate()
	{
		return this.date;
	}

	public void setDate(Date date)
	{
		this.date = date;
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

}