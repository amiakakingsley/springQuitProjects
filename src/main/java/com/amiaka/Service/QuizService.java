package com.amiaka.Service;

import java.util.List;

import com.amiaka.Model.QuestionWrapper;

public interface QuizService {
   long getQuizAnswer(long quizId, String userAnswer);
   
   void DeleteQuiz(long id);

   List<QuestionWrapper> creatQuiz(String category, int questionNumber);
}
