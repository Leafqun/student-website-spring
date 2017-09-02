package cn.zjut.edu.service;

import cn.zjut.edu.dto.Course;
import cn.zjut.edu.dto.CourseFile;
import cn.zjut.edu.dto.CourseWithBLOBs;
import cn.zjut.edu.dto.FileKey;

import java.util.List;

/**
 * Created by Leafqun on 2017/5/24.
 */
public interface CourseService {
    CourseWithBLOBs getCourseByName(String courseName);
    List<Course> getAllCourseName();
    int insert(CourseWithBLOBs course);
    int update(CourseWithBLOBs course);
    int delete(Integer courseId);
    CourseWithBLOBs getCourseById(Integer courseId);
    List<CourseFile> getAllCourseFile(int courseId);
    List<CourseFile> getAllCourseFileByType(FileKey fileKey);
    CourseFile getCourseFile(Integer cfileId);
    int insertCourseFile(CourseFile courseFile);
    int updateCourseFile(CourseFile courseFile);
    int deleteCourseFile(int cfileId);
    int deleteCourseFileByCourseId(Integer courseId);
}
