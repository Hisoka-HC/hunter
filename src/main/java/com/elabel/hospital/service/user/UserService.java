package com.elabel.hospital.service.user;

import com.elabel.hospital.pojo.user.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);
    public List<User> selectUser(String order, Integer limit, Integer offset);
    public void updateUser(User user);
    public void deleteUser(Integer id);
    public User login(User user);
    public int selectCount();
}
