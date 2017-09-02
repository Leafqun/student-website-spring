package cn.zjut.edu.service;
/*
 * @Author: Leafqun
 * @Time: 2017/8/4 14:21
 * @Description: 
 */

import cn.zjut.edu.dto.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    int getMessageNum();
    Message getMessage(int messageId);
    int insertMessage(Message message);
    int updateMessage(Message message);
    int deleteMessage(int messageId);
}
