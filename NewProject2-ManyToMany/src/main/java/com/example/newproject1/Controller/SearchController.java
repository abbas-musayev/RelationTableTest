package com.example.newproject1.Controller;

import com.example.newproject1.Services.SearchServices;
import com.example.newproject1.db.dto.CourseDTO;
import com.example.newproject1.db.dto.StudentDTO;
import com.example.newproject1.db.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search",consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SearchController {

    private final SearchServices services;

    @GetMapping("/getAllCourse")
    public ResponseEntity<List<CourseDTO>> getAllCourse(){
        return new ResponseEntity<>(services.findAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/getALlStudent")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        return new ResponseEntity<>(services.findALlStudent(),HttpStatus.OK);
    }

}
