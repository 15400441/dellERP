package com.hkbu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Components entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "components", catalog = "dellerp")
public class Components implements java.io.Serializable
{

	// Fields

	private Long uuid;
	private String name;
	private String producer;
	private String unit;
	private Double inPrice;
	private Double outPrice;
	private Integer storageTotal;
	private Long componentsTypeUuid;

	// Constructors

	/** default constructor */
	public Components()
	{
	}

	/** full constructor */
	public Components(String name, String producer, String unit, Double inPrice, Double outPrice, Integer storageTotal, Long componentsTypeUuid)
	{
		this.name = name;
		this.producer = producer;
		this.unit = unit;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.storageTotal = storageTotal;
		this.componentsTypeUuid = componentsTypeUuid;
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

	@Column(name = "producer", nullable = false, length = 30)
	public String getProducer()
	{
		return this.producer;
	}

	public void setProducer(String producer)
	{
		this.producer = producer;
	}

	@Column(name = "unit", nullable = false, length = 30)
	public String getUnit()
	{
		return this.unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	@Column(name = "inPrice", nullable = false, precision = 10)
	public Double getInPrice()
	{
		return this.inPrice;
	}

	public void setInPrice(Double inPrice)
	{
		this.inPrice = inPrice;
	}

	@Column(name = "outPrice", nullable = false, precision = 10)
	public Double getOutPrice()
	{
		return this.outPrice;
	}

	public void setOutPrice(Double outPrice)
	{
		this.outPrice = outPrice;
	}

	@Column(name = "storageTotal", nullable = false)
	public Integer getStorageTotal()
	{
		return this.storageTotal;
	}

	public void setStorageTotal(Integer storageTotal)
	{
		this.storageTotal = storageTotal;
	}

	@Column(name = "componentsTypeUuid", nullable = false)
	public Long getComponentsTypeUuid()
	{
		return this.componentsTypeUuid;
	}

	public void setComponentsTypeUuid(Long componentsTypeUuid)
	{
		this.componentsTypeUuid = componentsTypeUuid;
	}

}