package com.inna.dao;

import com.inna.data.Course;

import java.util.List;

public interface CourseDao {

    Course getByCourse(String course);

    void saveCourse(Course course);

    List<Course> findAll();


}
