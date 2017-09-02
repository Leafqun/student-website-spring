package cn.zjut.edu.controller;

import cn.zjut.edu.dto.Faculty;
import cn.zjut.edu.dto.Management;
import cn.zjut.edu.dto.Profile;
import cn.zjut.edu.service.OthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Leafqun
 * @Time: 2017/8/19 15:13
 * @Description: 
 */
@RestController
public class OthersController {
    @Autowired
    private OthersService othersService;

    @RequestMapping("/profile/getProfile")
    public Map<String, Object> getProfile(Integer profileId){
        Map<String, Object> map = new HashMap<String, Object>();
        Profile profile = othersService.selectProfile(profileId);
        map.put("profile", profile);
        return map;
    }
    @RequestMapping(value = "/profile/updateProfile", method = {RequestMethod.POST})
    public Map<String, Object> updateProfile(Profile profile){
        Map<String, Object> map = new HashMap<String, Object>();
        othersService.updateProfile(profile);
        map.put("msg", "success");
        return map;
    }
    @RequestMapping("/faculty/getFaculty")
    public Map<String, Object> getFaculty(Integer facultyId){
        Map<String, Object> map = new HashMap<String, Object>();
        Faculty faculty = othersService.selectFaculty(facultyId);
        map.put("faculty", faculty);
        return map;
    }
    @RequestMapping(value = "/faculty/updateFaculty", method = {RequestMethod.POST})
    public Map<String, Object> updateFaculty(Faculty faculty){
        Map<String, Object> map = new HashMap<String, Object>();
        othersService.updateFaculty(faculty);
        map.put("msg", "success");
        return map;
    }
    @RequestMapping("/management/getManagement")
    public Map<String, Object> getManagement(Integer mId){
        Map<String, Object> map = new HashMap<String, Object>();
        Management management = othersService.selectManagement(mId);
        map.put("management", management);
        return map;
    }
    @RequestMapping(value = "/management/updateManagement", method = {RequestMethod.POST})
    public Map<String, Object> updateManagement(Management management){
        Map<String, Object> map = new HashMap<String, Object>();
        othersService.updateManagement(management);
        map.put("msg", "success");
        return map;
    }
}
