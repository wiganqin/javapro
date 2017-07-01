/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 45441
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver" ; 
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/mldn" ;
	private static final String DBUSER = "wigan" ;
	private static final String DBPASSWORD = "123456" ;
	private Connection conn =null;
	public DatabaseConnection() throws Exception {
                              try {
                                       Class.forName(DBDRIVER) ;
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
                                     } catch (Exception e) {
                                         throw  e;
                                     }
                      
	}
        
	public Connection getConnection(){
		return this.conn ;
	}
	public void close() throws Exception {
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
	}
}
