//Antonino Febbraro
//CS 0401
//Assignment 5 finishing up MyPoly class 

// CS 0401 Fall 2015
// Outline of the MyPoly class that you must implement for Assignment 5.
// I have provided some data and a couple of methods for you, plus some method headers
// for the methods called from Assig5.java.  You must implement all of those methods but 
// you will likely want to add some other "helper" methods as well, and also some new
// instance variables (esp. for Assig5B.java).

import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class MyPoly extends Polygon
{
	 // This ArrayList is how we will "display" the points in the MyPoly.  The idea is
	 // that a circle will be created for every (x,y) point in the MyPoly.  To give you
	 // a good start on this, I have implemented the constructors below.
	 private ArrayList<Ellipse2D.Double> thePoints;
	 private Color myColor;
	 private boolean highlighted;
	 private boolean circleFill;
	 private int index;
	 private boolean mod;
	 
	 // Constructors.  These should work with Assig5.java but you may want to modify
	 // them for Assig5B.java.
	MyPoly()
	{
		super();
		myColor = Color.BLACK;
		thePoints = new ArrayList<Ellipse2D.Double>();
	}

	// This constructor should be a lot of help to see the overall structure of the
	// MyPoly class and how both the inherited Polygon functionality as well as the
	// additional functionality are incorporated.  Note that the first thing done is
	// a call to super to set up the points in the "regular" Polygon.  Then the color
	// is set and the point circles are created to correspond with each point in the
	// Polygon.
	MyPoly(int [] xpts, int [] ypts, int npts, Color col)
	{
		super(xpts, ypts, npts);
		myColor = col;
		thePoints = new ArrayList<Ellipse2D.Double>();
		for (int i = 0; i < npts; i++)
		{
			int x = xpts[i];
			int y = ypts[i];
			addCircle(x, y);
		}
	}
	
	// The setFrameFromCenter() method in Ellipse2D.Double allows the circles to be
	// centered on the points in the MyPoly
	public void addCircle(int x, int y)
	{
		Ellipse2D.Double temp = new Ellipse2D.Double(x, y, 8, 8);
		temp.setFrameFromCenter(x, y, x+4, y+4);
		thePoints.add(temp);
	}
     
	public void translate(int x, int y)
	{
		// You must override this method
		super.translate(x,y);
		
		for(int z = 0;z < thePoints.size();z++)
		{
			thePoints.get(z).x = thePoints.get(z).x+ x;
			thePoints.get(z).y = thePoints.get(z).y+ y;
		}
		
		
	}
    
    // This method is so simple I just figured I would give it to you. 	   
	public void setHighlight(boolean b)
	{
		highlighted = b;	
	}
     
	public void addPoint(int x, int y)
	{
		// You must override this method to add a new point to the end of the
		// MyPoly.  The Polygon version works fine for the "regular" part of the
		// MyPoly but you must add the functionality to add the circle for the
		// point.
		super.addPoint(x,y);
		addCircle(x,y);
	}
     
	public MyPoly insertPoint(int x, int y) //ASK ABOUT THIS METHOD 
	{
		// Implement this method to return a new MyPoly containing new point (x,y)
		// inserted between the two points in the MyPoly that it is "closest" to.  See
		// the getClosest() method below for help with this.
		int close = getClosest(x,y);
		int size = thePoints.size();
		size = size+1;
		
		//Getting the points from thePoints array
		int [] xpts = new int [size];
		int [] ypts = new int [size];
		
		
		
		int z = 0;
		while(z<thePoints.size())
		{
			if(z == close)
			{
				Ellipse2D.Double temp = new Ellipse2D.Double(x, y, 8, 8);
				temp.setFrameFromCenter(x, y, x+4, y+4);
				thePoints.add(close+1,temp);
			}
		
			z++;
		}
		
		for(int c = 0;c<size;c++)
		{
			xpts[c]=(int)thePoints.get(c).getX();
			ypts[c]=(int)thePoints.get(c).getY();
		}
		
		MyPoly tempPoly = new MyPoly(xpts,ypts,xpts.length,myColor);
		
		tempPoly.setHighlight(true);
		return tempPoly;
	}
	
	// This method will return the index of the first point of the line segment that is
	// closest to the argument (x, y) point.  It uses some methods in the Line2D.Double
	// class and will be very useful when adding a point to the MyPoly.  Read through it
	// and see if you can figure out exactly what it is doing.
	public int getClosest(int x, int y)
	{
		if (npoints == 1)
			return 0;
		else
		{
			Line2D currSeg = new Line2D.Double(xpoints[0], ypoints[0], xpoints[1], ypoints[1]);
			double currDist = currSeg.ptSegDist(x, y);
			double minDist = currDist;
			int minInd = 0;
			for (int ind = 1; ind < npoints; ind++)
			{
				currSeg = new Line2D.Double(xpoints[ind], ypoints[ind],
								xpoints[(ind+1)%npoints], ypoints[(ind+1)%npoints]);
				currDist = currSeg.ptSegDist(x, y);
				if (currDist < minDist)
				{
					minDist = currDist;
					minInd = ind;
				}
			}
			
			return minInd;
		}
	}

	public MyPoly removePoint(int x, int y) //ASK ABOUT THIS METHOD 
	{
		// Implement this method to return a new MyPoly that is the same as the
		// original but without the "point" containing (x, y).  Note that in this
		// case (x, y) is not an actual point in the MyPoly but rather a location
		// on the screen that was clicked on my the user.  If this point falls within
		// any of the point circles in the MyPoly then the point in the MyPoly that
		// the circle represents should be removed.  If the resulting MyPoly has no
		// points (i.e. the last point has been removed) then this method should return
		// null.  If (x,y) is not within any point circles in the MyPoly then the
		// original, unchanged MyPoly should be returned.
		
		int size = thePoints.size();
		
		//System.out.println(x+"    "+y);//for debugging purposes 
	
		MyPoly tempPoly = null;
		
		//Getting the points from thePoints array
		int [] xpts = new int [size-1];
		int [] ypts = new int [size-1];
		
		if(size==0)
			tempPoly = null;
		
			for(int z = 0;z < thePoints.size();z++)//checking to see if the point is in array
			{
				
				if(thePoints.get(z).contains(x,y))
				{
					thePoints.remove(z);
					
					for(int t = 0;t < xpts.length;t++)
					{
						xpts[t] = (int)thePoints.get(t).getX();
						ypts[t] = (int)thePoints.get(t).getY();
					}
					tempPoly = new MyPoly(xpts,ypts,size-1,myColor);
					break;
				}
				else
				{
				
					tempPoly = this;
				}
		
			}
		
		tempPoly.setHighlight(true);
		return tempPoly;
			
	}

	public boolean contains(int x, int y)
	{
		// Override this method. The Polygon contains() method works fine as long as
		// the Polygon has 3 or more points.  You will override the method so that if
		// a MyPoly has only 2 points or 1 point it will still work.  Think about how
		// you can do this.
		int z = 0;
		boolean b = false;
		
		if(thePoints.size() >= 3)
			b = super.contains(x,y);
			
		if(thePoints.size() == 1)
		{
			b= thePoints.get(0).contains(x,y);
		}	
		
		if(thePoints.size() == 2)
		{
			double l = Line2D.ptSegDist(super.xpoints[0],super.ypoints[0],super.xpoints[1],super.ypoints[1],x,y);
			b = (Math.round(l) == 0);
		}
		
		return b;
	}
	
	
	public void draw(Graphics2D g)
	{
		// Implement this method to draw the MyPoly onto the Graphics2D argument g.
		// See MyRectangle2D.java for a simple example of doing this.  In the case of
		// this MyPoly class the method is more complex, since you must handle the
		// special cases of 1 point (draw only the point circle), 2 points (drow the
		// line) and the case where the MyPoly is selected.  You must also use the
		// color of the MyPoly in this method.
			
			g.setColor(myColor);
			g.draw(this);
			
			if(highlighted)
			{
				for(int c=0;c<thePoints.size();c++)
				{
					g.draw(thePoints.get(c));
				}
				
			}
			else if(!highlighted) 
			{
				g.fill(this);
			}
			if(circleFill && highlighted)
			{
				g.fill(thePoints.get(index));
			}
			
			
			
		
			
	}
	
	
	  
	public String fileData()
	{
		// Implement this method to return a String representation of this MyPoly
		// so that it can be saved into a text file.  This should produce a single
		// line that is formatted in the following way:
		// x1:y1,x2:y2,x3:y3, ... , |r,g,b
		// Where the points and the r,g,b values are separated by a vertical bar.
		// For two examples, see A5snap.htm and A5Bsnap.htm.
		// Look at the Color class to see how to get the r,g,b values.
		
		//make string that returns the demensions of the rectangle!
		StringBuilder b = new StringBuilder();
		int x = 0;
		while(x<thePoints.size())
		{
			b.append((int)thePoints.get(x).getX()+","+(int)thePoints.get(x).getY());
			x++;
			if(x != thePoints.size())
				b.append(":");
		}
		 b.append("|");
		 b.append(myColor.getRed()+","+myColor.getGreen()+","+myColor.getBlue());
		 
		return b.toString();
	}

	// These methods are also so simple that I have implemented them.
	public void setColor(Color newColor)
	{
		myColor = newColor;
	}	
	
	public Color getColor()
	{
		return myColor;
	}	
	
	//method for clearing canvas
	public void clearCanvas()
	{
		thePoints.clear();
	}	
	
	public void fillCircle(double xx, double yy)
	{
		for(int x = 0; x<thePoints.size();x++)
		{
			//System.out.println(thePoints.get(x).getX()); //for debugging
			if(thePoints.get(x).contains(xx,yy))
			{
				System.out.println("Filling in the circle!!!");//for debugging purposes 
				index = x;
				circleFill = true;
				break;
			}
			else if(!thePoints.get(x).contains(xx,yy))
			{
				circleFill = false;
			}
			
		}
		//circleFill = false;
	}
	
	public void setModify(boolean b)
	{
		mod = b;
    }
}