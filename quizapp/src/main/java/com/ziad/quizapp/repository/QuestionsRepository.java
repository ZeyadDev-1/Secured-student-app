package com.ziad.quizapp.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ziad.quizapp.moudle.Quiz;

@Repository
public interface QuestionsRepository extends JpaRepository<Quiz, Integer>{

	
	/* HQL language deals with 
	 * the class's name in our application..not the actual table's name in our
	 * database..that's why [Quiz] class must be written with
	 * case sensitivity taken into consideration*/
	
	//@Query("select q from Quiz q where q.category = :keyword")
	
	List<Quiz> getByCategory(String category);

	
}
