package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmpRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp_role", catalog = "dellerp")
public class EmpRole implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private Long empUuid;
	private Long roleUuid;

	// Constructors

	/** default constructor */
	public EmpRole()
	{
	}

	/** full constructor */
	public EmpRole(Long empUuid, Long roleUuid)
	{
		this.empUuid = empUuid;
		this.roleUuid = roleUuid;
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

	@Column(name = "empUuid", nullable = false)
	public Long getEmpUuid()
	{
		return this.empUuid;
	}

	public void setEmpUuid(Long empUuid)
	{
		this.empUuid = empUuid;
	}

	@Column(name = "roleUuid", nullable = false)
	public Long getRoleUuid()
	{
		return this.roleUuid;
	}

	public void setRoleUuid(Long roleUuid)
	{
		this.roleUuid = roleUuid;
	}

}