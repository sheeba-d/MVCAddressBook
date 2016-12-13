/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DbConnect {
    private  String driver = "oracle.jdbc.driver.OracleDriver";
    private String userName = "sheeba";
    private String password = "java";
    private String url = "jdbc:oracle:thin:@172.16.7.208:1521:orcl";
    
   /*
    * private  String driver = "com.mysql.jdbc.Driver";
    * private String userName = "root";
    * private String password = "";
    * private String dBase = "addressbook";
    * private String url = "jdbc:mysql://localhost/"+dBase+"?user="+userName+"&password="+password;
    */
    Connection con=null ;
    public Connection getConnect(){
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,userName,password);
          //con = DriverManager.getConnection(url);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return con;
    }
}
