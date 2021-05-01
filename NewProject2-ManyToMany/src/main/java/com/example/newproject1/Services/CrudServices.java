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

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrudServices {

    private final RepoCourse repoCourse;
    private final RepoReview repoReview;
    private final RepoPassport repoPassport;
    private final RepoStudent repoStudent;

    public Course saveCourse(CourseDTO courseDto){
        Course course = new Course();
        course.setIdCourse(courseDto.getIdCourse());
        course.setNameCourse(courseDto.getNameCourse());
        course.setReviewList(courseDto.getReviewList());
        course.setStudentList(courseDto.getStudentList());

        repoCourse.save(course);
        repoReview.saveAll(course.getReviewList());
        repoStudent.saveAll(course.getStudentList());

        return course;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        Student student = new Student();

        student.setIdStudent(studentDTO.getIdStudent());
        student.setNameStudent(studentDTO.getNameStudent());
        student.setSurnameStudent(studentDTO.getSurnameStudent());
        student.setCourseList(studentDTO.getCourseList());
        student.setPassport(studentDTO.getPassport());

        repoStudent.save(student);
        repoCourse.saveAll(student.getCourseList());
        repoPassport.save(student.getPassport());

        return studentDTO;
    }


    public void saveManyToMany(Long idStudent,Long idCourse){
        Student student = repoStudent.findById(idStudent).get();
        Course course = repoCourse.findById(idCourse).get();

        student.addCourse(course);

        repoStudent.save(student);
    }
}
