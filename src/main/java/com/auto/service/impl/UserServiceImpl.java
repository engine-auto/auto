package com.auto.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto.dao.TUserDao;
import com.auto.entity.Tuser;
import com.auto.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private TUserDao userdao;
	
	@Override
	public Tuser findByName(String nickname) {
		return userdao.findByNickname(nickname);
	}

	@Override
	public void addUser(Tuser user) {
		userdao.save(user);
	}

	@Override
	public List<Tuser> getList() {
		return userdao.getList();
	}


}
