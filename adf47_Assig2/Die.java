//Antonino Febbraro
//Assignment 2
//October 15, 2015

//Die Class

import java.util.Random;

public class Die {

	//Instance variables 
	private Random ran = new Random();
	private int Dice;

	public Die (){
	
		Dice = ran.nextInt(6);
		
	}
	
	public int Roll(){
	
		Dice = Dice +1;
		return Dice; 
	
	}

}