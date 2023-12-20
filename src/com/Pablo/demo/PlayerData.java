package com.Pablo.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerData {
    // No additional methods or members in the original code...

    public static Player loadPlayer(String playerName) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM players WHERE player_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, playerName);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Player(
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
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        return null;
    }
}
