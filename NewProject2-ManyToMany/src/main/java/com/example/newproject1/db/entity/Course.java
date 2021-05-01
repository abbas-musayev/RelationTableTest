package com.example.newproject1.db.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idCourse;

    private String nameCourse;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Review> reviewList = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();
}
