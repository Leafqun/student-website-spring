package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.Management;

public interface ManagementMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKeyWithBLOBs(Management record);
}