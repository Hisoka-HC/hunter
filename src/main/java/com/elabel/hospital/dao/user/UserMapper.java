package com.elabel.hospital.dao.user;

import com.elabel.hospital.pojo.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    public int insertUser(User user);
    public List<User> selectUser(Map<String ,Object> params);
    public int updateUser(User user);
    public int deleteUser(Integer id);
    public User login(User user);
    public int selectCount();
}
