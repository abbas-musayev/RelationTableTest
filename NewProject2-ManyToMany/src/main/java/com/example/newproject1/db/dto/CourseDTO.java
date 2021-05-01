package com.example.newproject1.db.dto;

import com.example.newproject1.db.entity.Review;
import com.example.newproject1.db.entity.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idCourse")
public class CourseDTO {

    private Long idCourse;

    private String nameCourse;

    private List<Review> reviewList = new ArrayList<>();

    private List<Student> studentList = new ArrayList<>();
}
