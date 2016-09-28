//Antonino Febbraro
//Assignment 4

//Main Program

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;


public class Assig4
{
	private JFrame theWindow;
	private ArrayList <Ballot> theBallots;
	//private ArrayList <Poll> polls;
	private JButton castVote;
	private JButton Login;
	private String name;
	private String clickVote;
	private ArrayList<Voter> voterList = new ArrayList<Voter>();
	private File voterFile;
	private File file;//file that holds the vote counts
	private File tempVoter;
	private File tempTally;
	private File BallotFile;
	
	public Assig4(String [] B)throws IOException 
	{
		
 		//polls = new ArrayList<Poll>();
		
		voterFile = new File("voters.txt");
		
		//grabbing file name from the command prompt
		for (String s: B) 
		{
        	BallotFile = new File(s);
    	}
		
		
		// Create the window and all of the Button panels.	
		theWindow = new JFrame("The Voting Machine");
		theWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		theWindow.setLayout(new FlowLayout());
		

		// A separate button is put after the panels to count
		// how many of the encapsulated buttons have been clicked.  
		castVote = new JButton("Cast Your Vote");
		castVote.setEnabled(false);
		castVote.addActionListener(new ClickListener());
		
		Login = new JButton("Click to Login in");
		ActionListener LoginListener = new LoginListener();
		Login.addActionListener(LoginListener);
		
		theWindow.setVisible(true);
			
		//READING IN THE BALLOTS FILE SENT FROM COMMAND LINE 		
		BufferedReader br = new BufferedReader(new FileReader(BallotFile));
 		String line;
 		String id="";
 		

		String temp = br.readLine();
 		int ballotNum = Integer.parseInt(temp);//gets the ballot number
 		theBallots = new ArrayList<Ballot>(ballotNum);
 		
 		while((line=br.readLine())!=null)//reading in the ballots file
 			{
 				String [] head = line.split(":");
 				id = head[0];
 				String Head = head[1];
 				String [] buttons = head[2].split(",");
 				theBallots.add(new Ballot(id,Head,buttons));
 			
			}
			
			BufferedReader brs = new BufferedReader(new FileReader(voterFile)); //reading in the voters file
			String lines;
			while((lines = brs.readLine())!=null)
			{
				String [] voters = lines.split(":");
				voterList.add(new Voter(voters[0],voters[1],voters[2]));
				
			}
		
		try {
		
		int t=0;
		while(t<theBallots.size())
		{
			file = new File(theBallots.get(t).getID()+".txt"); //reading in/ creating the ballot recording files
			
			if(file.exists())
				{
					BufferedReader b = new BufferedReader(new FileReader(file));
					String lin;
					while((lin=b.readLine())!=null)
					{
						String [] splits = lin.split(":");
						String poll = splits[0];
						String tally = splits[1];
						theBallots.get(t).setPolls(poll,tally);
						
					}
				}
				else
				{
					PrintWriter writer = new PrintWriter(theBallots.get(t).getID()+".txt", "UTF-8");
					
					writer.println(theBallots.get(t).setVotes());
			
					writer.close();
					
					//reading in the brad new file to ballot constructor etc
					BufferedReader b = new BufferedReader(new FileReader(file));
					String lin;
					while((lin=b.readLine())!=null)
					{
						String [] splits = lin.split(":");
						String poll = splits[0];
						String tally = splits[1];
						theBallots.get(t).setPolls(poll,tally);
						
					}
				}
				t++;
			}
		}
		catch(IOException err){}	
			
		int x=0;
		while(x<theBallots.size())//creating the Ballot objects
		{
			theWindow.add(theBallots.get(x));
			x++;
		}
		
		theWindow.add(Login);
		theWindow.add(castVote);
		theWindow.pack();
	}
	
