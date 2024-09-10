package com.amiaka.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amiaka.Model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findByCategory(String category);

@Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RAND() LIMIT :num", nativeQuery = true)
List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("num") int num);

}
