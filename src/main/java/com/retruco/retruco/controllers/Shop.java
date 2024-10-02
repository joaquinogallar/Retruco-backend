package com.retruco.retruco.controllers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Long id;

    private String image;
    private String name;
    private Double price;
}
