package cn.zjut.edu.service.impl;

import cn.zjut.edu.dto.Message;
import cn.zjut.edu.mapper.MessageCustomMapper;
import cn.zjut.edu.mapper.MessageMapper;
import cn.zjut.edu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author: Leafqun
 * @Time: 2017/8/4 14:23
 * @Description: 
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    public MessageMapper messageMapper;
    @Autowired
    public MessageCustomMapper messageCustomMapper;
    @Override
    public List<Message> getAllMessages() {
        return messageCustomMapper.selectAllMessages();
    }

    @Override
    public int getMessageNum() {
        return messageCustomMapper.selectMessageNum();
    }

    @Override
    public Message getMessage(int messageId) {
        return messageMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateByPrimaryKeyWithBLOBs(message);
    }

    @Override
    public int deleteMessage(int messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }
}
