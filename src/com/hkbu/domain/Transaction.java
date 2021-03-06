package com.hkbu.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "transaction", catalog = "dellerp")
public class Transaction implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private Date date;
	private Long sorderUuid;
	private Long porderUuid;
	private Long customerUuid;
	private Float moneyIn;
	private Float moneyOut;
	private String type;
	private Long supplierUuid;

	// Constructors

	/** default constructor */
	public Transaction()
	{
	}

	/** minimal constructor */
	public Transaction(Long uuid, String type)
	{
		this.uuid = uuid;
		this.type = type;
	}

	/** full constructor */
	public Transaction(Long uuid, Date date, Long sorderUuid, Long customerUuid, Float moneyIn, Float moneyOut, String type, Long supplierUuid)
	{
		this.uuid = uuid;
		this.date = date;
		this.sorderUuid = sorderUuid;
		this.customerUuid = customerUuid;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
		this.type = type;
		this.supplierUuid = supplierUuid;
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
	
	@Column(name = "porderUuid")
	public Long getporderUuid()
	{
		return this.porderUuid;
	}
	
	public void setporderUuid(Long porderUuid)
	{
		this.porderUuid = porderUuid;
	}

	@Column(name = "sorderUuid")
	public Long getsorderUuid()
	{
		return this.sorderUuid;
	}

	public void setsorderUuid(Long sorderUuid)
	{
		this.sorderUuid = sorderUuid;
	}

	@Column(name = "customerUuid")
	public Long getCustomerUuid()
	{
		return this.customerUuid;
	}

	public void setCustomerUuid(Long customerUuid)
	{
		this.customerUuid = customerUuid;
	}

	@Column(name = "moneyIn", precision = 10, scale = 0)
	public Float getMoneyIn()
	{
		return this.moneyIn;
	}

	public void setMoneyIn(Float moneyIn)
	{
		this.moneyIn = moneyIn;
	}

	@Column(name = "moneyOut", precision = 10, scale = 0)
	public Float getMoneyOut()
	{
		return this.moneyOut;
	}

	public void setMoneyOut(Float moneyOut)
	{
		this.moneyOut = moneyOut;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
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

}