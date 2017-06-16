package com.auto.service;

import com.auto.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {

	List<User> getAll();

	User getOne(Long id);

	User findByusername(String username);

	void insert(User user);

	void update(User user);

	void delete(Long id);
}
