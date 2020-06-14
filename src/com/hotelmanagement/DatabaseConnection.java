package com.hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    Connection connection;
    Statement statement;
   public DatabaseConnection(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql:///HotelManager","root","aanchal@1711");
           statement = connection.createStatement();


       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
