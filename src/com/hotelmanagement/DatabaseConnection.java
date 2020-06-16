package com.hotelmanagement;

import java.sql.*;

public class DatabaseConnection {
    Connection connection;
    Statement statement;
    private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static String dbName = "HotelManager";

   public DatabaseConnection(){

       try{
           Class.forName(jdbcDriver);
           connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=25481711");
           statement = connection.createStatement();
           statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+dbName+ ";");
           statement.executeQuery("USE "+dbName+";");
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}