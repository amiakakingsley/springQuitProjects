package com.amiaka.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amiaka.Dto.QuestionDto;
import com.amiaka.Model.Question;
import com.amiaka.Repository.QuestionRepo;
@Service
public class QuestionServiceIMPL implements QuestionService {
	
	private final QuestionRepo questionRepo;
	

	public QuestionServiceIMPL(QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	@Override
	public List<Question> findAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public void addQuestion(QuestionDto questionDto) {
		Question question = new Question();
		
		question.setQuestion(questionDto.getQuestion());
		question.setOption1(questionDto.getOption1());
		question.setOption2(questionDto.getOption2());
		question.setOption3(questionDto.getOption3());
		question.setOption4(questionDto.getOption4());
		question.setRightAnswer(questionDto.getRightAnswer());
		question.setCategory(questionDto.getCategory());
		
		questionRepo.save(question);
		
		
	}

	@Override
	public List<Question> findByCategory(String category) {
		// TODO Auto-generated method stub
		return questionRepo.findByCategory(category);
	}

}
