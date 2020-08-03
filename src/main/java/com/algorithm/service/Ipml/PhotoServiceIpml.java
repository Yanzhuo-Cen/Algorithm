package com.algorithm.service.Ipml;


import com.algorithm.dao.PhotoMapper;
import com.algorithm.entity.Photo;
import com.algorithm.service.PhotoService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhotoServiceIpml implements PhotoService {

    @Resource
    PhotoMapper photoMapper;

    @Override
    public Photo getByName(String name) {
        return photoMapper.getByName(name);
    }

    @Override
    public JSONArray getByBanner(String name) {
        List<Photo> photos = photoMapper.getByBanner(name);
        JSONArray uu = JSONArray.fromObject(photos);     //将java数组转换为json数组
        return uu;
    }

    @Override
    public JSONArray getPageBanner(String name, int pages, int size) {
        int page = (pages-1)*size;   //该页起始行
        List<Photo> photos = photoMapper.getPageBanner(name, page, size);
        JSONArray uu = JSONArray.fromObject(photos);     //将java数组转换为json数组
        return uu;
    }

    @Override
    public Photo getByFileName(String fileName) {
        Photo photo = photoMapper.getByFileName(fileName);
        return photo;
    }

    @Override
    public String delete(int id) {
        int i = photoMapper.delete(id);
        if (i == 0) {
            return "删除失败";
        } else {
            return "删除成功";
        }
    }

    @Override
    public String insert(Photo photo) {
        int i = photoMapper.insert(photo);
        if (i == 0) {
            return "添加失败";
        } else {
            return "添加成功";
        }
    }

    @Override
    public String modify(Photo photo) {
        int i = photoMapper.modify(photo);
        if (i == 0) {
            return "修改失败";
        } else {
            return "修改成功";
        }
    }
}
