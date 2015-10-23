package com.inna.data;

import java.util.Date;

public class InfoStudent {

    private long id;
    private Course course;
    private String score;
    private String fedback;
    
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFedback() {
        return fedback;
    }

    public void setFedback(String fedback) {
        this.fedback = fedback;
    }
}
