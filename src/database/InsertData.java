/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Arafat Hossain Ar
 */
public class InsertData {

    /**
     * @param text
     * @param key
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//
////        InsertData insertData = new InsertData();
////        insertData.insertTask("Hello", 111);
//
//    }
    public void insertTask(String text, String key) {

        String inserttasksql = "INSERT into task( text, key) VALUES(?,?)";

        Connection conn;
        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(inserttasksql);
            ps.setString(1, text);
            ps.setString(2, key);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void insertAssignment(String text, String sub, String key, String dead) {
        String insertassignmentsql = "INSERT into assignment( text, sub, key, dead) VALUES(?, ?, ?, ?)";

        Connection conn;
        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertassignmentsql);
            ps.setString(1, text);
            ps.setString(2, sub);
            ps.setString(3, key);
            ps.setString(4, dead);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void insertNote(String text, String key) {

        String insertnotesql = "INSERT into note( text,key) VALUES(?, ?)";

        Connection conn;
        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertnotesql);
            ps.setString(1, text);
            ps.setString(2, key);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void insertDailyRoutine() {

    }

    private void insertClassRoutine() {

    }

    private void insertWorkDayRoutine() {

    }

}
