package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Create the database table:
//        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS beers(name VARCHAR(100))");
//
//        //Insert a record:
//        jdbcTemplate.execute("INSERT INTO beers VALUES ('Stella')");

//        //Read records:
//        List<Movie> beers = jdbcTemplate.query("SELECT * FROM movies",
//                (resultSet, rowNum) -> new Movie(resultSet.getString("title")));
//
//        //Print read records:
//        beers.forEach(System.out::println);
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users//alok//Downloads//demo//demosqlitesample.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectAll() {
        String sql = "SHOW tables";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
