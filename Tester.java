/*
Blair Hutchinson
Assignment 10
April 18th 2015
*/

import javax.swing.*;

public class Tester 
{
	public static void main(String [] args) 
{
		//frames
      JFrame frame = new MyFrame("New Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(200,400);
      frame.validate();
      frame.setVisible(true);

	}
}
