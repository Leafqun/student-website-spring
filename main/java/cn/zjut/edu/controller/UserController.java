package cn.zjut.edu.controller;

import cn.zjut.edu.dto.User;
import cn.zjut.edu.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leafqun on 2017/5/15.
 */
@RestController
public class UserController {
    private static final Log log= LogFactory.getLog(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value="/loginCheck",method = {RequestMethod.POST,RequestMethod.GET})
    public Map<String,Object> loginCheck(User user){
        Map<String,Object> map=new HashMap<String, Object>();
        if(user==null) {
            map.put("msg","error");
            log.info("登录验证出错！！！");
            return map;
        }
        String username=user.getUserName();
        String password=user.getUserPwd();

        User user2=userService.selectUserByName(username);
        if(user2!=null){
            if(user2.getUserPwd().equals(password)) {
                map.put("msg","success");
                log.info("登录成功！！！");
            }
            else {
                map.put("msg","密码错误");
                log.info("密码错误！！！");
            }
        }else{
             map.put("msg","用户不存在");
            log.info("用户不存在");
        }
        return map;
    }
    @RequestMapping(value="/registerCheck")
    public Map<String,Object> registerCheck(User user){
         Map<String,Object> map=new HashMap<String, Object>();
        if(user==null) {
            map.put("msg","error");
            return map;
        }
        if(userService.selectUserByName(user.getUserName())!=null){
            map.put("msg","用户名已存在");
            log.info("用户已存在");
        }else{
            if(user.getUserPwd()!=null) {
                userService.insert(user);
                map.put("msg", "success");
                log.info("注册成功！！！");
            }else{
                map.put("msg","用户名可用");
            }
        }
        return map;
    }
    @RequestMapping(value="/deleteUser")
    public Map<String,Object> deleteUser(User user){
        Map<String,Object> map=new HashMap<String, Object>();
        if(user==null){
            map.put("msg","error");
            return map;
        }
        Integer userId=user.getUserId();

        userService.delete(userId);
        map.put("msg","success");
        log.info("成功删除用户！！！");

        return map;
    }
    @RequestMapping(value="/editUser")
    public Map<String,Object> editUser(User user){
        Map<String,Object> map=new HashMap<String, Object>();
        if(user==null) map.put("msg","error");
        else {
                userService.update(user);
                map.put("msg","success");
                log.info("成功修改用户信息！！！");

        }
        return map;
    }
}
