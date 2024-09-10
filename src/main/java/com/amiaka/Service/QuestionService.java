package com.amiaka.Service;

import java.util.List;

import com.amiaka.Dto.QuestionDto;
import com.amiaka.Model.Question;

public interface QuestionService {

	
  List<Question> findAllQuestions();
  
  List<Question> findByCategory(String category);
  
  void addQuestion(QuestionDto questionDto);
   
}
