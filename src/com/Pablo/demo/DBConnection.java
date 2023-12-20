package com.Pablo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String URL = "jdbc:mariadb://localhost:3306/DungeonRun";

    private static String USER = "root";

    private static String PASSWORD = "Admin";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
