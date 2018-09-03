package com.yd.QXC_client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yd.QXC_client.domain.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Query(value = "select * from product", nativeQuery = true)
	List<Product> findAllProductList();
}
