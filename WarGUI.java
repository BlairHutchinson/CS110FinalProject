/*
Blair Hutchinson
Assignment 10
April 18th 2015
*/

/* This program plays the card game war*/

//imports
import java.util.*;
import java.util.Collections;     
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//Extend JFrame for its method convenience
public class WarGUI extends JFrame 
{

  //4 panels used for the War card game
  private JPanel panel1 = new JPanel();
  private JPanel panel2 = new JPanel();
  private JPanel panel3 = new JPanel();
  private JPanel panel4 = new JPanel();
  //back of a card
  private ImageIcon back = new ImageIcon("back.jpg");
  //far left face-up card
  private ImageIcon cardLeft = new ImageIcon();
  //far right face-up card
  private ImageIcon cardRight = new ImageIcon();
  //face down card in a War
  private ImageIcon cardLeftWar = new ImageIcon();
  private ImageIcon cardRightWar = new ImageIcon();
  //face up card in a War
  private ImageIcon cardRightWarTop = new ImageIcon();
  private ImageIcon cardLeftWarTop = new ImageIcon();
  
  //Hold the images
  private JLabel player1Card = new JLabel();
  private JLabel player2Card = new JLabel();
  private JLabel player1CardWar = new JLabel();
  private JLabel player2CardWar = new JLabel();          
  private JLabel player1CardWarTop = new JLabel();
  private JLabel player2CardWarTop = new JLabel();
  private JLabel deck1 = new JLabel(back);
  private JLabel deck2 = new JLabel(back);
  
  //Label to display the size of Players's deck
  private JLabel deck1size;
  private JLabel deck2size; 
  private JLabel winner = new JLabel(); 
   
  //Button to keep playing
  private JButton play = new JButton();
  
  //Array lists for the full deck and individual players
  private ArrayList<Card> deck = new ArrayList<Card>();
  private ArrayList<Card> player1 = new ArrayList<Card>();
  private ArrayList<Card> player2 = new ArrayList<Card>();
  
  private int compare; 

  //Size of the dispay window
  private final int WINDOW_WIDTH = 1500; 
  private final int WINDOW_HEIGHT = 400;

     public WarGUI()
     {
         setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
         //Make a deck
          for(int i = 2; i<=14; i++)
              {
                  Card hearts = new Card('h',i);
                  deck.add(hearts);
                  Card clubs = new Card('c',i);
                  deck.add(clubs);
                  Card diamonds = new Card('d',i);
                  deck.add(diamonds);
                  Card spades = new Card('s',i);
                  deck.add(spades);
              }
                  
               //Shuffle the deck
               Collections.shuffle(deck);   
               
               //Split the deck for the players
               for(int i = 0; i<deck.size();i++)//deck.size()
               {
                  if(i<26)
                    player1.add(deck.get(i));
                  
                  else
                    player2.add(deck.get(i));
          
               }
         
         //Display size of the decks      
         deck1size = new JLabel("Player 1: "+player1.size());
         deck2size = new JLabel("Player 2: "+player2.size());
         
         //create lay button and give it a listener
         play = new JButton("Play");
         play.addActionListener(new PlayerListener());
        
         //Set each panel to the background color of dark green
         panel1.setBackground(new Color(0, 122, 0));
         panel2.setBackground(new Color(0, 122, 0));
         panel3.setBackground(new Color(0, 122, 0));
         panel4.setBackground(new Color(0, 122, 0));
         
         //Add Player 1's deck size label to panel 1
         panel1.add(deck1size); 
         //Add the play button to panel 1
         panel1.add(play);
         //Add Player 2's deck size label to panel 1
         panel1.add(deck2size);
         
         //Set the font for Player 1's and Player 2's deck size
         deck1size.setFont(new Font("HELVETICA",Font.BOLD,20));
         deck2size.setFont(new Font("HELVETICA",Font.BOLD,20));
         
         //Set the font for the "play" button
         play.setFont(new Font("HELVETICA",Font.BOLD,20));
         
         winner.setFont(new Font("HELVETICA",Font.BOLD,60));
         
         //Position cards in on the screen
         panel2.add(deck1);
         panel2.add(player1Card); 
         panel2.add(player1CardWar);
         panel2.add(player1CardWarTop);
         panel3.add(player2CardWarTop);
         panel3.add(player2CardWar);
         panel3.add(player2Card);
         panel3.add(deck2);
         panel4.add(winner); 
         
          //set the layout to BorderLayout
          setLayout(new BorderLayout());
          add(panel1,BorderLayout.NORTH); 
          add(panel2,BorderLayout.WEST); 
          add(panel3,BorderLayout.EAST);
          add(panel4,BorderLayout.CENTER);
          
          //Make BorderLayout visible
          setVisible(true); 
     }
     
