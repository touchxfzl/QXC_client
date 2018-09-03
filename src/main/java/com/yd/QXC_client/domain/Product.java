package com.yd.QXC_client.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Product implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -5102917489458854913L;

	private Integer id;
	private Category category;
	private String name;
	private Boolean open;


	// Constructors
	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
//	public Product(Timestamp date) {
//		this.date = date;
//	}


	/** full constructor */
	public Product(Category category, String name, BigDecimal price, String pic,
			String remark, String xremark, Date date, Boolean commend,
			Boolean open) {
		this.category = category;
		this.name = name;
		this.open = open;
	}

	public Product(Integer id, String name, BigDecimal price, String pic,
			String remark, String xremark, Boolean commend, Boolean open) {
		super();
		this.id = id;
		this.name = name;
		this.open = open;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "open")
	public Boolean getOpen() {
		return this.open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}