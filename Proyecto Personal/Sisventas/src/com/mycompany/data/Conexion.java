
package com.mycompany.data;

import java.sql.*;

public class Conexion {
    
    private static final String URL_MYSQL ="jdbc:mysql://localhost:3306/sisventas";
    private static final String USER_MYSQL="root"; 
    private static final String PASSWORD_MYSQL=""; 
    
   
   public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL_MYSQL,USER_MYSQL,PASSWORD_MYSQL);
    } 
   
    private static void closeFlujo(Connection conexion) throws SQLException{
        conexion.close();
    }
      private static void closeFlujo(PreparedStatement staments) throws SQLException{
        staments.close();
    }
        private static void closeFlujo(ResultSet results) throws SQLException{
        results.close();
    }
    
}
