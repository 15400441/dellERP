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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "ebank")
public class User implements java.io.Serializable
{

	// Fields

	private Long id;
	private String username;
	private String password;
	private Long cusId;
	private Date openDate;
	private String status;
	private String tipNote;
	private Integer loginTimes;
	private Date lastLoginTime;

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** minimal constructor */
	public User(String username, String password, Long cusId, Date openDate, String status)
	{
		this.username = username;
		this.password = password;
		this.cusId = cusId;
		this.openDate = openDate;
		this.status = status;
	}

	/** full constructor */
	public User(String username, String password, Long cusId, Date openDate, String status, String tipNote, Integer loginTimes, Date lastLoginTime)
	{
		this.username = username;
		this.password = password;
		this.cusId = cusId;
		this.openDate = openDate;
		this.status = status;
		this.tipNote = tipNote;
		this.loginTimes = loginTimes;
		this.lastLoginTime = lastLoginTime;
	}

	public User(User user)
	{
		this.id=user.id;
		this.username = user.username;
		this.password = user.password;
		this.cusId = user.cusId;
		this.openDate = user.openDate;
		this.status = user.status;
		this.tipNote = user.tipNote;
		this.loginTimes = user.loginTimes;
		this.lastLoginTime = user.lastLoginTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "cusId", nullable = false)
	public Long getCusId()
	{
		return this.cusId;
	}

	public void setCusId(Long cusId)
	{
		this.cusId = cusId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "openDate", nullable = false, length = 0)
	public Date getOpenDate()
	{
		return this.openDate;
	}

	public void setOpenDate(Date openDate)
	{
		this.openDate = openDate;
	}

	@Column(name = "status", nullable = false, length = 1)
	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Column(name = "tipNote", length = 64)
	public String getTipNote()
	{
		return this.tipNote;
	}

	public void setTipNote(String tipNote)
	{
		this.tipNote = tipNote;
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

	
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", cusId=" + cusId + ", openDate=" + openDate + ", status=" + status + ", tipNote=" + tipNote + ", loginTimes=" + loginTimes + ", lastLoginTime=" + lastLoginTime + "]";
	}
	
	

}