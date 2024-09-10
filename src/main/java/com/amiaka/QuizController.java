package com.amiaka;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amiaka.Model.QuestionWrapper;
import com.amiaka.Service.QuizService;

@Controller
public class QuizController {
	
	private final QuizService quizService;
	private List<QuestionWrapper> quiz;


	public QuizController(QuizService quizService, List<QuestionWrapper> quiz) {
		super();
		this.quizService = quizService;
		this.quiz = quiz;
	}
	
	@GetMapping("/quizMenu")
	public String GetQuizMenu() {
		return "QuizMenu";
	}
	
	@PostMapping("/creatQuiz")
	public String CreatQuiz(@RequestParam String category, 
	@RequestParam int questionNumber, Model model) {
	 this.quiz = quizService.creatQuiz(category, questionNumber);
		
	    Random rand = new Random();
		int numberOfElements = 1;
		QuestionWrapper randomElement = new QuestionWrapper();

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(this.quiz.size());
			randomElement = this.quiz.get(randomIndex);
			}
	    model.addAttribute("question", randomElement );
	    return "QuizMenu";
	}
	 
	@GetMapping("/quizMenu2")
	public String QuizMenu1(Model model, @RequestParam String userAnswer) {

		QuestionWrapper randomElement = new QuestionWrapper();

		Random rand = new Random();
		int numberOfElements = 1;

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(this.quiz.size());
			randomElement = this.quiz.get(randomIndex);

			this.quiz.remove(randomIndex);
		}

		long score = CheckAnswer(randomElement.getQuizId(), userAnswer);

		if (quiz.isEmpty()) {
			model.addAttribute("score", "You have a total score of: " + score + " points");
			return "result";
		}
		model.addAttribute("question", randomElement);
		model.addAttribute("score", score);

		return "QuizMenu";
	}

		
	public Long CheckAnswer(Long id, String userAnswer) {
	return quizService.getQuizAnswer(id, userAnswer);
	}
	
	
	@GetMapping("deleteScore/{score}")
	public String Home(@PathVariable long score) {
		
		return "home";
	}
	
	
	
}
