package com.eyenet.lobbysystem.sql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLUtils extends SQLInit {

    public static int getBalance(UUID uuid) {
        try {
            PreparedStatement query = con.prepareStatement("SELECT coins FROM users WHERE uuid = ?");
            query.setString(1, uuid.toString());
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                return rs.getInt("coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void addBalance(UUID uuid, int amount) {
        try {
            PreparedStatement query = con.prepareStatement("UPDATE users SET coins = coins + ? WHERE uuid = ?");
            query.setInt(1, amount);
            query.setString(2, uuid.toString());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void transferBalance(UUID senderUUID, UUID receiverUUID, int amount) {
        try {
            if (checkIfPlayerExists(receiverUUID)) {
                if (getBalance(senderUUID) >= amount) {
                    addBalance(receiverUUID, amount);
                    removeBalance(senderUUID, amount);
                } else {
                    Player sender = Bukkit.getPlayer(senderUUID);
                    sender.sendMessage("§cDu hast nicht genug Geld!");
                }
            } else {
                Player sender = Bukkit.getPlayer(senderUUID);
                sender.sendMessage("§cDer Spieler existiert nicht!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeBalance(UUID uuid, int amount) {
        try {
            PreparedStatement query = con.prepareStatement("UPDATE users SET coins = coins - ? WHERE uuid = ?");
            query.setInt(1, amount);
            query.setString(2, uuid.toString());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfPlayerExists(UUID uuid) {
        try {
            PreparedStatement query = con.prepareStatement("SELECT uuid FROM users WHERE uuid = ?");
            query.setString(1, uuid.toString());
            ResultSet rs = query.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(UUID uuid, String Name, int coins) {
        try {
            PreparedStatement insert = con.prepareStatement("INSERT INTO users (uuid, name, coins) VALUES (?, ?, ?)");
            insert.setString(1, uuid.toString());
            insert.setString(2, Name);
            insert.setInt(3, coins);
            insert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCoins(UUID uuid, int coins) {
        try {
            PreparedStatement query = con.prepareStatement("UPDATE users SET coins = ? WHERE uuid = ?");
            query.setInt(1, coins);
            query.setString(2, uuid.toString());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void reportPlayer(UUID reporterUUID, UUID susUUID, String reason) {
        try {
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            PreparedStatement insert = con.prepareStatement("INSERT INTO reports (reporterUUID, susUUID, reason, date, time) VALUES (?, ?, ?, ?, ?)");
            insert.setString(1, reporterUUID.toString());
            insert.setString(2, susUUID.toString());
            insert.setString(3, reason);
            insert.setDate(4, sqlDate);
            insert.setTimestamp(5, sqlTime);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
