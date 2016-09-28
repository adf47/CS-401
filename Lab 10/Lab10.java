// CS 0401 Fall 2015
// Driver Program for Lab10.   This program should run with the supplied
// SimpleDeque interface and the EnhancedDeque class that you complete.  Note that
// the first part of this program is identical to Lab9.java and your subclass of
// MyDeque should work with the code as is.  This is due to the "is a" relationship
// of a subclass to its superclass.  The new functionality / methods are then
// tested in the new method testNewStuff.

public class Lab10
{
	public static void main(String [] args)
	{
		SimpleDeque things = new EnhancedDeque(10);  // New class for object

		doStack(things);
		
		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 1!");
			things = new MyDeque(8);
		}
			
		doQueue1(things);
		
		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 2!");
			things = new MyDeque(8);
		}
		
		doQueue2(things);

		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 3!");
		}

		// To access new stuff we need the reference to be EnhancedDeque.  Thus, we
		// cast the reference from SimpleDeque to EnhancedDeque
		EnhancedDeque stuff = (EnhancedDeque) things; 
		testNewStuff(stuff);
	}

	public static void testNewStuff(EnhancedDeque D)
	{
		String [] data = {"Humperdinck", "Roberts", "Vizzini", "Fezzik", "Buttercup"};
		System.out.println("Adding to EnhancedDeque");
		for (int i = 0; i < data.length; i++)
			D.addRear(data[i]);
		System.out.println(D.toString());
		System.out.println();
		System.out.println("Front: " + D.getFront());
		System.out.println("Rear: " + D.getRear());
		System.out.println();
		D.rotateLeft();
		System.out.println(D.toString());
		D.rotateLeft();
		System.out.println(D.toString());
		D.rotateRight();
		System.out.println(D.toString());
		D.rotateRight();
		System.out.println(D.toString());
		System.out.println();
		while (true)
		{
			Object front = D.getFront();
			if (front == null)
				break;
			else
			{
				System.out.println("Front: " + front);
				D.removeFront();
			}
		}
	}
	
	public static void doQueue1(SimpleDeque S)
	{
		System.out.println("Queue adds at rear and removes at front");
		for (int i = 0; i < 5; i++)
			S.addRear(new Integer(i));
		Object item = S.removeFront();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeFront();
		}
		System.out.println();
		System.out.println();
	}

	public static void doQueue2(SimpleDeque S)
	{
		System.out.println("Queue adds at front and removes at rear");
		for (int i = 0; i < 10; i++)
			S.addFront(new Double(2*i));
		Object item = S.removeRear();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeRear();
		}
		System.out.println();
		System.out.println();
	}

	public static void doStack(SimpleDeque S)
	{
		System.out.println("Stack adds and removes at rear");
		String [] names = {"Herb", "Bertha", "Ingrid", "Ingmar", "Marge"};
		for (int i = 0; i < names.length; i++)
			S.addRear(names[i]);
		Object item = S.removeRear();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeRear();
		}
		System.out.println();
		System.out.println();
	}
}
