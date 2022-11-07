package com.eyenet.lobbysystem.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInit {

    private static String host, db, user, pwd;
    private static int port;

    protected static Connection con;

    //172.17.0.2 Docker
    public static void initDB(){

        host = "localhost";
        port = 3306;
        db = "lobbysystem";
        user = "root";
        pwd = "";

        try{
            connect();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected static void connect(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?autoReconnect=true", user, pwd);
            System.out.println("MySQL Connection Successful!");
    }catch (Exception e){
            e.printStackTrace();
            System.out.println("MySQL Connection Failed!");
        }
    }

    public void disconnect(){
        try{
            if(this.hasConn()){
                this.con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean hasConn(){
        return (con != null);
    }

}
