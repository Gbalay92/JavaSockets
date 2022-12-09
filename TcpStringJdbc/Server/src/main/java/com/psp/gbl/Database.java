package com.psp.gbl;

import java.sql.*;

public class Database {

    private static String databaseUrl ="jdbc:mysql://localhost/psp";
    private static Connection conexion;
    public static void conexionSql() throws SQLException {
        //LoginController.showAlert(Alert.AlertType.INFORMATION, "inf", user+ " " + password);
        conexion= DriverManager.getConnection(databaseUrl, "root", "");
    }

    public static ResultSet realizarConsulta(String peticion) {
        try {
            String query="SELECT * FROM " + peticion;
            System.out.println(query);
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta");
        }


        return null;
    }
}
