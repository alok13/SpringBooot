package com.example.demo.dao;

import com.example.demo.entity.Bike;
import com.example.demo.entity.BikeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BikeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Bike getArticleById(int bikeId) {
        String sql = "SELECT * FROM bike WHERE id = ?";
        RowMapper<Bike> articleMapper = new BeanPropertyRowMapper<Bike>(Bike.class);
        return jdbcTemplate.queryForObject(sql, articleMapper, bikeId);
    }

    public List<Bike> getAllArticles(String orderBy, String sorting, int page) {
        Sort sort = Sort.by(orderBy);
        String sql = "SELECT *  from  bike ORDER BY " + orderBy + " " + sorting + " LIMIT " + page;
        RowMapper<Bike> rowMapper = new BikeRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void addBike(Bike bike) {
        String sql = "INSERT INTO bike (id, name, year,rating,country) values (?, ?, ?,?,?)";
        jdbcTemplate.update(sql, bike.getId(), bike.getName(), bike.getYear(), bike.getRating(), bike.getCountry());

    }

    public void updateBike(Bike bike) {

    }

    public void deleteArticle(int bikeId) {

    }
}
