/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kovtun.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roman K
 */
public class StudentDB {

    // reads data from database, returns data in an arraylist of student objects
    public ArrayList<Student> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Student> stuArray = new ArrayList<Student>();

        PreparedStatement psmt = null;
        ResultSet rs = null;

        // OLD DRIVER is Depracated Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("com.mysql.cj.jdbc.Driver");  // new driver
        System.out.println("MySql driver was found.");

        Connection conn = null;
        String login = "4017";
        String password = "76HKcUIAfG";
        String databaseName = "CIS355A_Kovtun";
        conn = DriverManager.getConnection("jdbc:mysql://devry.edupe.net:4300/" + databaseName,
                login,
                password);
        System.out.println("MySQL connection to the database was established");

        // connection
        psmt = conn.prepareStatement("SELECT * FROM Students");
        rs = psmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            float test1 = rs.getFloat(2);
            float test2 = rs.getFloat(3);
            float test3 = rs.getFloat(4);

            Student stu = new Student(name, test1, test2, test3);

            stuArray.add(stu);
        }

        //close
        conn.close();

        // get teh student From the database
        return stuArray;
    }

    // add—writes a record to the database
    public void add(Student stu) throws ClassNotFoundException, SQLException {
        PreparedStatement psmt = null;
        ResultSet rs = null;

        // OLD DRIVER is Depracated Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("com.mysql.cj.jdbc.Driver");  // new driver

        Connection conn = null;
        String login = "4017";
        String password = "76HKcUIAfG";
        String databaseName = "CIS355A_Kovtun";
        conn = DriverManager.getConnection("jdbc:mysql://devry.edupe.net:4300/" + databaseName,
                login,
                password);
        System.out.println("MySQL connection to the database was established");

        String strSQL = "INSERT INTO Students VALUES(?,?,?,?);";
        psmt = conn.prepareStatement(strSQL);
        psmt.setString(1, stu.getName());
        psmt.setFloat(2, stu.getTest1());
        psmt.setFloat(3, stu.getTest2());
        psmt.setFloat(4, stu.getTest3());

        // exectute the prepared statement
        psmt.execute();
        System.out.println("Success! Student was added!");

        //close
        conn.close();
    }
}
