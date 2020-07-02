package com.web_app.springproject.dao;

import com.web_app.springproject.entity.Courses;
import com.web_app.springproject.entity.Registered;
import com.web_app.springproject.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoursesDAOImplementation implements CoursesDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Courses> getCourses(int startIndex, int endIndex) {

        Session mySession = sessionFactory.getCurrentSession();

        Query query = mySession.createQuery("from Courses c where c.idcourses between :startIndex and :endIndex", Courses.class);

        query.setParameter("startIndex", startIndex);
        query.setParameter("endIndex", endIndex);

        List<Courses> courses = query.getResultList();

        List<Section> sectionList = courses.get(4).getSections();


        return courses;

    }

    @Override
    @Transactional
    public Courses getCourse(int id) {

        Session mySession = sessionFactory.getCurrentSession();

        Courses course = mySession.get(Courses.class, id);

        // lazy loading get section
        course.getSections();



        return course;


    }


    @Override
    @Transactional
    public boolean addCourse(int id) {

        Session mySession = sessionFactory.getCurrentSession();


        // create the object
        Registered registered = new Registered();

        Courses courses = this.getCourse(id);

        // associate the object
        registered.setCourse(courses);




        // save the object
        mySession.save(registered);



        return true;
    }



    @Override
    @Transactional
    public List<Courses> getRegisteredCourses() {

        Session mySession = sessionFactory.getCurrentSession();


        List<Registered> registeredCourses = mySession.createQuery("from Registered").list();


        List<Courses> courses = new ArrayList<>();

        for(Registered reg: registeredCourses){
            courses.add(reg.getCourse());
        }

        return courses;
    }


    /**
     * Delete a course from the registered section
     * @param id -> the course id of the course to delete from the registered table
     */
    @Override
    @Transactional
    public void deleteCourse(int id) {

        System.out.println("Deleting a course: " + id);

        Session mySession = sessionFactory.getCurrentSession();

        mySession.createQuery("delete from Registered where course_id= :courseId").setParameter("courseId", id).executeUpdate();


    }
}
