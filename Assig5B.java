//Antonino Febbraro
//CS 0401
//Assignment 5B
//Due December 7th, 2015

// CS 0401 Fall 2015
// Initial main program for Assignment 5.  Note that for the assignment you must
// 1) Implement the MyPoly class as specified so that this program will run as given
// 2) Add the extra functionality to this class as stated in the assignment sheet.

// See additional comments throughout this document.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Assig5B
{
	private String file = "new";
	private boolean changed;
	private int origSize;
	private int dialogResult;
    private final int NONE = 0, DRAW = 1, MODIFY = 2;  // State variables for the
    					// drawPanel.  See more details below in class ShapePanel
    private ShapePanel drawPanel;
    private JPanel buttonPanel;
    private JButton drawPoly, modifyPoints;  // Buttons to show in JFrame
    private JLabel msg;
    private JFrame theFrame;
    private ArrayList<MyPoly> shapeList; 	// ArrayList of MyPoly objects
	private MyPoly newShape;

	private JMenuBar theBar;	// for menu options
	private JMenu fileMenu, editMenu;	// two menus will be used
	private JMenuItem endProgram, saveScene, SaveAs, SavePic, New, Open;  	// 4 menu items will be used in this
	private JMenuItem delItem, setColor,PushBack;		// program
	private int selindex, startInd;		// selindex is index of current selected MyPoly
										// startInd is index where search within list of
										// shapes will start
	private String currFile;	// filename in which to save the scene
    
    public Assig5B()
    {				// Initialize the GUI
		drawPanel = new ShapePanel(800, 500);
		shapeList = new ArrayList<MyPoly>();
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));

		drawPoly = new JButton("Draw");
		modifyPoints = new JButton("Modify");
		modifyPoints.setEnabled(false);

		ButtonHandler bhandler = new ButtonHandler();
		drawPoly.addActionListener(bhandler);
		modifyPoints.addActionListener(bhandler);

		buttonPanel.add(drawPoly);
		buttonPanel.add(modifyPoints);
		drawPanel.setMode(NONE);

		msg = new JLabel("");
		msg.setForeground(Color.BLUE);
		msg.setFont(new Font("TimesRoman", Font.BOLD, 14));
		buttonPanel.add(msg);

		theFrame = new JFrame("CS 0401 Assignment 5B");
		drawPanel.setBackground(Color.white);
		theFrame.add(drawPanel, BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.SOUTH);

		// Note that way the menus are set up here.  JMenuItem objects generated
		// ActionEvents when clicked.  They are more or less just JButtons that happen
		// to be located within a menu rather than showing directly in the display.
		MenuHandler mhandler = new MenuHandler();
		theBar = new JMenuBar();
		theFrame.setJMenuBar(theBar);
		fileMenu = new JMenu("File");
		theBar.add(fileMenu);
		saveScene = new JMenuItem("Save");
		SaveAs = new JMenuItem("Save As");
		SavePic = new JMenuItem("Save as JPEG");
		endProgram = new JMenuItem("Exit");
		New = new JMenuItem("New Blank Document");
		Open = new JMenuItem("Open File");
		fileMenu.add(New);
		fileMenu.add(Open);
		fileMenu.add(SaveAs);
		fileMenu.add(SavePic);
		fileMenu.add(saveScene);
		fileMenu.add(endProgram);
		saveScene.addActionListener(mhandler);
		endProgram.addActionListener(mhandler);
		New.addActionListener(mhandler);
		Open.addActionListener(mhandler);
		SaveAs.addActionListener(mhandler);
		SavePic.addActionListener(mhandler);

		editMenu = new JMenu("Edit");
		theBar.add(editMenu);
		delItem = new JMenuItem("Delete");
		setColor = new JMenuItem("Set Color");
		PushBack = new JMenuItem("Push to Back");
		delItem.addActionListener(mhandler);
		setColor.addActionListener(mhandler);
		PushBack.addActionListener(mhandler);
		delItem.setEnabled(false);
		setColor.setEnabled(false);
		PushBack.setEnabled(false);
		editMenu.add(delItem);
		editMenu.add(setColor);
		editMenu.add(PushBack);
		currFile = null;

		theFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	// Handler for the buttons on the JFrame.  Note that both of these buttons "toggle"
	// when clicked.  Note also the implications of clicking each one -- see what is set
	// and then unset / reset upon a second click.
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == drawPoly)
			{
				if (drawPanel.currMode() != DRAW)
				{
					drawPanel.setMode(DRAW);	// Set the drawPanel so that it will
							// handle the actual drawing of the MyPoly.  This is because
							// the MouseListener to respond to the clicks is within the
							// ShapePanel class
					unSelect();
					msg.setText("Click points to draw new Polygon");
					drawPoly.setText("Finish Draw");
					modifyPoints.setEnabled(false);
					delItem.setEnabled(false);
					setColor.setEnabled(false);
					drawPanel.repaint();
				}
				else
				{
					drawPanel.setMode(NONE);	// Take drawPanel out of DRAW mode
					if (newShape != null)
					{
						newShape.setHighlight(false);  // IMPLEMENT: setHighlight()
						newShape = null;
					}
					drawPoly.setText("Draw");
					msg.setText("");
					drawPanel.repaint();
				}

			}
			else if (e.getSource() == modifyPoints)
			{
				if (drawPanel.currMode() != MODIFY)
				{
					drawPanel.setMode(MODIFY);	// Set the drawPanel so that it will
							// allow the user to edit the points within the selected
							// MyPoly object. 
					msg.setText("Click left to add point, right to remove");
					modifyPoints.setText("Quit Modify");
					drawPoly.setEnabled(false);
				}
				else
				{
					drawPanel.setMode(NONE);	// Set mode back to NONE
					msg.setText("");
					modifyPoints.setText("Modify");
					drawPoly.setEnabled(true);
				}
			}

		}
	}
	
	// Handler for the JMenuItems.  These options are all fairly straightforward.
	private class MenuHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == delItem)
			{
				deleteSelected();
				msg.setText("Polygon has been deleted");
				drawPanel.setMode(NONE);
				modifyPoints.setEnabled(false);
				drawPoly.setEnabled(true);
				drawPanel.repaint();
			}
			else if (e.getSource() == setColor)
			{
				Color newColor = JColorChooser.showDialog(theFrame,
                     "Choose Color for Polygon",
                     shapeList.get(selindex).getColor());  // IMPLEMENT: getColor()
                shapeList.get(selindex).setColor(newColor);  // IMPLEMENT: setColor()
                drawPanel.repaint();
            }	
            else if(e.getSource() == PushBack) //for the push to back button 
            {
            	System.out.println("Attempting to Push to Back"); //for debugging purposes 
            	
            	MyPoly temp = new MyPoly(shapeList.get(0).xpoints,shapeList.get(0).ypoints,shapeList.get(0).npoints,shapeList.get(0).getColor());
        
            	shapeList.set(0,shapeList.get(selindex));
            	shapeList.set(selindex,temp);
            	changed = true;
            	drawPanel.repaint();
            }
			else if (e.getSource() == saveScene)
			{
				
				if (file.equals("new")) // to check if the file is "new" 
				{
					currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
				}
				else if(!file.equals("new"))//to see if the file is not "new" 
				{
					currFile = file;
				}
				saveImages();
			}
			else if (e.getSource() == endProgram)
			{
				if((file.equals("new") && shapeList.size() > 0) || shapeList.size() > origSize || shapeList.size() < origSize)//to see if the scene was modified or not 
				{
					dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save this file?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						if(file.equals("new"))
						{
							currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
							saveImages();
						}
						else
						{
							currFile = file;
							saveImages();
						}
					}
				}
				if(!file.equals("new") && changed)
				{
					 dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save "+file+"?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						currFile = file;
						saveImages();
					}
				}
				System.exit(0);
			}
			else if(e.getSource() == Open)//opening a file 
			{
				if(shapeList.size()!=0 && (shapeList.size() > origSize || shapeList.size() < origSize))//to determined in file was modified and if needs to be saved again
					changed = true;
				//to check if user wants to save scene before opening a new one
				if(file.equals("new") && shapeList.size() > 0) //to see if scene was modified or not 
				{
					dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save this file?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
						saveImages();
					}	
				}
				
				if(!file.equals("new") && changed)
				{
					 dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save "+file+"?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						currFile = file;
						saveImages();
					}
				}
				
				//code for opening the file
				file = JOptionPane.showInputDialog(theFrame,"Enter file you want to open");
				File f = new File(file);
				
				//clearing the canvas for the file to be opened.
				for(int x = 0;x<shapeList.size();x++)
					shapeList.clear();
					
				
				if(f.exists())
				{
				try
				{
					
					BufferedReader b = new BufferedReader(new FileReader(file));
					String line;
					String numOfpoly = b.readLine();
					int polyNum = Integer.parseInt(numOfpoly);
					
					while((line = b.readLine())!=null)
					{
						
						String [] polyParts = line.split("[|]");
						String polyPts = polyParts[0];
						//System.out.println(polyPts);
						String colorPts = polyParts[1];
						
						String [] pts = polyPts.split("[:]");
						//System.out.println(pts[0]);
						int size = pts.length;
						
						int [] xpts = new int [size];
						int [] ypts = new int [size];
						for(int z = 0;z<pts.length;z++)
						{
							System.out.println(pts[z]);
							String tem = pts[z];
							String [] temp =tem.split(",");
							String tempS1 = temp[0];
							String tempS2 = temp[1];
							//System.out.println(tempS1+"   "+tempS2);
							int x = Integer.parseInt(tempS1);
							int y = Integer.parseInt(tempS2);
							
							xpts[z] = x;
							ypts[z] = y;
						}
						
						String [] colors = colorPts.split(",");
						int r = Integer.parseInt(colors[0]);
						int g = Integer.parseInt(colors[1]);
						int bs = Integer.parseInt(colors[2]);
						Color color = new Color(r,g,bs);
						
						MyPoly polygon = new MyPoly(xpts,ypts,xpts.length,color);
						shapeList.add(polygon);
						drawPanel.repaint();
						
					}
					origSize = shapeList.size();
				}
				catch(IOException er){}
				}
				else
				{
					JOptionPane.showMessageDialog(theFrame,"File not found");
				}
				changed = false;
			}
			else if(e.getSource() == New)//for making new document 
			{
				if(shapeList.size()!=0 && (shapeList.size() > origSize || shapeList.size() < origSize))//to determined in file was modified and if needs to be saved again
					changed = true;
				//checking to see if user wants to save scene before clearing it for a new one
				
				if(file.equals("new") && shapeList.size() > 0)
				{	
					dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save this file?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
						saveImages();
					}
				}
				
				if(!file.equals("new") && changed)
				{
					dialogResult = JOptionPane.showConfirmDialog (theFrame, "Do you want to save "+file+"?");
					
					if(dialogResult == JOptionPane.YES_OPTION)
					{
						currFile = file;
						saveImages();
					}
				}
				//code for making a blank canvas
				System.out.println("Getting new canvas");//for debugging
				//for(int x = 0;x<shapeList.size();x++)
				shapeList.clear();
					
				file = "new";	
				drawPanel.repaint();	
				
				changed = false;
			}
			else if(e.getSource() == SaveAs)
			{
				System.out.println("Save As");
				
				currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
				saveImages();
				/*try{
					BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "JPEG", new File(file+".JPEG"));
				} catch(AWTException err){} catch(IOException err){}*/ 
				
			}
			else if(e.getSource() == SavePic)//to save as JPEG 
			{
				currFile = JOptionPane.showInputDialog(theFrame,"Enter file name");
				savePicture(drawPanel);
			}
		}
	}

	// Method to save the contents of the shapeList into a text file.  This method depends
	// upon the fileData() method in the MyPoly class.  See specifications of the fileData()
	// method in the Assignment 5 sheet and in A5snap.htm.
	public void saveImages()
	{
		try
		{
			PrintWriter P = new PrintWriter(new File(currFile));
			P.println(shapeList.size());
			for (int i = 0; i < shapeList.size(); i++)
			{
				P.println(shapeList.get(i).fileData());	// IMPLEMENT: fileData()
			}
			P.close();
		}
		catch (Exception e)
		{ 
			JOptionPane.showMessageDialog(theFrame, "I/O Problem - File not Saved");
		}
	}
	
	public void savePicture(JPanel panel) { //For saving as  JPEG for Extra Credit 
    	BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
    	panel.print(img.getGraphics()); 
    	try {
        	ImageIO.write(img, "JPEG", new File(currFile));
   		 }
    catch (IOException e) {
       
    }
}
	
	private void addshape(MyPoly newshape)
	{
		shapeList.add(newshape);
		drawPanel.repaint();
	}
	
	// Method to select the MyPoly object located in location (x, y).  If more than one
	// MyPoly encloses that point, this method will rotate through them in succession.
	private int getSelected(int x, int y)
	{
		unSelect();
		if (shapeList.size() == 0) return -1;
		int currInd = startInd;
		do
		{
			if (shapeList.get(currInd).contains(x, y))  // OVERRIDE: contains().  The
					// contains() method in Polygon will work for any Polygon containing
					// 3 or more points.  However, it does not return true if the Polygon
					// contains only 1 or 2 points.  Your overridden version must handle
					// this issue.  This is non-trivial -- think about how you could do
					// this.  As a hint see the Point2D class.
			{
				startInd = (currInd+1) % shapeList.size();
				shapeList.get(currInd).setHighlight(true);  // highlight selected MyPoly.
					// When drawn, this will shown the individual points in the MyPoly and
					// its outline rather than the filled in shape.
				return currInd;
			}
			currInd = (currInd+1)%shapeList.size();
		} while (currInd != startInd);
		return -1;
	}

	public void deleteSelected()
	{
		if (selindex >= 0)
		{
			shapeList.remove(selindex);
			selindex = -1;
			if (startInd >= shapeList.size())
				startInd = 0;
		}
	}

	public void unSelect()
	{
		if (selindex >= 0)
		{
			shapeList.get(selindex).setHighlight(false);
			selindex = -1;
		}
	}

	public static void main(String [] args)
	{
		new Assig5B();
	}

	// Class to do the "drawing" in this program.  See more comments below.
	private class ShapePanel extends JPanel
	{
		private int prefwid, prefht;
		private int x1, y1, x2, y2;    // used by mouse event handlers when drawing and
		                               // moving the shapes

		private int mode;	// Since reaction to mouse is different if we are creating
							// or moving or modifying a shape, we must keep track.
							
		public ShapePanel (int pwid, int pht)
		{		
			selindex = -1;
			startInd = 0;
			prefwid = pwid;   // values used by getPreferredSize method below (which
			prefht = pht;     // is called implicitly)
			setOpaque(true);

			MyMouser mListen = new MyMouser();  // Create listener for MouseEvents and
			addMouseListener(mListen);			// MouseMotionEvents
			addMouseMotionListener(mListen);      
		}  // end of constructor

		public void setMode(int newMode)	// Set mode
		{
			mode = newMode;
		}

		public int currMode()		// Return current mode
		{
			return mode;
		}

		public Dimension getPreferredSize()
		{
			return new Dimension(prefwid, prefht);
		}

		public void paintComponent (Graphics g)	// Method to paint contents of panel
		{
			super.paintComponent(g);  // super call needed here
			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; i < shapeList.size(); i++)
			{
				shapeList.get(i).draw(g2d);  // IMPLEMENT: draw().  This method will utilize
						// the predefined Graphics2D methods draw() (for the outline only,
						// when the object is first being drawn or it is selected by the user) 
						// and fill() (for the filled in shape) for the "basic" Polygon
						// but will require additional code to draw the enhancements added
						// in MyPoly (ex: the circles indicating the points in the polygon
						// and the color).  Also special cases for MyPoly objects with only
						// 1 or 2 points must be handled as well. For some help with this see
						// handout MyRectangle2D
			}
		}

		// This class will handle the MouseEvents (both click and motion) for the panel.
		// It extends MouseAdapter which trivially implements both MouseListener and
		// MouseMotionListener.
		private class MyMouser extends MouseAdapter
		{
 			public void mousePressed(MouseEvent e)
			{
				x1 = e.getX();  // store where mouse is when clicked
				y1 = e.getY();

				if (mode == NONE)
				{
					selindex = getSelected(x1, y1);  // find shape mouse is
					if (selindex >= 0)               // pointing to
					{
						modifyPoints.setEnabled(true);
						delItem.setEnabled(true);
						setColor.setEnabled(true);
						PushBack.setEnabled(true);
						msg.setText("Selected outline shown. Drag to move.");
					}
					else
					{
						modifyPoints.setEnabled(false);
						delItem.setEnabled(false);
						setColor.setEnabled(false);
						PushBack.setEnabled(false);
						msg.setText("");
					}
				}
				repaint();
			}
                     
			public void mouseClicked(MouseEvent e)
			{
				if (mode == DRAW)	// Draw the points in the new MyPoly
				{
						
					if (newShape == null)	// For first point, new MyPoly must
					{						// be created.
						newShape = new MyPoly();
						newShape.setHighlight(true);
						addshape(newShape);
                    }
					newShape.addPoint(x1, y1);	// OVERRIDE: addPoint()
				}
				else if (mode == MODIFY)	// Allow user to add or remove points from
											// the current MyPoly
				{
						
					MyPoly currPoly = shapeList.get(selindex);
					if (e.getButton() == 1)
					{
						currPoly = currPoly.insertPoint(x1, y1);
							// IMPLEMENT: insertPoint()
							// Note that this method is not a mutator, but rather returns
							// a NEW MyPoly object.  The new MyPoly will contain all of the 
							// points in the selected MyPoly, but with (x1, y1) inserted 
							// between the points closest to point (x1, y1).  For help with
							// this see MyPoly.java and in particular the method
							// getClosest().
					}
					else if (e.getButton() == 3)
					{
						currPoly = currPoly.removePoint(x1, y1);
							// IMPLEMENT: removePoint()
							// Note that this method is not a mutator, but rather returns
							// a NEW MyPoly object.  If point (x1, y1) falls within one of
							// the "point" circles of the MyPoly then the new MyPoly will not
							// contain that point.  If (x1, y1) does not fall within any point
							// circle then the original MyPoly will be returned. If, after the 
							// removal of the point, no points are remaining in the MyPoly
							// the removePoint() method will return null.  See more details in 
							// MyPoly.java
					}
					if (currPoly != null)
						shapeList.set(selindex, currPoly);
					else	// No MyPoly left after deletion so remove it from list
					{
						deleteSelected();
						mode = NONE;
						drawPoly.setEnabled(true);
						delItem.setEnabled(false);
						modifyPoints.setEnabled(false);
						setColor.setEnabled(false);
						modifyPoints.setText("Modify");
						msg.setText("");
					}
				}
				repaint();
			}
			
			public void mouseDragged(MouseEvent e)
			{
				x2 = e.getX();
				y2 = e.getY();
				if (mode == NONE && selindex >= 0)
				{
					MyPoly currPoly = shapeList.get(selindex);
					int deltaX = (x2 - x1);
					int deltaY = (y2 - y1);
					
					currPoly.translate(deltaX, deltaY);	// OVERRIDE: translate()
					// The predefined translate() method will move a certain amount rather
					// than moving to a specific location.  Thus we figure out how much to
					// move based on the difference between the spot where the mouse used
					// to be and where it is now.  However, since you are adding extra
					// instance variables to your MyPoly class, you must also handle
					// these in the translate() method, which is why you must override it.
					x1 = x2;
					y1 = y2;
                }
				repaint();
			}  
			
			public void mouseMoved(MouseEvent e) //for filling in the circle 
			{
			
				//Point p = e.getLocationOnScreen();
				//System.out.println(p);
				
				double xx = e.getX();
				double yy = e.getY();
				//System.out.println(xx+"          "+yy); //for debugging purposes 
				for(int c = 0;c < shapeList.size();c++)
				{
					//System.out.println("In the loop");
					shapeList.get(c).fillCircle(xx,yy);//calls method in MyPoly class 
					drawPanel.repaint();
				}
				//System.out.println("Mousing Over");
		
			}
		} // end of MyMouser
	} // end of ShapePanel
}