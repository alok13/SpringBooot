package com.example.demo.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BikeRowMapper implements RowMapper<Bike> {
    @Override
    public Bike mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Bike bike = new Bike();
        bike.setId(resultSet.getInt("id"));
        bike.setName(resultSet.getString("name"));
        bike.setYear(resultSet.getInt("year"));
        bike.setRating(resultSet.getString("rating"));
        bike.setCountry(resultSet.getString("country"));
        return bike;
    }
}
