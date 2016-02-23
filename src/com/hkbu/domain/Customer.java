package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer", catalog = "ebank")
public class Customer implements java.io.Serializable
{

	// Fields

	private Long id;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private String country;
	private String email;
	private String phoneNum;
	private String credentialType;
	private String credentialNo;

	// Constructors

	/** default constructor */
	public Customer()
	{
	}

	/** minimal constructor */
	public Customer(Long id, String name, Integer age, String gender, String address, String country, String phoneNum, String credentialNo)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.country = country;
		this.phoneNum = phoneNum;
		this.credentialNo = credentialNo;
	}

	/** full constructor */
	public Customer(Long id, String name, Integer age, String gender, String address, String country, String email, String phoneNum, String credentialType, String credentialNo)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.country = country;
		this.email = email;
		this.phoneNum = phoneNum;
		this.credentialType = credentialType;
		this.credentialNo = credentialNo;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "age", nullable = false)
	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Column(name = "gender", nullable = false, length = 20)
	public String getGender()
	{
		return this.gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Column(name = "country", nullable = false, length = 50)
	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	@Column(name = "email", length = 50)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "phoneNum", nullable = false, length = 20)
	public String getPhoneNum()
	{
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	@Column(name = "credentialType", length = 2)
	public String getCredentialType()
	{
		return this.credentialType;
	}

	public void setCredentialType(String credentialType)
	{
		this.credentialType = credentialType;
	}

	@Column(name = "credentialNo", nullable = false, length = 30)
	public String getCredentialNo()
	{
		return this.credentialNo;
	}

	public void setCredentialNo(String credentialNo)
	{
		this.credentialNo = credentialNo;
	}

}