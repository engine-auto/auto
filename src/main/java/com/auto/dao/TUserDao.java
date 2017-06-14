package com.auto.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auto.entity.Tuser;

@Repository
public interface TUserDao extends PagingAndSortingRepository<Tuser, Long>, JpaSpecificationExecutor<Tuser> {

    @Query("from Tuser")
    List<Tuser> getList();
    
    Tuser findByNickname(String nickname);

    @Query("from Tuser t where id = :id")
    List<Tuser> queryFamilyList(@Param("id") Long id, Pageable pageable);

}
