package com.yd.QXC_client.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date time;
	private Integer duid;
	private Integer dfid;
	private String dpname;
	private Integer dodds = 99;
	private Integer dcount;
	
}
