/*
Blair Hutchinson
Assignment 10
April 18th 2015
*/

/* This class is used to simply simulate a Card. The card has 
  a suit which in this class is a character. */



import javax.swing.*;
import java.awt.*;


public class Card extends JButton
{
   //A card has a suit and rank
   private char suit;
   private int rank;
  
   /** 
   The Card constructor sets suit of the card
   and rank of the card.
   @param suit - the suit of the card
   @param rank - the rank of the card
   */
   public Card (char suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   /**Set the suit of the Card
   @param suit - sets suit of the card
   */
   public void setSuit(char suit)
   {
      this.suit = suit;
   }
   
   /**Set the rank of the Card
   @param rank - sets rank of the card
   */
   public void setRank(int Rank)
   {
      this.rank = rank;
   }
   
   /**
   Method returns suit of the card
   @return suit of the card
   */
   public char getSuit()
   {
      return suit;
   }
   
   /**
   Method returns rank of the card
   @return rank of the card
   */
   public int getRank()
   {
      return rank;
   }
   
   
   /** toString method to return a string value of the card
   @return s1 the string of the card
   */
   
   public String toString()
   {
      String str=null;
      
      if(rank == 11)
      str = "Jack";
      
      if(rank == 12)
      str = "Queen";
      
      if(rank == 13)
      str = "King";
      
      if(rank == 14)
        str = "Ace";
      
      if(rank > 10)
      {
         String s = str+suit;
         return s;
      }
      
     String s1 = String.valueOf(rank)+suit;
     return s1;
     
   }
   
   /**
    The compareTo method is used to compare two card 
    @param other - The card being tested. 
   */
   public int compareTo(Card other)
   {
      if(this.rank > other.getRank())
         return 1;
      
      if(this.rank < other.getRank())
         return -1;
         
         else
         {
            return 0;
         }
    }
}