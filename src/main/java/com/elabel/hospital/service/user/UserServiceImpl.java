package com.elabel.hospital.service.user;

import com.elabel.hospital.dao.user.UserMapper;
import com.elabel.hospital.pojo.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> selectUser(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return userMapper.selectUser(params);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public User login(User user) {
          return  userMapper.login(user);
    }

    @Override
    public int selectCount() {
        return userMapper.selectCount();
    }
}
