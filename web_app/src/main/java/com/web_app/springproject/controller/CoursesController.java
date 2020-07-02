package com.web_app.springproject.controller;

import com.web_app.springproject.entity.Courses;
import com.web_app.springproject.entity.Registered;
import com.web_app.springproject.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
@PropertySource("classpath:constants.properties")
public class CoursesController {


    @Value("${pagination}")
    int pagination;


    @Autowired
    private CoursesService coursesService;


    @GetMapping("/getCourses")
    public String getCourses(@RequestParam("page") int page, Model model){

        if(page < 0){
            page = 1;
        }

        int start_index = (page * pagination) + 1;
        int end_index = start_index + (pagination - 1);

        List<Courses> courses = coursesService.getCourses(start_index, end_index);

        model.addAttribute("page", page+1);
        model.addAttribute("courses", courses);
        model.addAttribute("heading", "All Courses");


        return "list-courses";
    }


    @GetMapping("/getCourseInformation")
    public String getCourseInformation(@RequestParam("courseId") int id, Model model){

        System.out.println("Id is: " + id );

        Courses courseInformation = coursesService.getCourse(id);

        model.addAttribute("courseInformation", courseInformation);

        return "course-information";
    }


    @GetMapping("/register")
    public String addCourseForUser(@RequestParam("courseId") int id, @RequestParam("page") int page, Model model){
        System.out.println(id);

        coursesService.addCourse(id);

        model.addAttribute("message", "Successfully inserted");
        // send back to the same page
        return this.getCourses(page, model);

    }


    @GetMapping("/registeredCourses")
    public String getRegisteredCourses(Model model){
        System.out.println("Getting registered Courses");

        List<Courses> registeredCourses = coursesService.getRegisteredCourses();


        model.addAttribute("courses", registeredCourses);
        model.addAttribute("heading", "Registered Courses");

        return "list-courses";

    }


    @GetMapping("/unregister")
    public String unregister(@RequestParam("courseId") int id, Model model){

        // delete a course
        coursesService.deleteCourse(id);
        model.addAttribute("message", "Unregistered Course");
        return this.getRegisteredCourses(model);

    }



}
