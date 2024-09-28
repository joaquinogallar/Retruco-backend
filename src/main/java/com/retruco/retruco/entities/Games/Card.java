package com.retruco.retruco.entities.Games;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String palo;
    private int number;
    private int valor;

  public Card(String palo, int number, int valor){
      this.palo=palo;
      this.number=number;
      this.valor=valor;
  }

}



