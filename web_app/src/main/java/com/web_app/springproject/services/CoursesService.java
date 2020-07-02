package com.web_app.springproject.services;


import com.web_app.springproject.entity.Courses;

import java.util.List;

public interface CoursesService {

    List<Courses> getCourses(int startIndex, int endIndex);

    Courses getCourse(int id);

    void addCourse(int id);

    List<Courses> getRegisteredCourses();

    void deleteCourse(int id);


}
