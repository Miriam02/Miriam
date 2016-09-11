/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Mirizz
 */
public class Conexion {

    private Connection conexion;

    private final String direccion; 
    private final String usu;
    private final String pass;

public Conexion(){
    
    usu="root";
    pass="";
    direccion="jdbc:mysql://localhost:8081/BaseSistema";
}
    
public Connection getConexion(){
    try {

        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection(usu,pass,direccion);
        System.out.println("Se ha coonectado a la Base de Datos");
        return  conexion;
} catch (Exception e) {
        
        System.out.println(e.getMessage());
        System.out.println("Error...");
}
    
    return conexion;
}
    
public static void main(String[] args){
    Conexion a=new Conexion();
    a.getConexion();
}
}

