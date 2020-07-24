package com.example.demo.service;

import com.example.demo.entity.Bike;

import java.util.List;

public interface BikeService {

    List<Bike> getAllBike(String orderBy, String sorting, int page);

    Bike getBikeById(int id);

    Bike updateBike(Bike bike);

    Bike addBike(Bike bike);

    Bike deleteBike(int bikeId);
}
