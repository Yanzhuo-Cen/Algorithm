package com.algorithm.dao;

import com.algorithm.entity.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PhotoMapper {

    Photo getByName(String name);              //查找图片

    List<Photo> getByBanner(String name);      //查找图片

    List<Photo> getPageBanner(String name, int page,  int size);      //分页查找图片

    Photo getByFileName(String fileName);      //查找图片

    int delete(int id);                        //删除指定信息

    int insert(Photo photo);                   //增加表信息

    int modify(Photo photo);                   //修改信息

}
