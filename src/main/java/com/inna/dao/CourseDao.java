package com.inna.dao;

import com.inna.data.Course;

public interface CourseDao {

    Course getByCourse(String course);

    void saveCourse(Course course);
}
