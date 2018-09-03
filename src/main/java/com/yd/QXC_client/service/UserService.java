package com.yd.QXC_client.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.yd.QXC_client.domain.User;
import com.yd.QXC_client.repository.UserRepository;


@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	
	
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return userRepository.login(userName,password);
	}
	/**
	 * save,update ,delete 方法需要绑定事务.
	 * 
	 * 使用@Transactional进行事务的绑定.
	 * 
	 * @param cat
	 */
	
	//根据id查询user.
	@Transactional
	public User findById(int id){
		User user = userRepository.findOne(id);
		return user;
	}
	//保存数据.
	@Transactional
	public void save(User user){
		userRepository.save(user);
	}
	

	
	
}
