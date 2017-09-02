package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/7/13 18:04
 * @Description: 
 */

import cn.zjut.edu.dto.CourseFile;
import cn.zjut.edu.dto.FileKey;

import java.util.List;

public interface CourseFileCustomMapper {

    List<CourseFile> selectAllCourseFile(int courseId);
    List<CourseFile> selectCourseFileByType(FileKey fileKey);
    int deleteByCourseId(Integer courseId);
}