	class ClickListener implements ActionListener //FOR CASTING THE VOTE
	{
		public void actionPerformed(ActionEvent e)
		{
			//ADD IN DIALOG BOX TO CONFIRM VOTE!!!!
			int dialogResult = JOptionPane.showConfirmDialog (theWindow, "Confirm vote?");
			
			if(dialogResult == JOptionPane.YES_OPTION){//confirming vote 
			//confirming vote
			JOptionPane.showMessageDialog(theWindow,"Thank you for your vote!");
			
			//resetting the voting machine 
			Login.setEnabled(true);
			castVote.setEnabled(false);
			
			for(int c=0;c<theBallots.size();c++)
			{
				theBallots.get(c).Disable();
			}
			
			//Safe file update set up READING IN FILES AGAIN TO COPY
			try {//getting temp file for voters
				tempVoter = new File("voterTemp.txt");//temporary files
				BufferedReader b = new BufferedReader(new FileReader(voterFile));//holds the voters (persons)
				PrintWriter tempW = new PrintWriter(tempVoter,"UTF-8");
				
				String br;
				while((br= b.readLine())!=null)
					{
						tempW.println(br);
					}
					tempW.close();
			}
			catch(IOException err){}
			
			
			try {//getting temp file for tallies 
			
				int x=0;
				while(x<theBallots.size())
				{
					tempTally = new File("tempTally.txt");
					PrintWriter w = new PrintWriter(tempTally,"UTF-8");
					BufferedReader r = new BufferedReader(new FileReader(theBallots.get(x).getID()+".txt"));
					String g;
					
					while((g=r.readLine())!=null)
					{
						w.println(g);
					}
					w.close();
					
					x++;
				}
			}
			catch(IOException err){}
			
			
			for (int z=0;z<theBallots.size();z++)
			{
				boolean ans = theBallots.get(z).getStatus();
				String button = theBallots.get(z).getClickName();
				if (ans)
					clickVote = button;
				
				//UPDATE FILES HERE
				
				try{
						PrintWriter writer = new PrintWriter(theBallots.get(z).getID()+".txt", "UTF-8");
						writer.println(theBallots.get(z).addVote(clickVote));
						writer.close();
						tempTally.delete();//deleting the temp file
					}
				catch(IOException err){
					//catch the errors writer from temp file
					
					try {
						
						int x=0;
						while(x<theBallots.size()){
						
							PrintWriter w = new PrintWriter(theBallots.get(x).getID()+".txt","UTF-8");
							BufferedReader r = new BufferedReader(new FileReader(tempTally));
							String g;
					
							while((g=r.readLine())!=null)
							{
								w.println(g);
							}
							w.close();
							x++;
						}
					}
					catch(IOException errr){}
				}	
			}
			
			try {
				PrintWriter writers = new PrintWriter(voterFile, "UTF-8");
				
				int x =0;
				while(x < voterList.size())
				{
					writers.println(voterList.get(x).toString());
					x++;
				}
				writers.close();
				tempVoter.delete();//deleting the temp file
			}
			catch(IOException err) {
				//catch the errors for voters file 
				try {
					BufferedReader b = new BufferedReader(new FileReader(tempVoter));//holds the voters (persons)
					PrintWriter tempW = new PrintWriter(voterFile,"UTF-8");
				
					String s;
					while((s=b.readLine())!=null)
					{
						tempW.println(s);
					}
						tempW.close();
						
					}
				catch(IOException errr){}
			}
			}//end of outer if statement 
	}
}
	
	class LoginListener implements ActionListener //FOR LOGING IN 
	{
		
	public void actionPerformed(ActionEvent e) 
		{
	
		int c =0;
		
		int x = 0;
		String id = JOptionPane.showInputDialog(theWindow,"Enter your voters ID for Login");
		while(x<voterList.size())
		{
			String temp = voterList.get(x).getId();
			String t = voterList.get(x).getVoteStatus();
			if(temp.equals(id) && t.equals("false"))
			{
					c=1;
					Login.setEnabled(false);
					castVote.setEnabled(true);
					name = voterList.get(x).getName();
					JOptionPane.showMessageDialog(theWindow,"Welcome, "+name+" it is time to vote!");
					int y=0;
					while(y<theBallots.size())
					{
						theBallots.get(y).setEnable();
						y++;
					}
					voterList.get(x).hasVoted();
					break;
			}
			if(temp.equals(id) && t.equals("true"))
			{
				c=1;
				name = voterList.get(x).getName();
				JOptionPane.showMessageDialog(theWindow,"Welcome, "+name+" you have already voted!");
			}
			
			x++;
		}
		
		if(c == 0)
		{
			JOptionPane.showMessageDialog(theWindow,"Sorry, your voting file does not exist");
			
		}
			
		}
	}

	public static void main(String [] args) throws IOException
	{
		new Assig4(args);
	}
}