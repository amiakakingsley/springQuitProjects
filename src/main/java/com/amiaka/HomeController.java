package com.amiaka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.amiaka.Dto.QuestionDto;
import com.amiaka.Model.Question;
import com.amiaka.Service.QuestionService;

@Controller
public class HomeController {
	
	
	private final QuestionService questionservice;
	
	public HomeController(QuestionService questionservice) {
		this.questionservice = questionservice;
	}

	@GetMapping("/")
	public String Home(){
		return "Home";
	}
	
	@GetMapping("/addQuestions")
	public String retureAllQuestion() {
		return  "addQuestion";		
	}
	
	@PostMapping("/addQuestions")  
    public String AddQuestion(QuestionDto questionDto, Model model) {
	
		
		List<String> options = new ArrayList<String>();
		options.add(questionDto.getOption1());
		options.add(questionDto.getOption2());
		options.add(questionDto.getOption3());
		options.add(questionDto.getOption4());
		
		if(options.contains(questionDto.getRightAnswer())){
			questionservice.addQuestion(questionDto);
			return "redirect:/addQuestions?success";
		}
		
		return "redirect:/addQuestions?error";
	  }
	
	
	@GetMapping("/allQuestion")
	public String GetAllQuestion(Model model) {
       List<Question> questions =   questionservice.findAllQuestions();
       model.addAttribute("question", questions);
       return "Question";
		
	}
	
	@GetMapping("/get/{category}")
	public String GetQuestionsByCategort(Model model, @PathVariable String category) {
       List<Question> questions =   questionservice.findByCategory(category);
       model.addAttribute("question",  questions);
	   return "Question";
		
	}

	
}
