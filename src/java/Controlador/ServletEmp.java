/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consultas.ConsultaEmpleado;
import Modelo.Direccion;
import Modelo.Persona;
import Modelo.Empleado;
import Modelo.Usuario;
import ModeloDAO.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elver
 */
@WebServlet(name = "ServletEmp", urlPatterns = {"/ServletEmp"})
public class ServletEmp extends HttpServlet {

    String accion;
    EmpleadoDAO empDAO=null;
    Empleado empleadoDatos=null;
    Usuario usuarioSesion = null;
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
            out.println("<title>Servlet ServletEmp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEmp at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        accion = request.getParameter("accion");
        usuarioSesion = (Usuario) request.getSession().getAttribute("us");
        empDAO = new ConsultaEmpleado();
        empleadoDatos = new Empleado();
        //System.out.println(accion);
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(5)) {

            if (accion != null) {

                if (accion.equals("buscarEmpleado")) {
                    empDAO = new ConsultaEmpleado();

                    ArrayList ListaEmpleados = empDAO.buscarTodos(request.getParameter("busca"));
                    request.getSession().setAttribute("ListaEmpleados", ListaEmpleados);
                }
                if (accion.equals("agregarEmp")) {
                    empDAO = new ConsultaEmpleado();
                    Direccion d = new Direccion();
                    Persona p = new Persona();
                    Empleado e = new Empleado();
                    d.setPais_Direccion(request.getParameter("pais"));
                    d.setEstado_Direccion(request.getParameter("estado"));
                    d.setMunicipio_Direccion(request.getParameter("muni"));
                    d.setColonia_Direccion(request.getParameter("col"));
                    d.setCalle_Direccion(request.getParameter("call"));
                    d.setCodigoPostal_Direccion(request.getParameter("cp"));
                    d.setNumeroExterior_Direccion(request.getParameter("nex"));
                    d.setNumeroInterior_Direccion(request.getParameter("nin"));
                    p.setNombre_Persona(request.getParameter("nombre"));
                    p.setPaterno_Persona(request.getParameter("ApPa"));
                    p.setMaterno_Persona(request.getParameter("ApMa"));
                    p.setFechaNacimiento_Persona(request.getParameter("fech"));
                    p.setSexo_Persona(request.getParameter("Sexo"));
                    p.setCorreo_Persona(request.getParameter("email"));
                    p.setTelefono_Persona(request.getParameter("tel"));
                    e.setPuesto_Empleado(request.getParameter("puesto"));
                    e.setSueldoDia_Empleado(Double.parseDouble(request.getParameter("Sueldo")));

                   // e.getPersonaCliente().setDireccionPersona(d);
                    p.setDireccionPersona(d);
                    e.setPersonaCliente(p);
//                    System.out.println(accion);
//                    System.out.println("pais "+request.getParameter("pais")+" modelo: "+d.getPais_Direccion());
//                    System.out.println("estado "+request.getParameter("estado"));
//                    System.out.println("municipio "+request.getParameter("muni"));
//                    System.out.println("colonia "+request.getParameter("col"));
//                    System.out.println("calle "+request.getParameter("call"));
//                    System.out.println("CP "+request.getParameter("cp"));
//                    System.out.println("No Ext "+request.getParameter("nex"));
//                    System.out.println("No Int "+request.getParameter("nin"));
                    if (empDAO.agregarEmpleado(e)) {
                        System.out.println("Empleado Agregado Con Exito.");
                    } else {
                        System.out.println("Error al agregar Empleado");
                    }
                }
                if (accion.equals("actuaizarEmpleado")) { 
                Empleado dtosEmpleado=(Empleado) request.getSession().getAttribute("editarEmpleadoListo");
                empDAO = new ConsultaEmpleado();
                Direccion d=new Direccion();
                Persona p=new Persona();
                Empleado e=new Empleado();
                
               
                
                p.setId_Persona(dtosEmpleado.getPersonaCliente().getId_Persona());
                p.setNombre_Persona(request.getParameter("nombre"));
                p.setPaterno_Persona(request.getParameter("ApPa"));
                p.setMaterno_Persona(request.getParameter("ApMa"));
                p.setFechaNacimiento_Persona(request.getParameter("fech"));
                p.setSexo_Persona(request.getParameter("Sexo"));
                p.setCorreo_Persona(request.getParameter("email"));
                p.setTelefono_Persona(request.getParameter("tel"));
                e.setPersonaCliente(p);
                
                 d.setId_Direccion(dtosEmpleado.getPersonaCliente().getDireccionPersona().getId_Direccion());
                d.setPais_Direccion(request.getParameter("pais"));
                d.setEstado_Direccion(request.getParameter("estado"));
                d.setMunicipio_Direccion(request.getParameter("muni"));
                d.setColonia_Direccion(request.getParameter("col"));
                d.setCalle_Direccion(request.getParameter("call"));
                d.setCodigoPostal_Direccion(request.getParameter("cp"));
                d.setNumeroExterior_Direccion(request.getParameter("nex"));
                d.setNumeroInterior_Direccion(request.getParameter("nin"));
                e.getPersonaCliente().setDireccionPersona(d);
                   
                System.out.println("ID Dir modelo "+d.getId_Direccion());
                    System.out.println("pais "+request.getParameter("pais")+" modelo: "+d.getPais_Direccion());
                    System.out.println("estado "+request.getParameter("estado"));
                    System.out.println("municipio "+request.getParameter("muni"));
                    System.out.println("colonia "+request.getParameter("col"));
                    System.out.println("calle "+request.getParameter("call"));
                    System.out.println("CP "+request.getParameter("cp"));
                    System.out.println("No Ext "+request.getParameter("nex"));
                    System.out.println("No Int "+request.getParameter("nin"));
                
                e.setId_Empleado(dtosEmpleado.getId_Empleado());
                e.setPuesto_Empleado(request.getParameter("puesto"));
                e.setSueldoDia_Empleado(Double.parseDouble(request.getParameter("Sueldo")));
                System.out.println("ID Empleado modelo "+e.getId_Empleado()+" id que llega de lista "+dtosEmpleado.getId_Empleado());
                if(empDAO.actualizar(e)){
                    
                }
                }

            }
        }
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
