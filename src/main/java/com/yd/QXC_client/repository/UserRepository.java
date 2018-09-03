package com.yd.QXC_client.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yd.QXC_client.domain.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	@Query(value = "select * from user where name = ?1 and pass = ?2", nativeQuery = true)
	User login(String userName, String password);

}
