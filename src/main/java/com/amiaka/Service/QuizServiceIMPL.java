package com.amiaka.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.amiaka.Model.Question;
import com.amiaka.Model.QuestionWrapper;
import com.amiaka.Model.Quiz;
import com.amiaka.Repository.QuestionRepo;
import com.amiaka.Repository.QuizRepo;
@Service
public class QuizServiceIMPL implements QuizService {
	
	private final QuestionRepo questionRepo;
	private final QuizRepo quizRepo;
	
	public QuizServiceIMPL(QuestionRepo questionRepo, QuizRepo quizRepo) {
		super();
		this.questionRepo = questionRepo;
		this.quizRepo = quizRepo;
	}

	@Override
	public List<QuestionWrapper> creatQuiz(String category, int num) {
		List<Question> question = questionRepo.findRandomQuestionsByCategory(category, num);
		
		Quiz quiz = new Quiz();	
		quiz.setCategory(category);
		quiz.setQuestionNumber(num);		
		quiz.setQeustion(question);
		quiz.setScore(0);
	    quizRepo.save(quiz);
	    
	    long id = quiz.getId();
	   
		
		List<QuestionWrapper> mainQuiz = new ArrayList<>();
		for(Question q : question) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), id, q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			mainQuiz.add(qw);
		}
        return mainQuiz;
	}

	@Override
	public long getQuizAnswer(long quizId, String rightAnswer) {
		
		
		Quiz quiz = quizRepo.findById(quizId).get();
		List<Question> questions = quiz.getQeustion();
		
		List<String> rightAnswer2 = new ArrayList<String>();

		for(Question question : questions) {
			rightAnswer2.add(question.getRightAnswer());
		}
		if(rightAnswer2.contains(rightAnswer)) {
		   
		   quiz.setScore(quiz.getScore()+1);
           quizRepo.save(quiz);
		}
		
		return quiz.getScore();
	}
	
	@Override
	public void DeleteQuiz(long score) {
		// TODO Auto-generated method stub
		
	}

	

}
