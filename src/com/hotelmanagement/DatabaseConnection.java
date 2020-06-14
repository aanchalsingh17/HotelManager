package com.hotelmanagement;

import java.sql.*;

public class DatabaseConnection {
    Connection connection;
    Statement statement;
   public DatabaseConnection(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql:///HotelManager","root","25481711");
           statement = connection.createStatement();

       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
