/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.io.BufferedWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mirizz
 */
public class BaseEscuela {
    public static BaseEscuela llenar=new BaseEscuela();
    public static ArrayList<String> listNombre = new ArrayList<String>();
    public static ArrayList<String> listPaterno = new ArrayList<String>();
    public static ArrayList<String> listMaterno = new ArrayList<String>();
    public static ResultSet resultado;

    Conexion conector=new Conexion();
    BufferedWriter bw;

public static Random random = new Random();

public void llamar(){
    
BaseEscuela L=new BaseEscuela();
    L.consultaNombre();
    L.consultaPaterno();
    L.consultaMaterno();
    
}

public static void main(String[] a){
  
    BaseEscuela A=new BaseEscuela();
    A.consultaNombre();
    A.llamar();
    for(int i=0;i<listNombre.size();i++){

        System.out.println("\""+llenar.listNombre.get(random.nextInt(llenar.listNombre.size()))+"\"");
    }

}

private void consultaNombre() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try {
            String sentencia_sql="select * from nombres_m,nombres_h";
            CallableStatement ejecutar_consulta=conector.getConexion().prepareCall(sentencia_sql);
            resultado=ejecutar_consulta.executeQuery();
       while (resultado.next()) {
            listNombre.add(resultado.getString(1));}
       } catch (Exception e) {
            System.out.println("Error en metodo "+e.getMessage());
} 
  
}

    private void consultaPaterno() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        String sentencia_sql="select * apellido_paterno";
        CallableStatement ejecutar_consulta=conector.getConexion().prepareCall(sentencia_sql);
        resultado=ejecutar_consulta.executeQuery();
    while (resultado.next()) {
        listNombre.add(resultado.getString(1));}
    } catch (Exception e) {
        System.out.println("Error en metodo "+e.getMessage());
} 
  
}

    private void consultaMaterno() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        String sentencia_sql="select * apellido_materno";
        CallableStatement ejecutar_consulta=conector.getConexion().prepareCall(sentencia_sql);
        resultado=ejecutar_consulta.executeQuery();
    while (resultado.next()) {
        listNombre.add(resultado.getString(1));}
    } catch (Exception e) {
        System.out.println("Error en metodo "+e.getMessage());
    }
}
}