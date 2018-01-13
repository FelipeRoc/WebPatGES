/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miapp.clases;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class ModelPatoG {
    private static final String usuario = "root";// Usuario x defecto Xampp
    private static final String contrasena = "";//Contraseña x dececto en Xampp
    private static final String enlace = "jdbc:mysql://localhost:3306/ejercicios"; //agregar libreria
    private Connection conexion;
    private Statement smt = null;
    
    public ModelPatoG(){
        try{
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException ex){
                System.err.println(ex);
            }
            this.conexion = DriverManager.getConnection(enlace, usuario, contrasena);
            System.out.println("Conexión exitosa");
            this.smt = (Statement) this.conexion.createStatement();
        }catch(SQLException e){
            System.err.println(e);
        }        
    }
    
    public void cerrar_conexion(){
        try{
            this.smt.close();
        }catch(SQLException e){
            System.err.print(e);
        }
    }
    
    public double promediarPato(int fecha){
        try{
            String consulta = "SELECT AVG(a"+fecha+") AS `Promedio` FROM JavaEj4";
            ResultSet resultado = this.smt.executeQuery(consulta);
            if(resultado.first()){
                double promedio = resultado.getDouble("Promedio");                    
                return promedio;
            }
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
        return 0;
    }
    
    public int sumarPato(int fecha){
        try{
            String consulta = "SELECT SUM(a"+fecha+") AS `Suma` FROM JavaEj4";
            ResultSet resultado = this.smt.executeQuery(consulta);
            if(resultado.first()){
                int suma = resultado.getInt("Suma");                
                return suma;
            }
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
        return 0;
    }
    
    public ArrayList<ControllerPatoG> tablaPato(){
        ArrayList<ControllerPatoG> patologia = new ArrayList<ControllerPatoG>();
        try{
            String consulta = "SELECT *FROM JavaEj4";
            ResultSet resultado = this.smt.executeQuery(consulta);
            while(resultado.next()){
                int id = resultado.getInt("idpat");
                String pato = resultado.getString("patologia");
                int a2009 = resultado.getInt("a2009");
                int a2010 = resultado.getInt("a2010");
                int a2011 = resultado.getInt("a2011");
                int a2012 = resultado.getInt("a2012");
                int a2013 = resultado.getInt("a2013");
                int a2014 = resultado.getInt("a2014");
                int a2015 = resultado.getInt("a2015");
                int a2016 = resultado.getInt("a2016");
                int a2017 = resultado.getInt("a2017");
                ControllerPatoG pato_guar = new ControllerPatoG(id, pato, a2009, a2010, a2011, a2012, a2013, a2014, a2015, a2016, a2017);
                patologia.add(pato_guar);
            }
            return patologia;
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    
    public ResultSet patologia(){
        ResultSet resultado = null;
        try{
            String consulta = "SELECT *FROM JavaEj4";
            resultado = this.smt.executeQuery(consulta);            
        }catch(SQLException e){
            System.err.println(e);            
        }
        return resultado;
    }
}
