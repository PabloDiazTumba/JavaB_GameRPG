package com.Pablo.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerData {

    public static Player loadPlayer(String playerName) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM players WHERE player_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, playerName);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Player player = new Player(
                                resultSet.getString("player_name"),
                                resultSet.getInt("max_hp"),
                                resultSet.getInt("hp"),
                                resultSet.getInt("xp"),
                                resultSet.getInt("num_atk_upgrades"),
                                resultSet.getInt("num_def_upgrades"),
                                resultSet.getInt("gold"),
                                resultSet.getInt("rests_left"),
                                resultSet.getInt("pots")
                        );

                        System.out.println("Player data loaded successfully: " + player);
                        return player;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to load player data from the database.");
        }
        return null;
    }

    public static void savePlayer(Player player) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "UPDATE players SET max_hp = ?, hp = ?, xp = ?, num_atk_upgrades = ?, " +
                    "num_def_upgrades = ?, gold = ?, rests_left = ?, pots = ? WHERE player_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, player.getMaxHP());
                preparedStatement.setInt(2, player.getHP());
                preparedStatement.setInt(3, player.getXP());
                preparedStatement.setInt(4, player.getNumAtkUpgrades());
                preparedStatement.setInt(5, player.getNumDefUpgrades());
                preparedStatement.setInt(6, player.getGold());
                preparedStatement.setInt(7, player.getRestsLeft());
                preparedStatement.setInt(8, player.getPots());
                preparedStatement.setString(9, player.getName());

                // Execute the update
                preparedStatement.executeUpdate();
                System.out.println("Player data saved successfully: " + player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to save player data to the database.");
        }
    }
}
