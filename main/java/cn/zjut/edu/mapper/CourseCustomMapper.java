package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/7/13 17:27
 * @Description: 
 */

import cn.zjut.edu.dto.Course;
import cn.zjut.edu.dto.CourseWithBLOBs;

import java.util.List;

public interface CourseCustomMapper {
    CourseWithBLOBs selectCourseByCourseName(String courseName);

    List<Course> selectAllCourseName();

}
