// CS 401 Fall 2015
// Outline of EnhancedDeque class for Lab 10.  

public class EnhancedDeque extends MyDeque
{
	// No instance variables -- do not add any!  However, you can access
	// the variables in MyDeque as necessary

	// Call the super constructor to initialize the EnhancedDeque
	public EnhancedDeque(int maxItems)
	{
		super(maxItems);
	}
	
	// Return the front object from the EnhancedDeque without modifying it.
	// If the EnhancedDeque is empty, return null
	public Object getFront()
	{
		return theData[0];
	}
	
	// Return the rear object from the EnhancedDeque without modifying it.
	// If the EnhancedDeque is empty, return null
	public Object getRear()
	{
		return theData[numItems-1];
	}
	
	// Rotate the EnhancedDeque left by moving the front item to the rear
	// and shifting the remaining items "up" by one position
	public void rotateLeft()
	{
		
		Object temp = theData[0];
		
		for (int i = 0; i <numItems-1; i++) {                
    		theData[i] = theData[i+1];
		}
		theData[numItems-1]=temp;
		rear = temp;
		
	}
	
	// Rotate the EnhancedDeque right by moving the rear item to the front
	// and shifting the remaining items "down" by one position	
	public void rotateRight()
	{
		Object temp = theData[numItems-1];
		for (int i = numItems-1; i >=0; i--) {                
    		theData[i+1] = theData[i];
		}
		theData[0]=temp;
		front=temp;
	}
	
	// Return a String representation of the entire contents of the EnhancedDeque
	// See the sample output for an example.
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("Contents:\n");
		for(int x=0;x<numItems;x++)
			b.append(theData[x]+" ");
			
		return(b.toString());
	}
}