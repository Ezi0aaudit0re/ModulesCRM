package com.web_app.springproject.entity;

import javax.persistence.*;
import java.util.List;

// this will only be a read only class
@Entity
@Table(name = "courses")
public class Courses {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcourses;


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setPreReq(String preReq) {
        this.preReq = preReq;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public String getCode() {
        return code;
    }

    public String getSchool() {
        return school;
    }

    public String getUrl() {
        return url;
    }

    public int getCredits() {
        return credits;
    }

    public String getPreReq() {
        return preReq;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "department")
    private String department;

    @Column(name = "code")
    private String code;

    @Column(name = "school")
    private String school;

    @Column(name = "url")
    private String url;

    @Column(name = "credits")
    private int credits;


    public List<Section> getSections() {
        return sections;
    }

    // for one to many relation
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Section> sections;


    public int getCoursesid() {
        return idcourses;
    }

    public void setCoursesid(int coursesid) {
        this.idcourses = coursesid;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + idcourses +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", school='" + school + '\'' +
                ", url='" + url + '\'' +
                ", credits=" + credits +
                ", preReq='" + preReq + '\'' +
                '}';
    }

    @Column(name = "pre_req")
    private String preReq;




}
