//Antonino Febbraro
//CS 401
//Assignment 3

//Question class to create Question objects

import java.text.*;
import java.util.*; 

public class Question { 
	
	private String question;
	private int AnsNum; //for number of answers in question
	private String [] Que;
	private int CorrectAns;
	private int TimesTried;
	private int TimesCorrect;
	private boolean right;
	private int answer;
	
	//constructor
	public Question (int num, String a,String [] Ans,int x, int y, int t){
	
		question = a;
		
		Que = new String[num];
		
		int z=0;
		while(Ans.length > z){
			Que[z] = Ans[z];
			z++;
		}
		
		CorrectAns = x;
		TimesTried = y;
		TimesCorrect = t;
		
	}
	
	public void setUserAnswer(int a){ //method to set the user's answer
	
		answer = a;
	
	}
	
	public int getUserAnswer(){ //method to get user's answer
	
		return answer;
	
	}
	
	public int questionSize(){ //method to get size of array i.e get number of answer choices per questions
		
		return Que.length;
		
	}
	
	public int getAnswer(){ //method to get the correct answer
	
		return CorrectAns;
	
	}
	
	public boolean checkAnswer(){ //method to check if answer is right or not
	
		return right;
		
	}
	
	public String getQuestion(){ //method to get individual questions
	
		return question;
	
	}
	
	public void rightAnswer(){ //method to call when user gets answer right
	
		TimesCorrect++;
		TimesTried++;
		right = true;
	
	}
	
	public void wrongAnswer(){ //method to call when user gets answer wrong
	
		TimesTried++;
		right = false;
	
	}
	
	public int getTimesPlayed(){ //method to get number of times question has be answered
	
		return TimesTried;
	
	}
	
	public int getTimesCorrect(){ //method to get number of times question has be answered correctly
	
		return TimesCorrect;
	
	}
	
	public double getAvg(){ //method to get the average for each question
	
		return ((double)TimesCorrect/(double)TimesTried)*100;
	
	}
	
	public int getQuestionSize(){ //method to get question size
	
		return Que.length;
		
	}
	
	public String getArray(int x){ //method to get the array that holds the answer choices in the question
		
		String tempQuestion = Que[x];
		return tempQuestion;
	
	}
	
	public String toString() { //to print out Question Object nicely
	
		StringBuilder s = new StringBuilder();
		s.append(question+"\n");
		
		int z=0;
		while(Que.length > z){
			s.append(z+".) "+Que[z]+"\n");
			z++;
		}
		
		return s.toString();
	}

}