package com.example.newproject1.Services;

import com.example.newproject1.db.dto.CourseDTO;
import com.example.newproject1.db.dto.StudentDTO;
import com.example.newproject1.db.entity.Course;
import com.example.newproject1.db.entity.Student;
import com.example.newproject1.db.repo.RepoCourse;
import com.example.newproject1.db.repo.RepoPassport;
import com.example.newproject1.db.repo.RepoReview;
import com.example.newproject1.db.repo.RepoStudent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServices {

    private final RepoCourse repoCourse;
    private final RepoReview repoReview;
    private final RepoPassport repoPassport;
    private final RepoStudent repoStudent;

    public List<CourseDTO> findAllCourse(){
        List<Course> all = repoCourse.findAll();
        List<CourseDTO> dtoList = new ArrayList<>();

        all.forEach(item->{
            CourseDTO dto = new CourseDTO();
            dto.setNameCourse(item.getNameCourse());
            dto.setReviewList(item.getReviewList());
            dto.setStudentList(item.getStudentList());
            dtoList.add(dto);
        });
        return dtoList;
    }

    public List<StudentDTO> findALlStudent(){
        List<Student> all = repoStudent.findAll();
        List<StudentDTO> dtoList = new ArrayList<>();

        all.forEach(item->{
            StudentDTO dto = new StudentDTO();
            dto.setNameStudent(item.getNameStudent());
            dto.setSurnameStudent(item.getSurnameStudent());
            dto.setCourseList(item.getCourseList());
            dto.setPassport(item.getPassport());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
