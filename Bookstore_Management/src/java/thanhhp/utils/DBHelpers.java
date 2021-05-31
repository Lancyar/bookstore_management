/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PC
 */
public class DBHelpers implements Serializable{
    public static Connection makeConnection() 
        throws /*ClassNotFoundException*/NamingException, SQLException {
        
        Context context =  new InitialContext(); //get current OS
        Context tomcatContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatContext.lookup("DS007");
        Connection con = ds.getConnection();
        
        return con;
//        //1. Load Driver - added driver into project
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        
//        //2. Create connection string
//        String url = "jdbc:sqlserver://localhost:57009;databaseName=THANHHP;instanceName=SQLEXPRESS";
//        
//        //3. Open connection
//        Connection con = DriverManager.getConnection(url, "thanhhp", "123456");
//            
//        return con;
    }
}
