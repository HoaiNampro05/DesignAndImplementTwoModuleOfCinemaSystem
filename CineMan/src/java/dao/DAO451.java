/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DAO451 {
    protected Connection connection;
    public DAO451()
    {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:mysql://127.0.0.1:3306/cineman1";
            String username = "root";
            String password = "12345";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) throws SQLException {
        DAO451 a = new DAO451();
        Connection c = a.connection;
        String sql1="select * from heartdisease";
        PreparedStatement st=c.prepareStatement(sql1);
        ResultSet rs=st.executeQuery();
        String e="";
        while(rs.next()){
           e= rs.getString("age");
           System.out.println(e);
           break;
        }
       
    }
}
