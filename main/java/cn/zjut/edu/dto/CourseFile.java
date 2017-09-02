package cn.zjut.edu.dto;

public class CourseFile {
    private Integer cfileId;

    private Integer courseId;

    private String cfileName;

    private Integer ctype;

    public Integer getCfileId() {
        return cfileId;
    }

    public void setCfileId(Integer cfileId) {
        this.cfileId = cfileId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCfileName() {
        return cfileName;
    }

    public void setCfileName(String cfileName) {
        this.cfileName = cfileName == null ? null : cfileName.trim();
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }
}