package com.example.newproject1.db.repo;

import com.example.newproject1.db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoStudent extends JpaRepository<Student,Long> {

}
