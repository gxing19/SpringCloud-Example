package com.springcloud.shardingjdbc.repository;

import com.springcloud.shardingjdbc.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @name: UserInfoRepository
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-19 15:22
 **/
@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>, PagingAndSortingRepository<UserInfo, Long> {
}