package com.amiaka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

}
