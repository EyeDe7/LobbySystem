package com.eyenet.lobbysystem.sql;


import java.sql.Statement;

public class CreateTables extends SQLInit {

    private static Statement statement;

    private static final String usertable = "CREATE TABLE if not exists users(" +
            "id INT NOT NULL AUTO_INCREMENT," +
            "uuid VARCHAR(36) NOT NULL," +
            "name VARCHAR(16) NOT NULL," +
            "coins INT NOT NULL," +
            "PRIMARY KEY (id)" +
            ");";

    public static void createTables() {
        try {
            statement = con.createStatement();
            statement.executeUpdate(usertable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
