package com.ziad.quizapp.moudle;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/*if the table name and the class
 * name don't match..we must use 
 * @Table annotation
 * */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "quiz")
public class Quiz {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String difficultylevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String question_title;
	private String right_answer;
	
}
