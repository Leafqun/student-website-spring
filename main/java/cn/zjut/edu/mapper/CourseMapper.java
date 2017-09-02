package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.Course;
import cn.zjut.edu.dto.CourseWithBLOBs;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(CourseWithBLOBs record);

    int insertSelective(CourseWithBLOBs record);

    CourseWithBLOBs selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(CourseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CourseWithBLOBs record);

    int updateByPrimaryKey(Course record);
}