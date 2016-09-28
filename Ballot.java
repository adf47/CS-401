//Antonino Febbraro
//Ballot Class for setting up the Ballots on the screen, extends JPanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class Ballot extends JPanel
{
	private JLabel theLabel;
	private JButton [] theButton;
	private int ballotID;
	private boolean clicked;
	private String buttonName;
	private String [] ButtonNames;
	private int voteCount;
	private String id;
	private String poll;
	private ArrayList<Integer> VOTES = new ArrayList<Integer>();

	public Ballot(String ID,String Header, String [] buttons)
	{
		ButtonNames = new String[buttons.length];
		int z=0;
		while(z<buttons.length)
		{
			ButtonNames[z] = buttons[z];//deep copy 
			z++;
		}
		
		id = ID;
		
		theButton = new JButton[buttons.length];
		theLabel = new JLabel(Header);
		theLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clicked = false;
		ActionListener listen = new BListener();
		//theButton.addActionListener(listen);
		setLayout(new GridLayout(0,1));
		
		add(theLabel);
		
		for(int x=0;x<buttons.length;x++)
		{
			theButton[x] = new JButton(buttons[x]);
			theButton[x].addActionListener(listen);
			theButton[x].setEnabled(false);
			add(theButton[x]);
		}
		
	}
	
	public String getID()
	{
		return id;
	}
	
	public String addVote(String vote)//method for updating ballot counts 
	{
		int x=0;
		StringBuilder b = new StringBuilder();
		
		while(x<ButtonNames.length)
		{
			if(ButtonNames[x].equals(vote))
			{
				int ne = VOTES.get(x)+1;
				b.append(vote+":"+ne);
			}
			else
			{
				b.append(ButtonNames[x]+":"+VOTES.get(x));
			}
			x++;
			if(x<ButtonNames.length)
			{
				b.append("\n");
			}
		}
		return b.toString();
	}
	
	
	public String setVotes() //method that returns the votes to a NEW file
	{
		int x=0;
		StringBuilder b = new StringBuilder();
		String [] votes = new String[ButtonNames.length];
		
		while(x<votes.length)
		{
			votes[x]=ButtonNames[x]; //making a deep copy
			b.append(votes[x]+":0");
			x++;
			if(x<votes.length)
			{
				b.append("\n");
			}
		}
		return b.toString();
	}
	
	public String getClickName()
	{
		return buttonName;
	}

	public void setEnable()
	{
		int x=0;
		while(x<theButton.length)
		{
			theButton[x].setEnabled(true);
			x++;
		}
	}
	
	public void Disable()
	{
		int x=0;
		while(x<theButton.length)
		{
			theButton[x].setEnabled(false);
			x++;
		}
		
		for(int z=0;z<theButton.length;z++)
		{
			theButton[z].setForeground(Color.black);
		}
		
	}
	
	public void setLabel(String s)
	{
		theLabel.setText(s);
	}
	
	public boolean getStatus()
	{
		return clicked;
	}
	
	public void setPolls(String x,String y)
	{
		poll = x;
		voteCount = Integer.parseInt(y);
		VOTES.add(voteCount);
	}
	
	public String getVotes() //method for updating polls files when new file is made 
	{
		StringBuilder b = new StringBuilder();
		b.append(poll+":"+voteCount);
		return b.toString();
	}
		
	// Listener to toggle the status of the panel each time
	// the button is clicked.
	private class BListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clicked = !clicked;
			
			for (int x=0;x<theButton.length;x++)
				{
					if(clicked&&e.getSource()==theButton[x])
					{
						theButton[x].setForeground(Color.red);
						buttonName = theButton[x].getText();
					}
					else 
					{
						theButton[x].setForeground(Color.black);
					}
				
				}
		}
	}

}