package com.web_app.springproject.controller;

import com.web_app.springproject.entity.Courses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/courses")
@PropertySource("classpath:constants.properties")
public class CoursesController {


    @Value("${pagination}")
    int pagination;



    @GetMapping("/getCourses")
    public String getCourses(@RequestParam("page") int page, Model model){



        int start_index = (page + 1) * 10;

        model.addAttribute("page", page+1);

        return "list-courses";
    }


}
