package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.CourseFile;

public interface CourseFileMapper {
    int deleteByPrimaryKey(Integer cfileId);

    int insert(CourseFile record);

    int insertSelective(CourseFile record);

    CourseFile selectByPrimaryKey(Integer cfileId);

    int updateByPrimaryKeySelective(CourseFile record);

    int updateByPrimaryKey(CourseFile record);
}