package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTesting {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "root", "...");
            Statement stmt = con.createStatement();

            // INSERT
            stmt.executeUpdate("insert into users values (3, 'smith')");

            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
