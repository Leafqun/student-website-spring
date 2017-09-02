package cn.zjut.edu.service;

import cn.zjut.edu.dto.User;

/**
 * Created by Leafqun on 2017/5/15.
 */
public interface UserService {

    public User selectUserByName(String userName);

    public int insert(User user);

    public int delete(Integer userId);

    public int update(User user);
}
