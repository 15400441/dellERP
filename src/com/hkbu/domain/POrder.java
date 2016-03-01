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
 * POrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_order", catalog = "dellerp")
public class POrder implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private Long supplierUuid;
	private Date date;
	private Long totalPrice;
	private String status;
	private Long empUuid;

	// Constructors

	/** default constructor */
	public POrder()
	{
	}

	/** minimal constructor */
	public POrder(Long supplierUuid, String status)
	{
		this.supplierUuid = supplierUuid;
		this.status = status;
	}

	/** full constructor */
	public POrder(Long supplierUuid, Date date, Long totalPrice, String status, Long empUuid)
	{
		this.supplierUuid = supplierUuid;
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

	@Column(name = "supplierUuid", nullable = false)
	public Long getSupplierUuid()
	{
		return this.supplierUuid;
	}

	public void setSupplierUuid(Long supplierUuid)
	{
		this.supplierUuid = supplierUuid;
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