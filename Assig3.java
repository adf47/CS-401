//Antonino Febbraro
//CS 401
//Assignment 3

//Main Class i.e Main

import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;

public class Assig3 {

	public static void main (String [] args) throws IOException{
	
				ArrayList <Question> Que = new ArrayList <Question>(); //for making ArrayList of questions
				Question question; //initializing Question variable  
				Scanner in = new Scanner (System.in);//setting up scanner
				int ans; //for what the user answers
				String [] temp;
				int count = 0; //to count number of questions right
				DecimalFormat formatter = new DecimalFormat("0.0");//to format the percentages 
				
				String file=""; //string that holds file name from the command prompt.
				
				//grabbing file name from the command prompt
				 for (String s: args) {
            			file = s;
        		}
				
				BufferedReader br = new BufferedReader(new FileReader(file));
 				String line;
 				
 				while ((line = br.readLine()) != null) { //READING IN THE FILE
 				
 					if(line.contains("?")){
 						String questions = line;
 						int tempNum = Integer.parseInt(br.readLine());
 						temp = new String [tempNum];
 						
 						int x=0;
 						while(temp.length > x){
 							temp[x] = br.readLine(); //array to hold the questions
 							x++;
 						}
 						//to parse ints for constructor
 						int c=Integer.parseInt(br.readLine()); //int that represents correct answer
 						int d=Integer.parseInt(br.readLine()); //int that represents times tried
 						int e=Integer.parseInt(br.readLine()); //in that represents times answered correct
 						
 						Que.add(new Question(tempNum,questions,temp,c,d,e));//creating array list of Question objects
 						
 					}
 					
 			}
 			
 			//START THE QUESTION GAME HERE
 			System.out.println("Welcome to the Question Game!"+"\n");
 			System.out.println();//to space things out make things look nice 
 		
 			//for printing the questions	
 			int j = 0;
			while (Que.size() > j) {
				System.out.println("Question: "+ (j+1));
				System.out.println(Que.get(j));
				System.out.println("Enter in your answer");
				ans = in.nextInt();
				//ans = Integer.parseInt(JOptionPane.showInputDialog("Question: "+(j+1)+"\n"+Que.get(j)+"\n"+"\n"+"Enter in your answer"));
								
				while(ans<0 || ans > Que.get(j).questionSize()-1){
					System.out.println("Invalid input: Enter in your answer");
					ans = in.nextInt();
					//ans = Integer.parseInt(JOptionPane.showInputDialog("Question: "+(j+1)+"\n"+Que.get(j)+"\n"+"\n"+"Invalid input. Enter in your answer"));
				}
				
				//NOW COMPARE THE ANSWERS TO SEE IF THEY ARE RIGHT
				//just a test, can'd do this in real program
				if(Que.get(j).getAnswer()==ans){
				
					Que.get(j).rightAnswer();
					Que.get(j).setUserAnswer(ans);
				}
				else{
					Que.get(j).wrongAnswer();
					Que.get(j).setUserAnswer(ans);
				}
				
				System.out.println();//to space things out, make things look nice 
				j++;
			}
			j=0;
			//DISPLAY IF USER GOT QUESTION RIGHT
			System.out.println("Thank you for taking the quiz");
			System.out.println("Here are your results");
			
			while(Que.size() > j){
				
				if(Que.get(j).checkAnswer()){
					System.out.println("Question: "+Que.get(j).getQuestion());
					System.out.println("Correct Answer: " + Que.get(j).getAnswer());
					System.out.println("Your Answer: " + Que.get(j).getUserAnswer());
					System.out.println("YOU ARE CORRECT!");
					System.out.println("----------------------------------------------------------");
					count++;
					j++;
				}
				else{
					System.out.println("Question: "+Que.get(j).getQuestion());
					System.out.println("Correct Answer: " + Que.get(j).getAnswer());
					System.out.println("Your Answer: " + Que.get(j).getUserAnswer());
					System.out.println("Sorry you missed this one.");
					System.out.println("----------------------------------------------------------");
					j++;
				
				}
				
				System.out.println();//to space things out
			}
			j=0;
			
			System.out.println("----------------------------------------------------------");
			//Display a "Grade" or score 
			System.out.println("YOUR OVERALL SCORE IS: ");
			System.out.println("Right: "+count);
			System.out.println("Wrong: "+(Que.size()-count));
			int temps = Que.size();
			double score = ((double)count/(double)temps)*100;//to display score percentage
			System.out.println("Percent Correct: "+ formatter.format(score)+"%");
			System.out.println();//to space things out
			
			//DISPLAYING STATISTICS FOR EACH QUESTION
			
			System.out.println("OVERALL PERCENTAGE RESULTS FOR ALL QUESTIONS");
			while(Que.size() > j){
				
				System.out.println("Question: "+Que.get(j).getQuestion());
				System.out.println("Times Tried: " + Que.get(j).getTimesPlayed());
				System.out.println("Times Correct: " + Que.get(j).getTimesCorrect());
				System.out.println("Percent Correct: "+ formatter.format(Que.get(j).getAvg())+"%");
				System.out.println("----------------------------------------------------------");	
				j++;	
				System.out.println();//to space things out
			}
			j=0;
			
			//TO GET THE EASIEST AND HARDEST QUESTIONS RESULTS
			
			//GETTING EASIEST QUESTION
			j=1;
			double easy = Que.get(0).getAvg();
			int times = Que.get(0).getTimesPlayed();
			int won = Que.get(0).getTimesCorrect();
			String easiest = Que.get(0).getQuestion();
			
			while(Que.size() > j){
				
				if(Que.get(j).getAvg() > easy){
					easy = Que.get(j).getAvg();
					easiest = Que.get(j).getQuestion();
					times = Que.get(j).getTimesPlayed();
				 	won = Que.get(j).getTimesCorrect();
				}
				j++;
			}
			
			System.out.println("Easiest Question: ");
			System.out.println(easiest);
			System.out.println("Times Tried: "+times);
			System.out.println("Times Correct: "+won);
			System.out.println("Percent Correct: "+ formatter.format(easy)+"%");
			System.out.println();//to space things out
			System.out.println("----------------------------------------------------------");
			
			//GETTING HARDEST QUESTION
			j=1;
			double hard = Que.get(0).getAvg();
			times = Que.get(0).getTimesPlayed();
			won = Que.get(0).getTimesCorrect();
			String hardest = Que.get(0).getQuestion();
			
			while(Que.size() > j){
				
				if(Que.get(j).getAvg() < hard){
					hard = Que.get(j).getAvg();
					hardest = Que.get(j).getQuestion();
					times = Que.get(j).getTimesPlayed();
				 	won = Que.get(j).getTimesCorrect();
				}
				j++;
			}
			
			System.out.println("Hardest Question: ");
			System.out.println(hardest);
			System.out.println("Times Tried: "+times);
			System.out.println("Times Correct: "+won);
			System.out.println("Percent Correct: "+ formatter.format(hard)+"%");
			
			//WRITE FILE TO UPDATE THE FILE, USE A WHILE LOOP AGAIN
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			j=0;
			int i=0; //for inside array
			
			while(Que.size() > j){
			
				writer.println(Que.get(j).getQuestion());
				writer.println(Que.get(j).getQuestionSize());
				
				while(Que.get(j).getQuestionSize() > i){
					writer.println(Que.get(j).getArray(i));
					i++;
				}
				i=0;
				writer.println(Que.get(j).getAnswer());
				writer.println(Que.get(j).getTimesPlayed());
				writer.println(Que.get(j).getTimesCorrect());
				
				j++;
			}
			
			writer.close();
		
			
	
	}

}