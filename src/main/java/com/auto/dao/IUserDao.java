package com.auto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.auto.entity.User;

@Repository
public interface IUserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("from User")
    List<User> getList();
    
    User findByusername(String username);

}