     /*PlayerListener class simulates the action of the Player's flipping
     over their top card in the deck*/
           
     private class PlayerListener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
            //when the play button is pushed string = Play
            String actionCommand = e.getActionCommand();
            
               //Need try due to end of game ArrayList out of bounds exception thrown
               try
               {
                   if(actionCommand.equals("Play"))
                     {
                        //winner labe is inittially null
                        winner.setText(null); 
                       
                        //each "war" card initially null
                        player1CardWar.setIcon(null);
                        player2CardWar.setIcon(null);
                        player1CardWarTop.setIcon(null);
                        player2CardWarTop.setIcon(null);
                        
                        //Set both deck size labels to there appropriate values
                        deck1size.setText("Player 1: "+player1.size());
                        deck2size.setText("Player 2: "+player2.size());
                        
                        //Set ImageIcons with the top deck card image
                        cardLeft = new ImageIcon(player1.get(player1.size()-1)+".jpg");
                        cardRight = new ImageIcon(player2.get(player2.size()-1)+".jpg");
   
                        //set two image icons to their respective labels
                        player1Card.setIcon(cardLeft);
                        player2Card.setIcon(cardRight);
                        
                        //Compare the top cards for each players deck
                        compare = player1.get(player1.size()-1).compareTo(player2.get(player2.size()-1));
                        
                           //player 1's card wins
                           if(compare == 1)
                           {
                              //Add player 2's card to player 1's deck
                              player1.add(player2.remove(player2.size()-1));
                              Collections.shuffle(player1);
            
                           }
                           //player 2's card wins
                           if(compare == -1)
                           {
                               //Add player 1's card to player 2's deck
                               player2.add(player1.remove(player1.size()-1));
                               Collections.shuffle(player2);
            
                           }
                              //War loop
                              while(compare == 0)
                              {
                                 Collections.shuffle(player1);
                                 Collections.shuffle(player2);
                                 
                                 //Display a face down card image 
                                 player1CardWar.setIcon(back);
                                 player2CardWar.setIcon(back);
                                 
                                 //Set the ImageIcons with their appropriate card images when a war occurs
                                 cardLeftWarTop = new ImageIcon(player1.get(player1.size()-3)+".jpg");
                                 cardRightWarTop = new ImageIcon(player2.get(player2.size()-3)+".jpg");
                                 
                                //Set the labels with their respective card
                                 player1CardWarTop.setIcon(cardLeftWarTop);
                                 player2CardWarTop.setIcon(cardRightWarTop);
                                 
                                 //use the compareTo method in Card class
                                 compare = player1.get(player1.size()-3).compareTo(player2.get(player2.size()-3));
                                 
                                 //player 1 wins the war
                                 if(compare == 1)
                                 {
                                    
                                     winner.setText("Player 1 wins the war!");
                                     
                                     //Add the 3 cards to player 1's deck
                                     for (int i = 1; i<=3; i++)
                                       player1.add(player2.remove(player2.size()-i));
                                        
                                     Collections.shuffle(player1);
                                  }
                                  
                                  //player 2 wins
                                  if(compare == -1)
                                  {
                                      winner.setText("Player 2 wins the war!");
                                      
                                      //Add the 3 cards to player 2's deck
                                      for (int i = 1; i<=3; i++)
                                      player2.add(player1.remove(player1.size()-i));
                                       
                                      Collections.shuffle(player2);
                                  }   
                               }                     
                        } 
                   }  
                    
            catch (IndexOutOfBoundsException theException)
            {
               //player 2 wins
               if(player1.size() == 0)
               {
                  //Display player 2 wins
                  winner.setText("Winner is Player 2" );
                  panel1.remove(play); 
   
               }
               //player 1 wins
               if(player2.size() == 0)               
               {
                  winner.setText("Winner is Player 1" );
                  //Remove the play button
                  panel1.remove(play);
               }
            }   
         }
      }
      
      //The driver
      public static void main(String[] args)
      {
         //Make an instance of the war GUI
         WarGUI war = new WarGUI();
         
         //Set the title
         war.setTitle("War Card Game");
         
         //Set the background to dark green
         war.getContentPane().setBackground(new Color(0, 122, 0));
         
         //Exit on close
         war.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

  
}