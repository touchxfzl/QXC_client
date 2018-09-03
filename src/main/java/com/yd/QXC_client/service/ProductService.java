package com.yd.QXC_client.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yd.QXC_client.domain.Product;
import com.yd.QXC_client.repository.ProductRepository;


@Service
public class ProductService {
	
	@Resource
	private ProductRepository productRepository;
	
	
	public List<Product> findAll(){
		List<Product> findAllProductList = productRepository.findAllProductList();
		return findAllProductList;
	}
}
