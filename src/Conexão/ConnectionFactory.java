/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexão;

import java.sql.*;

/**
 *
 * @author anton
 */
public class ConnectionFactory {

    // metodo de conexão do banco
    public Connection conecta() {

        String driver = "com.mysql.jdbc.Driver";

        // url do banco
        String url = "jdbc:mysql://localhost:3306/petshop_bd?useSSL=false";

        //usuario do banco
        String user = "root";

        //senha do banco
        String password = "777";

        // Estabelecendo a Conexão
        try {

            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
