package com.eyenet.lobbysystem.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLUtils extends SQLInit {

    public int getBalance(UUID uuid){

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
