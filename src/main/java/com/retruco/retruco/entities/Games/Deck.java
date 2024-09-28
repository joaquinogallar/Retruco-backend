package com.retruco.retruco.entities.Games;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
public class Deck {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
    }

    public void addCards() {
        this.cards.add(new Card("basto", 1, 2));
        this.cards.add(new Card("basto", 2, 6));
        this.cards.add(new Card("basto", 3, 5));
        this.cards.add(new Card("basto", 4, 14));
        this.cards.add(new Card("basto", 5, 13));
        this.cards.add(new Card("basto", 6, 12));
        this.cards.add(new Card("basto", 7, 11));
        this.cards.add(new Card("basto", 10, 10));
        this.cards.add(new Card("basto", 11, 9));
        this.cards.add(new Card("basto", 12, 8));

        this.cards.add(new Card("espada", 1, 1));
        this.cards.add(new Card("espada", 2, 6));
        this.cards.add(new Card("espada", 3, 5));
        this.cards.add(new Card("espada", 4, 14));
        this.cards.add(new Card("espada", 5, 13));
        this.cards.add(new Card("espada", 6, 12));
        this.cards.add(new Card("espada", 7, 3));
        this.cards.add(new Card("espada", 10, 10));
        this.cards.add(new Card("espada", 11, 9));
        this.cards.add(new Card("espada", 12, 8));

        this.cards.add(new Card("oro", 1, 7));
        this.cards.add(new Card("oro", 2, 6));
        this.cards.add(new Card("oro", 3,5));
        this.cards.add(new Card("oro", 4, 14));
        this.cards.add(new Card("oro", 5, 13));
        this.cards.add(new Card("oro", 6, 12));
        this.cards.add(new Card("oro", 7, 4));
        this.cards.add(new Card("oro", 10, 10));
        this.cards.add(new Card("oro", 11, 9));
        this.cards.add(new Card("oro", 12, 8));

        this.cards.add(new Card("copa", 1, 7));
        this.cards.add(new Card("copa", 2, 6));
        this.cards.add(new Card("copa", 3, 5));
        this.cards.add(new Card("copa", 4, 14));
        this.cards.add(new Card("copa", 5, 13));
        this.cards.add(new Card("copa", 6, 12));
        this.cards.add(new Card("copa", 7, 11));
        this.cards.add(new Card("copa", 10, 10));
        this.cards.add(new Card("copa", 11, 9));
        this.cards.add(new Card("copa", 12, 8));
    }

    public Card getCard() {
        Random r = new Random();
        if (!cards.isEmpty()) {
            int randomCard = r.nextInt(cards.size());
            return cards.get(randomCard);
        } else {
            return null;
        }
    }

    public void removeCard(Card card){
      cards.remove(card);
    }
}
