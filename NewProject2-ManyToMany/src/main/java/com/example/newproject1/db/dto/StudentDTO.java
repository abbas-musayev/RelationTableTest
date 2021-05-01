package com.example.newproject1.db.dto;

import com.example.newproject1.db.entity.Course;
import com.example.newproject1.db.entity.Passport;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idStudent")
public class StudentDTO {
    private Long idStudent;

    private String nameStudent;
    private String surnameStudent;

    @JsonManagedReference
    private Passport passport;

    @JsonManagedReference
    private List<Course> courseList = new ArrayList<>();

}
