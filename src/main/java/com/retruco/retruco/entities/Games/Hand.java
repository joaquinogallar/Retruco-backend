package com.retruco.retruco.entities.Games;

import java.util.ArrayList;
import java.util.List;

public class Hand {
     private List<Card> hand1;
     private List<Card> hand2;
     private final int HAND_CARDS=3;

     public Hand(){
         hand1 = new ArrayList<Card>();
         hand2 = new ArrayList<Card>();
     }

     public Deck dealCards(Deck deck){
         for (int i=0; i<HAND_CARDS; i++){
             Card randomCard1= deck.getCard();
             Card randomCard2= deck.getCard();

             hand1.add(randomCard1);
             deck.removeCard(randomCard1);
             hand2.add(randomCard2);
             deck.removeCard(randomCard2);
         }
         return deck;
     }
}
