package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/7/13 17:25
 * @Description: 
 */

import cn.zjut.edu.dto.User;

public interface UserCustomMapper {
    User selectUserByName(String userName);
}
