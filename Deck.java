/*
Blair Hutchinson
Assignment 10
April 18th 2015
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck
{
    static ArrayList<Card> deck = new ArrayList<Card>();
   
   public Deck(Card card)
   {
      deck.add(card);
   }
   
   /**getDeck returns the deck of cards
   @return deck - the deck of cards
   */
   public static ArrayList<Card> getDeck()
   {
      return deck;
   }
   
   /**shuffles the cards
   @return deck - returns shuffled deck
   */
   public ArrayList<Card> shuffle()
   {
       Collections.shuffle(deck);
       
       return deck;
   } 
   
   /**toString converts the deck into a string
   @return deck - returns deck as a string
   */   
   public String toString()
    {
        return deck.toString();
    }
 
   
}
   
   