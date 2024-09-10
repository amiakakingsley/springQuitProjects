package com.amiaka.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String category;
	private int questionNumber;
	private long score;
	
	@ManyToMany
	private List<Question> qeustion;
	
	public Quiz() {}

	

	public Quiz(String category, int questionNumber, long score, List<Question> qeustion) {
		super();
		this.category = category;
		this.questionNumber = questionNumber;
		this.score = score;
		this.qeustion = qeustion;
	}


	public long getId() {
		return id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getQuestionNumber() {
		return questionNumber;
	}



	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}



	public List<Question> getQeustion() {
		return qeustion;
	}



	public void setQeustion(List<Question> qeustion) {
		this.qeustion = qeustion;
	}



	public void setId(long id) {
		this.id = id;
	}

	
	
	public long getScore() {
		return score;
	}



	public void setScore(long score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "Quiz [id=" + id + ", category=" + category + ", questionNumber=" + questionNumber + ", score=" + score
				+ ", qeustion=" + qeustion + "]";
	}
	
	
}
