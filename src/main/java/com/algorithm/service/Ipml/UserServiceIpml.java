package com.algorithm.service.Ipml;

import com.algorithm.dao.UserDao;
import com.algorithm.entity.User;
import com.algorithm.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceIpml implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public JSONArray getByName(String name) {
        List<User> users = userDao.getByName(name);
        JSONArray uu = JSONArray.fromObject(users);     //将java数组转换为json数组
        return uu;
    }

    @Override
    public int insert(User user) {
        int i = userDao.insert(user);
        if (i == 0) {
            return -1;
        } else {
            return user.getid();
        }
    }

    @Override
    public int update(User user) {
        int i=userDao.update(user);
        if (i == 0) {
            return -1;
        } else {
            return user.getid();
        }
    }
}
