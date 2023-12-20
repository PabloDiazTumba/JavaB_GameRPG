package com.Pablo.demo;

import java.sql.Connection;
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

        // Load player data from the database
        Player player = PlayerData.loadPlayer("Stefan"); // Replace "Stefan" with the actual player name

        if (player == null) {
            // If the player doesn't exist in the database, create a new player
            player = new Player("Stefan");
        }

        // Set the loaded or created player in GameLogic
        GameLogic.setPlayer(player);

        // Start the game
        GameLogic.startGame();
    }

    private static boolean testDatabaseConnection() {
        try {
            Connection connection = DBConnection.connect();
            if (connection != null && !connection.isClosed()) {
                connection.close(); // Close the connection if it's successful
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}