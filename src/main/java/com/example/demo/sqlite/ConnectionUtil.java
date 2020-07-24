package com.example.demo.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

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

}
