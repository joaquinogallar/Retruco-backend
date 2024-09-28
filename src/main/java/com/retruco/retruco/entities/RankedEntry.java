package com.retruco.retruco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RankedEntry {
    @Id
    @GeneratedValue
    private Long id;

    private float price;
    private float comision;
    private String image;
}
