package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "supplier", catalog = "dellerp")
public class Supplier implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String name;
	private String address;
	private String tele;
	private String creditStatus;
	private String contactPerson;
	private String email;

	// Constructors

	/** default constructor */
	public Supplier()
	{
	}

	/** minimal constructor */
	public Supplier(String name, String address, String tele, String email)
	{
		this.name = name;
		this.address = address;
		this.tele = tele;
		this.email = email;
	}

	/** full constructor */
	public Supplier(String name, String address, String tele, String creditStatus, String contactPerson, String email)
	{
		this.name = name;
		this.address = address;
		this.tele = tele;
		this.creditStatus = creditStatus;
		this.contactPerson = contactPerson;
		this.email = email;
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

	@Column(name = "name", nullable = false, length = 30)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "address", nullable = false, length = 30)
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Column(name = "tele", nullable = false, length = 30)
	public String getTele()
	{
		return this.tele;
	}

	public void setTele(String tele)
	{
		this.tele = tele;
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

	@Column(name = "contactPerson", length = 30)
	public String getContactPerson()
	{
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}