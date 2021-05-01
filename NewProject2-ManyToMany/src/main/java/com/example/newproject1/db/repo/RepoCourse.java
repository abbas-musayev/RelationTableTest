package com.example.newproject1.db.repo;

import com.example.newproject1.db.entity.Course;
import com.example.newproject1.db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCourse extends JpaRepository<Course,Long> {

}
