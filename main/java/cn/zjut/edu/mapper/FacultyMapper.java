package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.Faculty;

public interface FacultyMapper {
    int deleteByPrimaryKey(Integer facultyId);

    int insert(Faculty record);

    int insertSelective(Faculty record);

    Faculty selectByPrimaryKey(Integer facultyId);

    int updateByPrimaryKeySelective(Faculty record);

    int updateByPrimaryKeyWithBLOBs(Faculty record);
}