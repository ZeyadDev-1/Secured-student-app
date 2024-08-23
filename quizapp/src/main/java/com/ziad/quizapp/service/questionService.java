package com.ziad.quizapp.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ziad.quizapp.moudle.Quiz;
import com.ziad.quizapp.repository.QuestionsRepository;

@Service
public class questionService {

	private QuestionsRepository repo;
	
	public questionService(QuestionsRepository repo) {
		super();
		this.repo = repo;
	}


	public List<Quiz> getAllQuestions() {
	return repo.findAll();
	}


	public List<Quiz> getByCategory(String keyword) {
		return repo.getByCategory(keyword);
	}


	public Quiz addQuestion(Quiz quiz) {
		return repo.save(quiz);
	}

	
}
