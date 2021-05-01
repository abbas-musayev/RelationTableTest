package com.example.newproject1.db.repo;

import com.example.newproject1.db.entity.Passport;
import com.example.newproject1.db.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPassport extends JpaRepository<Passport,Long> {

}
