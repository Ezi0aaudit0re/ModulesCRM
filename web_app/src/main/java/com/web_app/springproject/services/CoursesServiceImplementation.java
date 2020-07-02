package com.web_app.springproject.services;

import com.web_app.springproject.dao.CoursesDAO;
import com.web_app.springproject.entity.Courses;
import com.web_app.springproject.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImplementation  implements CoursesService{

    @Autowired
    private CoursesDAO coursesDAO;

    @Override
    public List<Courses> getRegisteredCourses() {
        return coursesDAO.getRegisteredCourses();
    }


    @Override
    public List<Courses> getCourses(int startIndex, int endIndex) {

        return coursesDAO.getCourses(startIndex, endIndex);
    }

    @Override
    public void addCourse(int id) {
        coursesDAO.addCourse(id);

    }

    @Override
    public Courses getCourse(int id) {
        return coursesDAO.getCourse(id);
    }


    @Override
    public void deleteCourse(int id) {
        coursesDAO.deleteCourse(id);
    }
}
