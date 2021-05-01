package com.example.newproject1.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idStudent;

    private String nameStudent;
    private String surnameStudent;

    @JsonManagedReference
    @OneToOne
    private Passport passport;

    @JsonManagedReference
    @ManyToMany()
    @JoinTable(name = "STUDENTS_COURSES",
                joinColumns = @JoinColumn(name = "ID_STUDENT"),
                inverseJoinColumns = @JoinColumn(name = "ID_COURSE"))
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course){
        this.courseList.add(course);
    }
}