package cn.zjut.edu.service.impl;

import cn.zjut.edu.dto.Course;
import cn.zjut.edu.dto.CourseFile;
import cn.zjut.edu.dto.CourseWithBLOBs;
import cn.zjut.edu.dto.FileKey;
import cn.zjut.edu.mapper.CourseCustomMapper;
import cn.zjut.edu.mapper.CourseFileCustomMapper;
import cn.zjut.edu.mapper.CourseFileMapper;
import cn.zjut.edu.mapper.CourseMapper;
import cn.zjut.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Leafqun on 2017/5/24.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseCustomMapper courseCustomMapper;
    @Autowired
    private CourseFileMapper courseFileMapper;
    @Autowired
    private CourseFileCustomMapper courseFileCustomMapper;
    @Override
    public CourseWithBLOBs getCourseByName(String courseName) {
        return courseCustomMapper.selectCourseByCourseName(courseName);
    }

    @Override
    public List<Course> getAllCourseName() {
        return courseCustomMapper.selectAllCourseName();
    }

    @Override
    public int insert(CourseWithBLOBs course) {
        return courseMapper.insert(course);
    }

    @Override
    public int update(CourseWithBLOBs course) {
        return courseMapper.updateByPrimaryKeyWithBLOBs(course);
    }

    @Override
    public int delete(Integer courseId) {
        return courseMapper.deleteByPrimaryKey(courseId);
    }

    @Override
    public CourseWithBLOBs getCourseById(Integer courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }

    @Override
    public List<CourseFile> getAllCourseFile(int courseId) {
        return courseFileCustomMapper.selectAllCourseFile(courseId);
    }

    @Override
    public List<CourseFile> getAllCourseFileByType(FileKey fileKey) {
        return courseFileCustomMapper.selectCourseFileByType(fileKey);
    }

    @Override
    public CourseFile getCourseFile(Integer cfileId) {
        return courseFileMapper.selectByPrimaryKey(cfileId);
    }

    @Override
    public int insertCourseFile(CourseFile courseFile) {
        return courseFileMapper.insert(courseFile);
    }

    @Override
    public int updateCourseFile(CourseFile courseFile) {
        return courseFileMapper.updateByPrimaryKey(courseFile);
    }

    @Override
    public int deleteCourseFile(int cfileId) {
        return courseFileMapper.deleteByPrimaryKey(cfileId);
    }

    @Override
    public int deleteCourseFileByCourseId(Integer courseId) {
        return courseFileCustomMapper.deleteByCourseId(courseId);
    }
}
