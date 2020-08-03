package com.algorithm.service;


import com.algorithm.entity.User;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserService {

    JSONArray getByName(String name);

    int insert(User user);  //可返回自增id

    int update(User user);  //不可返回自增id
}
