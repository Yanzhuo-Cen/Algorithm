package com.algorithm.service;

import com.algorithm.entity.Photo;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface PhotoService {

    Photo getByName(String name);                  //查找图片

    JSONArray getByBanner(String name);           //查找图片

    JSONArray getPageBanner(String name, int pages, int size);      //分页查找图片

    Photo getByFileName(String fileName);        //查找图片

    String delete(int id);                        //删除指定信息

    String insert(Photo photo);                    //增加表信息

    String modify(Photo photo);                     //修改信息

}
