package com.yd.QXC_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lottery")
public class LotteryController {
	
	@RequestMapping("/history")
	public String helloHtml(){
		return "history";
	}
	
   
}
