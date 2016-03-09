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
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer", catalog = "dellerp")
public class Customer implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String userName;
	private String pwd;
	private String name;
	private String email;
	private String tele;
	private Integer gender;
	private String address;
	private Date lastLoginTime;
	private String creditStatus;

	// Constructors

	/** default constructor */
	public Customer()
	{
	}

	/** minimal constructor */
	public Customer(String userName, String pwd, String name)
	{
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
	}

	/** full constructor */
	public Customer(String userName, String pwd, String name, String email, String tele, Integer gender, String address, Date lastLoginTime, String creditStatus)
	{
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tele = tele;
		this.gender = gender;
		this.address = address;
		this.lastLoginTime = lastLoginTime;
		this.creditStatus = creditStatus;
	}

	public Customer(Customer customer)
	{
		this.userName = customer.getUserName();
		this.pwd = customer.getPwd();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.tele = customer.getTele();
		this.gender = customer.getGender();
		this.address = customer.getAddress();
		this.lastLoginTime = customer.getLastLoginTime();
		this.creditStatus = customer.getCreditStatus();
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

	@Column(name = "userName", nullable = false, length = 30)
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "pwd", nullable = false, length = 32)
	public String getPwd()
	{
		return this.pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "tele", length = 30)
	public String getTele()
	{
		return this.tele;
	}

	public void setTele(String tele)
	{
		this.tele = tele;
	}

	@Column(name = "gender")
	public Integer getGender()
	{
		return this.gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	@Column(name = "address")
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lastLoginTime", length = 0)
	public Date getLastLoginTime()
	{
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "creditStatus", length = 20)
	public String getCreditStatus()
	{
		return this.creditStatus;
	}

	public void setCreditStatus(String creditStatus)
	{
		this.creditStatus = creditStatus;
	}

}