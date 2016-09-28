//Antonino Febbraro
//Assignment 2
//October 15, 2015

//Player class

import java.text.*;
import java.util.*; 

public class Player {

	//Instance variables
	private String FirstName;
	private String LastName;
	private double RemainingMoney;
	private int TotalRoundsPlayed;
	private int RoundsWon;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

	public Player(String f,String l, String m, String p, String w){
	
		FirstName = f;
		LastName = l;
		RemainingMoney = Double.parseDouble(m);
		TotalRoundsPlayed = Integer.parseInt(p);
		RoundsWon = Integer.parseInt(w);
	}
	
	public String getLastName(){
	
		return LastName; 
		
	}
	
	public double addMoney(double mon){
	
		RemainingMoney = RemainingMoney + mon;
		return RemainingMoney;
	}
	
	public double subtractMoney(double mon){
	
		RemainingMoney = RemainingMoney - mon;
		return RemainingMoney;
	}
	
	public double getMoney(){
	
		return RemainingMoney;
	
	}
	
	public void wonAGame(){
	
		RoundsWon++; 
		TotalRoundsPlayed++; 
	
	}
	
	public void lostAGame(){
	
		TotalRoundsPlayed++;
		
	}
	
	public int gamesPlayed(){
		
		return TotalRoundsPlayed; 
		
	}
	
	public int gamesWon(){
		
		return RoundsWon; 
		
	}
	
	public String toString() {
	
		StringBuilder s = new StringBuilder();
		s.append("First Name: "+FirstName+"\n");
		s.append("Last Name: "+LastName+"\n");
		s.append("Money in Account: "+ formatter.format(RemainingMoney)+"\n");
		s.append("Games Played: "+TotalRoundsPlayed+"\n");
		s.append("Games Won: "+RoundsWon);
		return s.toString();
	}

}