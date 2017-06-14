package com.auto.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.auto.entity.Tuser;

public interface UserService {
    List<Tuser> getList();
    
	Tuser findByName(String nickname);
	
	void addUser(Tuser user);
}
