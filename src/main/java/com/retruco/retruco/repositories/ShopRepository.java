package com.retruco.retruco.repositories;

import com.retruco.retruco.controllers.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}