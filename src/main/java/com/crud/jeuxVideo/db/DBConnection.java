package com.crud.jeuxVideo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connect;
    
    // @Value("${spring.datasource.url}")
    private static String dsn = "jdbc:mysql://localhost:3307/jeuxvideo";

    // @Value("${spring.datasource.username}")
    private static String dbUser ="Sani";

    // @Value("${spring.datasource.password}")
    private static String dbPass = "13Besiom";

    /*
     * Etablie la connexion avec la DB
     * @return la connexion si non existante
     */
    public static Connection getConnection() {
		
		if (connect == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection(dsn,dbUser,dbPass);
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("DB connection went kaboom");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Class not found kaboom");
			}
		}
		return connect;
	}
}
