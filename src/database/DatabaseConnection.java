/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arafat Hossain Ar
 */
public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {

        Connection connection = null;
        String database = "jdbc:sqlite:database.db";
        if (connection == null) {
            try {

                connection = DriverManager.getConnection(database);
                System.out.println("Databse Connected");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            connection.close();
        }
        return connection;

    }

    public static void main(String[] args) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();

        int year = currentDate.getYear();
        String getdate = "Date: " + day + " " + month + " " + year + " ";
        String gettime = "Time: " + DateTimeFormatter.ofPattern("hh.mm a").format(LocalTime.now());
        System.out.println(getdate + gettime);
        try {
            getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
