package com.auto.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.auto.entity.User;
import com.auto.mapper.UserMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> getAll(){
		return userMapper.getAll();
	}
	@Override
	public User getOne(Long id){
		return userMapper.getOne(id);
	}
	@Override
	public User findByusername(String username){
		return userMapper.findByusername(username);
	}
	@Override
	public void insert(User user){
		userMapper.insert(user);
	}
	@Override
	public void update(User user){
		userMapper.update(user);
	}
	@Override
	public void delete(Long id){
		userMapper.delete(id);
	}

}
