package com.webapplication.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException
	{
		String dbDriver= "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName="trial";
		String dbUsername="root";
		String dbPassword="root123";
		Class.forName(dbDriver);
		Connection con=DriverManager.getConnection(dbURL+dbName, dbUsername,dbPassword);
		return con;
	}

}
