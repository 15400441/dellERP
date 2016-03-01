package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dep entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dep", catalog = "dellerp")
public class Dep implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String name;
	private String tele;

	// Constructors

	/** default constructor */
	public Dep()
	{
	}

	/** full constructor */
	public Dep(String name, String tele)
	{
		this.name = name;
		this.tele = tele;
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

	@Column(name = "tele", nullable = false, length = 26)
	public String getTele()
	{
		return this.tele;
	}

	public void setTele(String tele)
	{
		this.tele = tele;
	}

}