package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.Profile;

public interface ProfileMapper {
    int deleteByPrimaryKey(Integer profileId);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile selectByPrimaryKey(Integer profileId);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKeyWithBLOBs(Profile record);
}