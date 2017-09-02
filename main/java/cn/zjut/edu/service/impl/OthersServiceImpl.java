package cn.zjut.edu.service.impl;

import cn.zjut.edu.dto.Faculty;
import cn.zjut.edu.dto.Management;
import cn.zjut.edu.dto.Profile;
import cn.zjut.edu.mapper.FacultyMapper;
import cn.zjut.edu.mapper.ManagementMapper;
import cn.zjut.edu.mapper.ProfileMapper;
import cn.zjut.edu.service.OthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Author: Leafqun
 * @Time: 2017/8/19 15:09
 * @Description: 
 */
@Service
public class OthersServiceImpl implements OthersService{
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private FacultyMapper facultyMapper;
    @Autowired
    private ManagementMapper managementMapper;
    @Override
    public Profile selectProfile(Integer profileId) {
        return profileMapper.selectByPrimaryKey(profileId);
    }

    @Override
    public int updateProfile(Profile record) {
        return profileMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public Faculty selectFaculty(Integer facultyId) {
        return facultyMapper.selectByPrimaryKey(facultyId);
    }

    @Override
    public int updateFaculty(Faculty record) {
        return facultyMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public Management selectManagement(Integer mId) {
        return managementMapper.selectByPrimaryKey(mId);
    }

    @Override
    public int updateManagement(Management record) {
        return managementMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
