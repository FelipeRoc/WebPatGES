/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miapp.clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "consulta", urlPatterns = {"/consulta"})
public class ServletPatoG extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPatoG</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPatoG at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        //Mostrar Promedio por año de las patologías GES
        String boton_promedio = request.getParameter("mostrar_prom");
        String ano_promedio = request.getParameter("ano_promedio");
        if(boton_promedio != null){            
            int ano_prom_int = Integer.parseInt(ano_promedio);
            
            ModelPatoG prom_pato = new ModelPatoG();
            double promedio = prom_pato.promediarPato(ano_prom_int);
            
            prom_pato.cerrar_conexion();            
            
            String promedio_string = String.valueOf(promedio);
            
            request.setAttribute("fecha_prom", promedio_string);
            request.setAttribute("ano_prom", ano_promedio);
            
            request.getRequestDispatcher("ViewPromPat.jsp").forward(request, response);
        }
        
        //Mostrar Suma por año de las patologías GES
        String boton_suma = request.getParameter("mostrar_suma");
        if(boton_suma != null){
            String ano_suma = request.getParameter("ano_suma");
            int ano_suma_int = Integer.parseInt(ano_suma);
            
            ModelPatoG suma_pato = new ModelPatoG();
            int suma = suma_pato.sumarPato(ano_suma_int);
            
            suma_pato.cerrar_conexion();
            
            String suma_string = String.valueOf(suma);
            
            request.setAttribute("fecha_suma", suma_string);
            request.setAttribute("ano_suma", ano_suma);
            
            request.getRequestDispatcher("ViewSumaPat.jsp").forward(request, response);
        
        }
        
        //Mostrar Tabla por año de las patologías GES
        String boton_tabla = request.getParameter("mostrar_tabla");
        if(boton_tabla != null){           
            
            /*int id = 1, a2009 = 0, a2010 = 0, a2011 = 0, a2012 = 0, a2013 = 0, a2014 = 0, a2015 = 0, a2016 = 0, a2017 = 0;
            String patol = "";  */          
            ControllerPatoG pato_tabla = new ControllerPatoG();
            ModelPatoG tabla_pato = new ModelPatoG();
            
            ArrayList<ControllerPatoG> patologia = tabla_pato.tablaPato();
            
            //Ingreso datos a la vista.
            String html = "";
            for(ControllerPatoG patol_bd: patologia){
                html += "<tr>";
                html += "<td>"+patol_bd.getId()+"</td>";
                html += "<td>"+patol_bd.getPatol()+"</td>";
                html += "<td>"+patol_bd.getA2009()+"</td>";
                html += "<td>"+patol_bd.getA2010()+"</td>";
                html += "<td>"+patol_bd.getA2011()+"</td>";
                html += "<td>"+patol_bd.getA2012()+"</td>";
                html += "<td>"+patol_bd.getA2013()+"</td>";
                html += "<td>"+patol_bd.getA2014()+"</td>";
                html += "<td>"+patol_bd.getA2015()+"</td>";
                html += "<td>"+patol_bd.getA2016()+"</td>";
                html += "<td>"+patol_bd.getA2017()+"</td>";
                html += "</tr>";            
            }
            
            tabla_pato.cerrar_conexion();
            
            request.setAttribute("id_pat", pato_tabla.getId());
            request.setAttribute("patologia", pato_tabla.getPatol());
            request.setAttribute("a2009", pato_tabla.getA2009());
            request.setAttribute("a2010", pato_tabla.getA2010());
            request.setAttribute("a2011", pato_tabla.getA2011());
            request.setAttribute("a2012", pato_tabla.getA2012());
            request.setAttribute("a2013", pato_tabla.getA2013());
            request.setAttribute("a2014", pato_tabla.getA2014());
            request.setAttribute("a2015", pato_tabla.getA2015());
            request.setAttribute("a2016", pato_tabla.getA2016());
            request.setAttribute("a2017", pato_tabla.getA2017());
            request.setAttribute("html", html);
            
        
            request.getRequestDispatcher("ViewTabla.jsp").forward(request, response);               
    }
        
        
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
