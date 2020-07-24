package com.example.demo.service;

import com.example.demo.dao.BikeDao;
import com.example.demo.entity.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeDao bikeDao;

    @Override
    public List<Bike> getAllBike(String orderBy, String sorting, int page) {
        return bikeDao.getAllArticles(orderBy,sorting,page);
    }

    @Override
    public Bike getBikeById(int id) {
        return bikeDao.getArticleById(id);
    }

    @Override
    public Bike updateBike(Bike bike) {
        return null;
    }


    @Override
    public Bike addBike(Bike bike) {
        return null;
    }

    @Override
    public Bike deleteBike(int bikeId) {
        return null;
    }


    public Bike getBike(int id) {
        return bikeDao.getArticleById(id);
    }


}
