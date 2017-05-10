/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author UITCV
 */
public class DBConnectionService {
    public static String dbURL;
    public static String dbUserName;
    public static String dbPassword;
    protected static void loadJDBCDDriver() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException e) {
            throw new Exception("SQL JDBC Driver not found ... ");
        }
    }
    public static Connection getConnection()throws Exception{
        Connection connect = null;
        dbUserName = "sa";
        dbPassword = "sa";
        dbURL = "jdbc:sqlserver://localhost;databaseName=Java;user=sa;password=sa";
        if(connect == null){
            loadJDBCDDriver();
            try{
                connect = DriverManager.getConnection(dbURL);
            }catch(SQLException e){
                throw new Exception("Can not accsess to Database Server ... "+dbURL+e.getMessage());
            }
        }
        return connect;
    }
}
