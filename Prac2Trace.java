import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Prac2Trace
{
      private JFrame theWindow;
      private JPanel onePanel;
      private JButton b1, b2;
      private JLabel [] labels;
      private Container thePane;
      private MyListener theListener;
      String [] init = {"The", "Message", "Here"};
      String [] msg0 = {"this", "is", "wacky"};
      String [] msg1 = {"kind", "of", "fun"};
      String [][] msgs;
     
      public Prac2Trace()
      {
            msgs = new String[2][3];
            for (int i = 0; i < 3; i++)
            {
                  msgs[0][i] = msg0[i];
                  msgs[1][i] = msg1[i];
            }
 
            onePanel = new JPanel();
            onePanel.setLayout(new GridLayout(1,2));
            b1 = new JButton("0");
            b2 = new JButton("1");
            theListener = new MyListener();
            b1.addActionListener(theListener);
            b2.addActionListener(theListener);
            onePanel.add(b1);
            onePanel.add(b2);
 
            theWindow = new JFrame("Practice Trace");
            thePane = theWindow.getContentPane();
            thePane.setLayout(new GridLayout(2,2));
            thePane.add(onePanel);
           
            labels = new JLabel[3];
            for (int i = 0; i < labels.length; i++)
            {
                  labels[i] = new JLabel(init[i]);
                  labels[i].setHorizontalAlignment(SwingConstants.CENTER);
                  thePane.add(labels[i]);
            }
            theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            theWindow.setSize(275, 125);
            theWindow.setVisible(true);
      }
 
      class MyListener implements ActionListener
      {
            public void actionPerformed(ActionEvent e)
            {
                  JButton b = (JButton) e.getSource();
                  int index = Integer.parseInt(b.getText());
                  for (int i = 0; i < labels.length; i++)
                  {
                        labels[i].setText(msgs[index][i]);
                  }
                  b.setText("Done");
            }
      }
 
      public static void main(String [] args)
      {
            new Prac2Trace();
      }
}