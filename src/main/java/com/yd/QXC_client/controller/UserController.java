package com.yd.QXC_client.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yd.QXC_client.domain.User;
import com.yd.QXC_client.domain.UserVo;
import com.yd.QXC_client.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@Autowired 
	private HttpServletRequest request; 
	
	@RequestMapping("/logincheck")
	public String login(String username,String password){
		User user=userService.login(username,password);
		System.out.println(user);
		HttpSession session = request.getSession();
		if(user!=null) {
			session.setAttribute("user", user);
			return "rule";
		}else {
			return "loginerror";
		}
	}
	
	@RequestMapping("/login")
	public String save(){
		System.out.println("123");
		return "login";
	}
	@RequestMapping("/user")
	@ResponseBody
	public UserVo findUser(){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		UserVo userVo = new UserVo(user.getName(),user.getUmoney());
		return userVo;
	}
	
}
