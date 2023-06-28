package com.shijw.front.model;

import java.util.Date;

public class FrontTeachInfo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String teachInfoId;

    private String teacherId;

    private String courseId;

    private String classId;

    private String semester;

    private Boolean isScoreUpload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTeachInfoId() {
        return teachInfoId;
    }

    public void setTeachInfoId(String teachInfoId) {
        this.teachInfoId = teachInfoId == null ? null : teachInfoId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public Boolean getIsScoreUpload() {
        return isScoreUpload;
    }

    public void setIsScoreUpload(Boolean isScoreUpload) {
        this.isScoreUpload = isScoreUpload;
    }
}