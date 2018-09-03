package com.yd.QXC_client.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yd.QXC_client.domain.QXC;
import com.yd.QXC_client.service.QXCService;


@Controller
@RequestMapping("/qxc")
public class QXCController {
	@Resource
	private QXCService qxcService;
	
	@RequestMapping("/history")
	@ResponseBody
	public List<QXC> history(){
		return qxcService.findAll();
	}
	
}
