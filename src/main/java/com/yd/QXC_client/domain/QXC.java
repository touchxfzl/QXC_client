package com.yd.QXC_client.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QXC implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -864897410754667710L;
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	protected String id;
	private LocalDateTime draw_time;
	private String preDrawCode;
	private LocalDateTime preDrawTime;
	private Integer preDrawIssue;
//	private Date time;
	
	
	
}