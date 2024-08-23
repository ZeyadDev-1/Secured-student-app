package com.ziad.quizapp.controller;

import java.util.List;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ziad.quizapp.moudle.Quiz;
import com.ziad.quizapp.service.questionService;

@RestController
@RequestMapping("/question")
@Controller
public class QuestionController {
	
	public questionService service;

	public QuestionController(questionService service) {
		super();
		this.service = service;
	}


	@GetMapping("/allQuestions")
	public ResponseEntity<?> getAllQuestion() {
		
		try {
			List<Quiz> quizes = service.getAllQuestions();
			return new ResponseEntity<> (quizes, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<> ("Something went wrong: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable String category){
		try {
			
			List<Quiz> quizes = service.getByCategory(category);
			return new ResponseEntity<> (quizes,HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseEntity<>("Not found"+e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addQuestion(@RequestBody Quiz question) {
		
		try { 
		Quiz newRow = service.addQuestion(question);
		return new ResponseEntity<> (newRow+" added !",HttpStatus.CREATED);
		
	} catch (Exception e) {
		return new ResponseEntity<> (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
}
