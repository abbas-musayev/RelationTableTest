package com.example.newproject1.Controller;

import com.example.newproject1.Services.CrudServices;
import com.example.newproject1.db.dto.CourseDTO;
import com.example.newproject1.db.entity.Course;
import com.example.newproject1.db.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/crud",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CrudController {
    private final CrudServices services;

    @PostMapping("/courseSave")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(services.saveCourse(courseDTO), HttpStatus.OK);
    }

    @PostMapping("/studentSave")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(services.saveStudent(student),HttpStatus.OK);
    }

    @PostMapping("/saveManyToMany/{id1}/{id2}")
    public void saveManyToMany(@PathVariable Long idStudent,@PathVariable Long idCourse){
        services.saveManyToMany(idStudent,idCourse);
    }


}
