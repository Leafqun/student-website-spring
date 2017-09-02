package cn.zjut.edu.controller;

import cn.zjut.edu.dto.Message;
import cn.zjut.edu.service.MessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Leafqun
 * @Time: 2017/8/7 12:09
 * @Description: 
 */
@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping( value = "getMessageList", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> getMessageList(int pageNum){
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,15);
        List<Message> messageList = messageService.getAllMessages();
        map.put("messageList", messageList);
        return map;
    }
    @RequestMapping( value = "getMessageNum", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> getMessageNum() {
        Map<String, Object> map = new HashMap<String, Object>();
        int messageNum = messageService.getMessageNum();
        map.put("messageNum", messageNum);
        return map;
    }
    @RequestMapping( value = "getMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> getMessageNum(int messageId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Message message = messageService.getMessage(messageId);
        map.put("message", message);
        return map;
    }
    @RequestMapping( value = "insertMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> insertMessage(Message message) {
        Map<String, Object> map = new HashMap<String, Object>();
        message.setmTime(new Date());
        messageService.insertMessage(message);
        map.put("msg", "success");
        return map;
    }
    @RequestMapping( value = "deleteMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> deleteMessage(int messageId) {
        Map<String, Object> map = new HashMap<String, Object>();
        messageService.deleteMessage(messageId);
        map.put("msg", "success");
        return map;
    }
    @RequestMapping( value = "deleteMessageBatch", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> deleteMessage(@RequestParam("messageId") int[] messageIds) {
        Map<String, Object> map = new HashMap<String, Object>();
        for(int messageId : messageIds) {
            messageService.deleteMessage(messageId);
        }
        map.put("msg", "success");
        return map;
    }
}
