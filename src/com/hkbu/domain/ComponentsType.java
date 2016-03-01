package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ComponentsType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "components_type", catalog = "dellerp")
public class ComponentsType implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String name;
	private Long supplierUuid;

	// Constructors

	/** default constructor */
	public ComponentsType()
	{
	}

	/** full constructor */
	public ComponentsType(String name, Long supplierUuid)
	{
		this.name = name;
		this.supplierUuid = supplierUuid;
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

	@Column(name = "supplierUuid", nullable = false)
	public Long getSupplierUuid()
	{
		return this.supplierUuid;
	}

	public void setSupplierUuid(Long supplierUuid)
	{
		this.supplierUuid = supplierUuid;
	}

}