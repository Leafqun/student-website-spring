package cn.zjut.edu.service;
/*
 * @Author: Leafqun
 * @Time: 2017/8/19 15:05
 * @Description: 
 */

import cn.zjut.edu.dto.Faculty;
import cn.zjut.edu.dto.Management;
import cn.zjut.edu.dto.Profile;

public interface OthersService {
    Profile selectProfile(Integer profileId);
    int updateProfile(Profile record);
    Faculty selectFaculty(Integer facultyId);
    int updateFaculty(Faculty record);
    Management selectManagement(Integer mId);
    int updateManagement(Management record);
}
