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
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp", catalog = "dellerp")
public class Emp implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String userName;
	private String pwd;
	private String name;
	private String empNum;
	private String email;
	private String salary;
	private String tele;
	private Integer gender;
	private String address;
	private Long birthday;
	private Long depUuid;
	private Date lastLoginTime;
	private String lastLoginIp;
	private Integer loginTimes;

	// Constructors

	/** default constructor */
	public Emp()
	{
	}

	/** minimal constructor */
	public Emp(String userName, String pwd)
	{
		this.userName = userName;
		this.pwd = pwd;
	}

	/** full constructor */
	public Emp(String userName, String pwd, String name, String empNum, String email, String salary, String tele, Integer gender, String address, Long birthday, Long depUuid, Date lastLoginTime, String lastLoginIp, Integer loginTimes)
	{
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.empNum = empNum;
		this.email = email;
		this.salary = salary;
		this.tele = tele;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.depUuid = depUuid;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginTimes = loginTimes;
	}
	
	public Emp(Emp emp)
	{
		this .uuid=emp.getUuid();
		this.userName=emp.getUserName();
		this.pwd = emp.getPwd();
		this.name = emp.getName();
		this.empNum = emp.getEmpNum();
		this.email = emp .getEmail();
		this.salary = emp.getSalary();
		this.tele = emp.getTele();
		this.gender = emp.getGender();
		this.address = emp.getAddress();
		this.birthday = emp.getBirthday();
		this.depUuid = emp.getDepUuid();
		this.lastLoginTime = emp.getLastLoginTime();
		this.lastLoginIp = emp.getLastLoginIp();
		this.loginTimes = emp. getLoginTimes();
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

	@Column(name = "name", length = 30)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "empNum", length = 20)
	public String getEmpNum()
	{
		return this.empNum;
	}

	public void setEmpNum(String empNum)
	{
		this.empNum = empNum;
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

	@Column(name = "salary", length = 10)
	public String getSalary()
	{
		return this.salary;
	}

	public void setSalary(String salary)
	{
		this.salary = salary;
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

	@Column(name = "birthday")
	public Long getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(Long birthday)
	{
		this.birthday = birthday;
	}

	@Column(name = "depUuid")
	public Long getDepUuid()
	{
		return this.depUuid;
	}

	public void setDepUuid(Long depUuid)
	{
		this.depUuid = depUuid;
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

	@Column(name = "lastLoginIp")
	public String getLastLoginIp()
	{
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp)
	{
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "loginTimes")
	public Integer getLoginTimes()
	{
		return this.loginTimes;
	}

	public void setLoginTimes(Integer loginTimes)
	{
		this.loginTimes = loginTimes;
	}

}