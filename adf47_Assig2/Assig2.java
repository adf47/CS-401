//Antonino Febbraro
//Assignment 2
//October 15, 2015

//main block 

import java.util.*;
import java.io.*;
import java.text.*;

public class  Assig2 {

	

	public static void main (String [] args) throws IOException{
	 
		int i=0; // for the array that reads in the files
 		Player player; // Player class 	
 		
 		//primitive types for variables
 		double bet=0.0;	
 		int roll=0; 
 		int rollTwo=0;
 		int total=0; //for calculating sum of both die
 		String pl ="";//for deciding to play 
 		
		String [] ar = new String[5]; // the array that reads in the files
		
		//for formating money
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		Scanner input = new Scanner(System.in);
		
		
			System.out.println("Please enter in your first name!");
			String fileName = input.nextLine();
		
			System.out.println();//just to space things out to look nice 
		
			File file = new File(fileName+".txt");
		
			if(file.exists()){
			
				BufferedReader br = new BufferedReader(new FileReader(fileName+".txt"));
 				String line;
 				while ((line = br.readLine()) != null) {
 				
 					ar[i]= line;
  			 		i++;
 			}
 			
 			//To reset the array index
 			i=0;
 			
 			//add in classes here.
 			player = new Player(ar[0],ar[1],ar[2],ar[3],ar[4]);
 			
 			System.out.println("Welcome Back!");
 			System.out.println();//to space things out
 			System.out.println(player);
		}
		
		else{ //for is file doesn't exist creating a new file
			PrintWriter writer = new PrintWriter(fileName +".txt", "UTF-8");
			ar[0]=fileName;
			writer.println(fileName);
			System.out.println("Enter last name.");
			ar[1]=input.nextLine();
			writer.println(ar[1]);
			System.out.println("How much cash would you like to deposit?");
			ar[2]=input.nextLine();
			writer.println(ar[2]);
			writer.println(0);
			writer.println(0);
			ar[3]="0";
			ar[4]="0";
			writer.close();
		
			//add in classes here
			player = new Player(ar[0],ar[1],ar[2],ar[3],ar[4]);
		
			System.out.println(); //just to space things out to look nice 
			
			System.out.println(player);
		}
		
		System.out.println();//to space things out 
		
		//start game code here
		while(player.getMoney()>0){
			
			//to reset the roll back to zero
			roll=0;
			
			System.out.println("Would you like to bet?(Y/N)");
			pl = input.next();
			
			while(!pl.equalsIgnoreCase("Y") && !pl.equalsIgnoreCase("N")){
				
					System.out.println("Invalid input. Would you like to bet?(Y/N)");
					pl = input.next();
				
			}
			
			if(pl.equalsIgnoreCase("n")){
				//exit the game
				System.out.println();//to space things out
				System.out.println("Thanks for Playing! Come Again!");
				System.out.println();//to space things out
				System.out.println("Here is your updated account:");
				System.out.println(player);
				
				System.exit(0);
			}
			if(pl.equalsIgnoreCase("y")){
				
				
				//Play the game
				System.out.println("How much would you like to bet?(<= "+formatter.format(player.getMoney())+")");
				bet = input.nextDouble();
				
				while(bet<=0 || bet >player.getMoney()){
				
					System.out.println("How much would you like to bet?(<= "+formatter.format(player.getMoney())+")");
					bet = input.nextDouble();
				
				}
				
				
				//choosing to bet ovr under or seven
				System.out.println("Select your choice: O(ver), U(nder), S(even)");
				String choice = input.next();
				
				while(!choice.equalsIgnoreCase("O")&&!choice.equalsIgnoreCase("U")&&!choice.equalsIgnoreCase("S")){
				
					System.out.println("Invalid input. Select your choice: O(ver), U(nder), S(even)");
					choice = input.next();
				
			}
				
				if(choice.equalsIgnoreCase("O")){
				
					//rolling the dice
					Die die = new Die();
					Die dieTwo = new Die();
					roll=die.Roll();
					rollTwo = dieTwo.Roll(); 
					total = roll + rollTwo; 
					
					System.out.println(); //to space things out make output look nice
					System.out.println("You bet over!");
					
					//determining if user won
					if(total>7){
						
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("YOU WON!!!");
						player.addMoney(bet);
						player.wonAGame();	
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));				
					}
					
					else{
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("Sorry! You lost.");
						player.subtractMoney(bet);
						player.lostAGame();
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));
					}
					
					
				}
				
				//for under seven
				if(choice.equalsIgnoreCase("U")){
							
					//rolling the dice
					Die die = new Die();
					Die dieTwo = new Die();
					roll=die.Roll();
					rollTwo = dieTwo.Roll(); 
					total = roll + rollTwo; 
					
					System.out.println(); //to space things out make output look nice
					System.out.println("You bet under!");
					
					//determining if user won
					if(total<7){
						
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("YOU WON!!!");
						player.addMoney(bet);
						player.wonAGame();	
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));				
					}
					
					else{
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("Sorry! You lost.");
						player.subtractMoney(bet);
						player.lostAGame();
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));
					}
				}
				
				//for rolling a seven
				if(choice.equalsIgnoreCase("S")){
				
					//rolling the dice
					Die die = new Die();
					Die dieTwo = new Die();
					roll=die.Roll();
					rollTwo = dieTwo.Roll(); 
					total = roll + rollTwo; 
					
					System.out.println(); //to space things out make output look nice
					System.out.println("You bet seven!");
					
					//determining if user won
					if(total==7){
						
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("YOU WON!!!");
						player.addMoney(bet*4);
						player.wonAGame();	
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));				
					}
					
					else{
						System.out.println("You rolled a "+ roll + " and a " + rollTwo);
						System.out.println("Your roll total is: " + total);
						System.out.println("Sorry! You lost.");
						player.subtractMoney(bet);
						player.lostAGame();
						
						//showing user new money updates
						System.out.println();
						System.out.println("Here is your updated money: "+formatter.format(player.getMoney()));
					}
				}
				
				
			}
			
			System.out.println();//to space out the info
			
			
			//for writing new info to the file to update the file. 
			PrintWriter writer = new PrintWriter(fileName +".txt", "UTF-8");
			writer.println(fileName);
			writer.println(player.getLastName());
			writer.println(player.getMoney());
			writer.println(player.gamesPlayed());
			writer.println(player.gamesWon());
			
			writer.close();
		
		}
		
		
	} 

}