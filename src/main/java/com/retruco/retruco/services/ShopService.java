package com.retruco.retruco.services;

import com.retruco.retruco.controllers.Shop;
import com.retruco.retruco.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop createShop(Shop shop){
        return shopRepository.save(shop);
    }
}
