package com.retruco.retruco.controllers;

import com.retruco.retruco.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Shop")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops(){
            List<Shop> shops = shopService.getAllShops();
            return ResponseEntity.ok(shops);
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
    }
}
