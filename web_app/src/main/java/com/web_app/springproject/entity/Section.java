package com.web_app.springproject.entity;

import javax.persistence.*;

@Entity
@Table(name="section")
public class Section {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsection;


    @Column(name = "date")
    private String date;

    @Column(name = "section")
    private String section;


    @Column(name = "instructor")
    private String instructor;

    @Column(name = "location")
    private String location;

    @Column(name = "time")
    private String time;

    @Column(name = "notes")
    private String notes;









}
