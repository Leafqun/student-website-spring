package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/8/4 13:44
 * @Description: 
 */

import cn.zjut.edu.dto.Message;

import java.util.List;

public interface MessageCustomMapper {
    List<Message> selectAllMessages();

    int selectMessageNum();
}
