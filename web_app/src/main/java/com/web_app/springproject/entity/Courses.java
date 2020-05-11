package com.web_app.springproject.entity;

import javax.persistence.*;

// this will only be a read only class
@Entity
@Table(name = "courses")
public class Courses {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
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
