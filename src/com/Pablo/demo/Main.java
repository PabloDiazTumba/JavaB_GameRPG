package com.Pablo.demo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Check database connection
        if (testDatabaseConnection()) {
            System.out.println("Database connected successfully.");
        } else {
            System.out.println("Failed to connect to the database. Please check your database settings.");
            return; // Exit the program if the database connection fails
        }

        // Start the game
        GameLogic.startGame();
    }

    private static boolean testDatabaseConnection() {
        try {
            DBConnection.connect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}