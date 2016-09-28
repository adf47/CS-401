//Antonino Febbraro
//Voter class -- this class is used ot store and manipulate the voters file

public class Voter {

	private String ID;
	private String Name;
	private String voted;

	public Voter(String id,String name, String ifVoted)
	{
		ID = id;
		Name = name;
		voted = ifVoted;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getId()
	{
		return ID;
	}
	
	public String getVoteStatus()
	{
		return voted;
	}
	
	public void hasVoted()
	{
		voted = "true";
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append(ID+":"+Name+":"+voted);
		
		return b.toString();
	}

}