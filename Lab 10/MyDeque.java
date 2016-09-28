// CS 401 Fall 2015
// Solution to Lab 9.  Your solution does not have to be exactly like this,
// but it should be similar and should be functionally identical.

// Note that the data has no access modifiers which gives it package access. 
// This enables any class within the same package (or directly) to directly
// access the data.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;
	Object front = new Object();
	Object rear = new Object();
	
	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	// Simple method to return whether or not Deque is empty
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	// Note how to add we shift starting at the end -- this prevents data
	// from being overwritten incorrectly.  Also note the test for room
	// before doing any work.  Testing for special cases is critical to
	// getting this to work correctly, and is done with all of the methods.
	public void addFront(Object X)
	{
		if (numItems < theData.length)
		{
			for (int i = numItems; i > 0; i--)
				theData[i] = theData[i-1];
			theData[0] = X;
			numItems++;
		}
	}

	// addRear() and removeRear() are both very simple, but we must still
	// test for special cases.
	public void addRear(Object X)
	{
		if (numItems < theData.length)
		{
			theData[numItems] = X;
			numItems++;
		}
	}

	// Now we shift starting at the beginning, because we need to "fill in"
	// the hole left by the removed object.
	public Object removeFront()
	{
		Object temp = null;
		if (numItems > 0)
		{
			temp = theData[0];
			for (int i = 0; i < numItems-1; i++)
				theData[i] = theData[i+1];
			theData[numItems-1] = null;
			numItems--;
		}
		return temp;
	}

	// Be careful with index values -- remember that the last item will
	// be theData[numItems-1] since the indexes start at 0
	public Object removeRear()
	{
		Object temp = null;
		if (numItems > 0)
		{
			temp = theData[numItems-1];
			theData[numItems-1] = null;
			numItems--;
		}
		return temp;
	}
}