package com.yd.QXC_client.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Forder implements java.io.Serializable {
	
	

	// Fields
	private static final long serialVersionUID = -466590347484970656L;
	
	private Integer id;
	private User user;
	private String name;
	private Date date;
	private List<Sorder> sorders = new ArrayList<Sorder>();

	// Constructors

	/** default constructor */
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Date date) {
		this.date = date;
	}

	public Forder(List<Sorder> sorders) {
		super();
		this.sorders = sorders;
	}

	/** full constructor */
	public Forder(User user, String name, String phone,
			String remark, Date date, BigDecimal total, String post,
			String address, List<Sorder> sorders) {
		this.user = user;
		this.name = name;
		this.date = date;
		this.sorders = sorders;
	}

	// Property accessors
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
	@JoinColumn(name = "uid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "date", nullable = true, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forder")
	public List<Sorder> getSorders() {
		return this.sorders;
	}

	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}

}