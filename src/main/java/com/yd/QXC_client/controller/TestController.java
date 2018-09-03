package com.yd.QXC_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String fun(Model model) {
		
		return "hello";
	}
}
