// CS 401 Fall 2015
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;
	int max;

	public MyDeque(int maxItems)
	{
		max=maxItems;
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
		if(theData.length == max){
			System.out.println("Array is full");
		}
		else
			theData[0]=X;
	}

	public void addRear(Object X)
	{
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
		if(theData.length == max){
			System.out.println("Array is full");
		}
		else
			theData[max] = X;
	}

	public Object removeFront()
	{
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
		return theData[0];
		
	}

	public Object removeRear()
	{
		// Remove and return rear item from list.  If list is empty,
		// return null.
		 return theData[max];
	}
}