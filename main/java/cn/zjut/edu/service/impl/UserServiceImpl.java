package cn.zjut.edu.service.impl;

import cn.zjut.edu.mapper.UserCustomMapper;
import cn.zjut.edu.mapper.UserMapper;
import cn.zjut.edu.dto.User;
import cn.zjut.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Leafqun on 2017/5/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Override
    public User selectUserByName(String userName) {
        return userCustomMapper.selectUserByName(userName);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
