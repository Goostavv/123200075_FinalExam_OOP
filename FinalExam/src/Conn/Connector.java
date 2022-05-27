/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conn;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Gustav
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/movie";
    String DBusername = "root";
    String DBpassword = "";
    
    public Connection connection;
    public Statement statement;
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Success");
        }
        catch (Exception e){    
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
