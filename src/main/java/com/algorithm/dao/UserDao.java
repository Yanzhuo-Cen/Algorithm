package com.algorithm.dao;


import com.algorithm.entity.Photo;
import com.algorithm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserDao {

    List<User> getByName(String name);
    int insert(User user);
    int update(User user);
}
