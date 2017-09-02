package cn.zjut.edu.dto;

public class Faculty {
    private Integer facultyId;

    private String teachers;

    private String projects;

    private String papers;

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers == null ? null : teachers.trim();
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects == null ? null : projects.trim();
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers == null ? null : papers.trim();
    }
}