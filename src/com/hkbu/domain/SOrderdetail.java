package com.hkbu.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SOrderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_orderdetail", catalog = "dellerp")
public class SOrderdetail implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private Long sorderUuid;
	private Long componentsUuid;
	private Date date;
	private Integer amount;
	private Long totalPrice;

	// Constructors

	/** default constructor */
	public SOrderdetail()
	{
	}

	/** minimal constructor */
	public SOrderdetail(Long uuid, Long sorderUuid, Long componentsUuid)
	{
		this.uuid = uuid;
		this.sorderUuid = sorderUuid;
		this.componentsUuid = componentsUuid;
	}

	/** full constructor */
	public SOrderdetail(Long uuid, Long sorderUuid, Long componentsUuid, Date date, Integer amount, Long totalPrice)
	{
		this.uuid = uuid;
		this.sorderUuid = sorderUuid;
		this.componentsUuid = componentsUuid;
		this.date = date;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}

	// Property accessors
	@Id
	@Column(name = "uuid", unique = true, nullable = false)
	public Long getUuid()
	{
		return this.uuid;
	}

	public void setUuid(Long uuid)
	{
		this.uuid = uuid;
	}

	@Column(name = "sOrderUuid", nullable = false)
	public Long getSorderUuid()
	{
		return this.sorderUuid;
	}

	public void setSorderUuid(Long sorderUuid)
	{
		this.sorderUuid = sorderUuid;
	}

	@Column(name = "componentsUuid", nullable = false)
	public Long getComponentsUuid()
	{
		return this.componentsUuid;
	}

	public void setComponentsUuid(Long componentsUuid)
	{
		this.componentsUuid = componentsUuid;
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

	@Column(name = "amount")
	public Integer getAmount()
	{
		return this.amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
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

}