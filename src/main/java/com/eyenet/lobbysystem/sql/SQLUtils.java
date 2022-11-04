package com.eyenet.lobbysystem.sql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLUtils extends SQLInit {

    public static int getBalance(UUID uuid){

        try{
            PreparedStatement query = con.prepareStatement("SELECT coins FROM users WHERE uuid = ?");
            query.setString(1, uuid.toString());
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                return rs.getInt("coins");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void addBalance(UUID uuid, int amount){
        try{
            PreparedStatement query = con.prepareStatement("UPDATE users SET coins = coins + ? WHERE uuid = ?");
            query.setInt(1, amount);
            query.setString(2, uuid.toString());
            query.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void transferBalance(UUID senderUUID, UUID receiverUUID, int amount) {
        try {

            Player sender = Bukkit.getPlayer(senderUUID);

            if (checkIfPlayerExists(receiverUUID)){

                if (getBalance(senderUUID) >= amount) {

                    removeBalance(senderUUID, amount);
                    addBalance(receiverUUID, amount);

                } else {
                    sender.sendMessage("§cDu hast nicht genug Geld!");
                }

            }else{
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

    public static boolean checkIfPlayerExists(UUID uuid){

        try{
        PreparedStatement query = con.prepareStatement("SELECT uuid FROM users WHERE uuid = ?");
        query.setString(1, uuid.toString());
        ResultSet rs = query.executeQuery();
            return rs.next();
        }catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }

    public static void createPlayer(UUID uuid, String Name, int coins){

        try {
            PreparedStatement insert = con.prepareStatement("INSERT INTO users (uuid, name, coins) VALUES (?, ?, ?)");
            insert.setString(1, uuid.toString());
            insert.setString(2, Name);
            insert.setInt(3, coins);
            insert.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



}