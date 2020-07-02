package com.web_app.springproject.entity;

import javax.persistence.*;

@Entity
@Table(name="registered")
public class Registered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idregistered")
    private int idregistered;


    // TODO  set up mapping to courses
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Courses course;

    public int getIdregistered() {
        return idregistered;
    }

    public void setIdregistered(int idregistered) {
        this.idregistered = idregistered;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registered{" +
                "idregistered=" + idregistered +
                ", course=" + course +
                '}';
    }
}
