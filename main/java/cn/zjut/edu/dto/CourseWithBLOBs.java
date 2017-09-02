package cn.zjut.edu.dto;

public class CourseWithBLOBs extends Course {
    private String courseArr;

    private String courseSchedule;

    public String getCourseArr() {
        return courseArr;
    }

    public void setCourseArr(String courseArr) {
        this.courseArr = courseArr == null ? null : courseArr.trim();
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule == null ? null : courseSchedule.trim();
    }
}