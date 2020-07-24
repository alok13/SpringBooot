package com.example.demo.controller;

import com.example.demo.entity.Bike;
import com.example.demo.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBike(@RequestParam(required = false, defaultValue = "id") String orderBy,
                                                 @RequestParam(required = false, defaultValue = "ASC") String sorting,
                                                 @RequestParam(required = false, defaultValue = "2") int page
    ) {
        List<Bike> bikeList = bikeService.getAllBike(orderBy,sorting,page);
        return new ResponseEntity<List<Bike>>(bikeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable("id") Integer id) {
        Bike bike = bikeService.getBikeById(id);
        return new ResponseEntity<Bike>(bike, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bike> addBike(@RequestBody Bike bike) {
        Bike bikeCreated = bikeService.addBike(bike);
        return new ResponseEntity<Bike>(bikeCreated, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Bike> updateBike(@RequestBody Bike bike) {
        bikeService.updateBike(bike);
        return new ResponseEntity<Bike>(bike, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable("id") Integer id) {
        bikeService.deleteBike(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
