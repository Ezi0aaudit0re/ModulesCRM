package com.web_app.springproject.dao;

import com.web_app.springproject.entity.Courses;

import java.util.List;

public interface CoursesDAO {


    public List<Courses> getCourses(int start_index, int end_index);

    public Courses getCourse(int id);

    public boolean addCourse(int id);

    List<Courses> getRegisteredCourses();

    void deleteCourse(int id);



}
