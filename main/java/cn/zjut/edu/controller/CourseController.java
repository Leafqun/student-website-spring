package cn.zjut.edu.controller;

import cn.zjut.edu.common.constant;
import cn.zjut.edu.dto.Course;
import cn.zjut.edu.dto.CourseFile;
import cn.zjut.edu.dto.CourseWithBLOBs;
import cn.zjut.edu.dto.FileKey;
import cn.zjut.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Leafqun
 * @Time: 2017/7/13 17:36
 * @Description: 
 */
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="getAllCourse", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> getAllCourse(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Course> courseList = courseService.getAllCourseName();
        map.put("courseList", courseList);
        return map;
    }
    @RequestMapping(value="getCourse", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> getCourse(Integer courseId){
        Map<String, Object> map = new HashMap<String, Object>();
        Course course = courseService.getCourseById(courseId);
        map.put("course", course);
        return map;
    }
    @RequestMapping(value="deleteCourse", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> deleteCourse(Integer courseId){
        Map<String, Object> map = new HashMap<String, Object>();
        courseService.delete(courseId);
        List<CourseFile> courseFileList = courseService.getAllCourseFile(courseId);
        for(CourseFile courseFile : courseFileList){
            if(!courseFile.getCfileName().isEmpty()&&courseFile.getCfileName() != null){
                File oldFile = new File(constant.FILE_PATH + courseFile.getCfileName());
                if(oldFile.exists()) oldFile.delete();
            }
        }
        courseService.deleteCourseFileByCourseId(courseId);
        map.put("msg", "success");
        return map;
    }
    @RequestMapping(value="getCourseFile", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> getAllCourseFile(@RequestParam(value = "courseId") int courseId){
        Map<String, Object> map = new HashMap<String, Object>();
        List<CourseFile> courseFileList = courseService.getAllCourseFile(courseId);
        map.put("courseFileList", courseFileList);
        return map;
    }
    @RequestMapping("deleteCourseFile")
    public Map<String, Object> deleteCourseFile(int cfileId) {
        Map<String, Object> map = new HashMap<String, Object>();
        CourseFile courseFile = courseService.getCourseFile(cfileId);
        if(!courseFile.getCfileName().isEmpty()&&courseFile.getCfileName() != null){
            File oldFile = new File(constant.FILE_PATH + courseFile.getCfileName());
            if(oldFile.exists()) oldFile.delete();
        }
        courseService.deleteCourseFile(cfileId);
        map.put("msg","success");
        return map;
    }
    @RequestMapping("deleteCourseFileBatch")
    public Map<String, Object> deleteCourseFileBatch(@RequestParam(value="cfileId",required = false) int[] cfileIds) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(cfileIds == null){
            map.put("msg","error");
            return map;
        }
        for(int cfileId : cfileIds) {
            courseService.deleteCourseFile(cfileId);
        }
        map.put("msg","success");
        return map;
    }
    @RequestMapping(value = "insertCourseFile", method = {RequestMethod.POST} )
    public Map<String, Object> insertCourseFile(@RequestParam(value = "file",required = false ) MultipartFile[] cfiles,@RequestParam(value = "courseId") Integer courseId, @RequestParam(value="names",required = false ) String[] names, @RequestParam(value = "ctype",required = false ) int cType) throws IOException {
        CourseFile courseFile = new CourseFile();
        courseFile.setCourseId(courseId);
        courseFile.setCtype(cType);
        Map<String, Object> map = new HashMap<String, Object>();
        if(cfiles == null || cfiles.length < 1) map.put("msg","error");
        if(courseFile.getCourseId() == null) map.put("msg","error");
        for(int i = 0; i < cfiles.length; i++){
            String filename = cfiles[i].getOriginalFilename();
            if(names!=null)
            for(String name : names){
                if(filename.equals(name)){
                    filename=null;
                    break;
                }
            }
            if(filename == null || filename.isEmpty()) continue;
            File newFile = new File(constant.FILE_PATH+filename);
            newFile.createNewFile();
            cfiles[i].transferTo(newFile);
            courseFile.setCfileName(filename);
            courseService.insertCourseFile(courseFile);
        }
        map.put("msg","success");
        return map;
    }
    @RequestMapping(value = "submitCourse", method = {RequestMethod.POST} )
    public Map<String, Object> submitCourse(CourseWithBLOBs course){
        Map<String, Object> map = new HashMap<String, Object>();
        if(course == null) map.put("msg","error");
        if(course.getCourseId() == null){
            courseService.insert(course);
            map.put("msg", "添加成功");
        }else{
            courseService.update(course);
            map.put("msg", "更改成功");
        }
        return map;
    }
}
