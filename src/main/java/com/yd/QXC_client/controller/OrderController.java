package com.yd.QXC_client.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yd.QXC_client.domain.Data;
import com.yd.QXC_client.domain.Forder;
import com.yd.QXC_client.domain.Product;
import com.yd.QXC_client.domain.Sorder;
import com.yd.QXC_client.domain.User;
import com.yd.QXC_client.service.ForderService;
import com.yd.QXC_client.service.ProductService;
import com.yd.QXC_client.service.SorderService;
import com.yd.QXC_client.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private HttpServletRequest request;

	@Resource
	private UserService userService;
	@Resource
	private ForderService forderService;
	@Resource
	private SorderService sorderService;
	@Resource
	private ProductService productService;

	@RequestMapping("/index")
	public String index() {
		System.out.println("进入游戏主页");
		return "order/index";
	}

	// 提交订单
	@RequestMapping("/orderSubmint")
	@ResponseBody
	public int orderSubmint(int[] ezds) {
		// User user = userService.findById(1);
		int sum = 0;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Set<Forder> forders = new HashSet<>();
		Forder forder = new Forder();
		List<Sorder> sorders = new ArrayList<>();
		List<Product> list = productService.findAll();
		for (int i = 0; i < ezds.length; i++) {
			if (ezds[i] > 0) {
				sum = sum+ezds[i];
				Sorder sorder = new Sorder();
				sorder.setNumber(ezds[i]);
				sorder.setForder(forder);
				sorder.setProduct(list.get(i));
				sorders.add(sorder);
			}
		}
		forder.setDate(new Date());
		forder.setSorders(sorders);
		forder.setUser(user);
		forders.add(forder);
		user.setForders(forders);
		user.setLogin("2");
		//剩余多少
		int surplus = user.getUmoney()-sum;
		if(surplus<0) {
			return -1;
		}else {
			user.setUmoney(surplus);
			userService.save(user);
		}
		return 0;

	}

	@RequestMapping("/showOrders")
	public String showOrders() {
		System.out.println("查看订单");
		return "order/showOrders";
	}

	@RequestMapping("/datagrid_data1.json")
	@ResponseBody
	public List<Data> datagrid() {
		System.out.println("data");
		List<Data> list = sorderService.findOrderDetail();
		return list;
	}
}
