/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consultas.ConsultaCliente;
import Consultas.ConsultaVenta;
import MCRUD.CRUD;
import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.Usuario;
import Modelo.Venta;
import ModeloDAO.ClienteDAO;
import ModeloDAO.UsuarioDAO;
import ModeloDAO.VentaDAO;

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
 * @author trece
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/DatosCliente"})
public class ServletCliente extends HttpServlet {
String accion;
Usuario usuarioSesion = null;
CRUD clienteCRUD = null;
Cliente cli = null;
UsuarioDAO usrDAO = null;
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
            out.println("<title>Servlet ServletCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCliente at " + request.getContextPath() + "</h1>");
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
        accion = request.getParameter("accion");
        usuarioSesion = (Usuario) request.getSession().getAttribute("us");
        
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(1)) 
        {
            
            if (accion != null) 
            {
                clienteCRUD = new ConsultaCliente();
                if (accion.equals("agregarCliente")) 
                {
                    
                    cli = new Cliente();

                    cli.getPersonaCliente().getDireccionPersona().setPais_Direccion(request.getParameter("Pais"));
                    cli.getPersonaCliente().getDireccionPersona().setEstado_Direccion(request.getParameter("Estado"));
                    cli.getPersonaCliente().getDireccionPersona().setMunicipio_Direccion(request.getParameter("Municipio"));
                    cli.getPersonaCliente().getDireccionPersona().setCalle_Direccion(request.getParameter("Calle"));
                    cli.getPersonaCliente().getDireccionPersona().setColonia_Direccion(request.getParameter("Colonia"));
                    cli.getPersonaCliente().getDireccionPersona().setCodigoPostal_Direccion(request.getParameter("CodigoPostal"));
                    cli.getPersonaCliente().getDireccionPersona().setNumeroExterior_Direccion(request.getParameter("NumeroExterior"));
                    cli.getPersonaCliente().getDireccionPersona().setNumeroInterior_Direccion(request.getParameter("NumeroInterior"));

                    cli.getPersonaCliente().setNombre_Persona(request.getParameter("Nombre"));
                    cli.getPersonaCliente().setPaterno_Persona(request.getParameter("Paterno"));
                    cli.getPersonaCliente().setMaterno_Persona(request.getParameter("Materno"));
                    cli.getPersonaCliente().setFechaNacimiento_Persona(request.getParameter("FechaNacimiento"));
                    cli.getPersonaCliente().setSexo_Persona(request.getParameter("Sexo"));
                    cli.getPersonaCliente().setTelefono_Persona(request.getParameter("Telefono"));
                    cli.getPersonaCliente().setCorreo_Persona(request.getParameter("Correo"));

                    Cliente cliAgregra = (Cliente) clienteCRUD.agregar(cli);

                    Venta ves = (Venta) request.getSession().getAttribute("venta");
                    if (cliAgregra.getId_Cliente() != 0) {
                        ves.setClienteVenta(cliAgregra);
                    }

                }
                if (accion.equals("nuevaDireccionDetalle")) 
                {
                    ClienteDAO dirNueva = new ConsultaCliente();
                    Direccion dir = new Direccion();

                    dir.setPais_Direccion(request.getParameter("Pais"));
                    dir.setEstado_Direccion(request.getParameter("Estado"));
                    dir.setMunicipio_Direccion(request.getParameter("Municipio"));
                    dir.setCalle_Direccion(request.getParameter("Calle"));
                    dir.setColonia_Direccion(request.getParameter("Colonia"));
                    dir.setCodigoPostal_Direccion(request.getParameter("CodigoPostal"));
                    dir.setNumeroExterior_Direccion(request.getParameter("NumeroExterior"));
                    dir.setNumeroInterior_Direccion(request.getParameter("NumeroInterior"));

                    Direccion dirReg = (Direccion) dirNueva.agregarDireccion(dir);

                    Venta ves = (Venta) request.getSession().getAttribute("venta");
                    
                    if (dirReg.getId_Direccion()!= 0) {
                        
                        ves.getTipoPedidoVenta().setId_TipoPedido(2);
                        ves.getUsuarioVenta().setId_Usuario(usuarioSesion.getId_Usuario());
                        VentaDAO ventaDatos = new ConsultaVenta();
                        if(ventaDatos.agregarDatos(ves, dirReg.getId_Direccion()))
                        {
                            request.getSession().setAttribute("venta", new Venta());
                            request.getSession().setAttribute("Mensaje", "Envio a domicilio correctamente");
                        }
                    }

                }
                if (accion.equals("direccionCliente"))
                {      
                    VentaDAO ventaDireccionActual = new ConsultaVenta();
                    Venta venta = (Venta)request.getSession().getAttribute("venta");
                    venta.getTipoPedidoVenta().setId_TipoPedido(Integer.parseInt(request.getParameter("tipoPedido")));
                    venta.getUsuarioVenta().setId_Usuario(usuarioSesion.getId_Usuario());
                    
                    
                    if(ventaDireccionActual.agregarDatos(venta, 0)){
                             request.getSession().setAttribute("venta", new Venta());
                            request.getSession().setAttribute("Mensaje", "Envio a domicilio correctamente");
                            
                    
                    }

                }
                if (accion.equals("tortillriaPedido"))
                {      
                    VentaDAO ventaDireccionActual = new ConsultaVenta();
                    Venta venta = (Venta)request.getSession().getAttribute("venta");
                    venta.getTipoPedidoVenta().setId_TipoPedido(Integer.parseInt(request.getParameter("tipoPedido")));
                    venta.getUsuarioVenta().setId_Usuario(usuarioSesion.getId_Usuario());
                    
                    
                    if(ventaDireccionActual.agregarPedidoTortilleria(venta)){
                             request.getSession().setAttribute("venta", new Venta());
                            request.getSession().setAttribute("Mensaje", "Pedido creado correctamente");
                            
                    }

                }
                
                if(accion.equals("buscarCliente"))
                {
                    
                  clienteCRUD = new ConsultaCliente();
                   ArrayList buscarCliente = clienteCRUD.buscarTodos(request.getParameter("buscarCliente"));
                   request.getSession().setAttribute("cliente",buscarCliente);
                }
                if(accion.equals("selecccionarClienteVenta"))
                {
                    int valor = Integer.parseInt(request.getParameter("idCliente"));
                    Cliente cl=((ArrayList<Cliente>)request.getSession().getAttribute("clienteListo")).get(valor);
                    
                    Venta v= (Venta)request.getSession().getAttribute("venta");
                    if (usuarioSesion.getRolUsuario().getId_RolUduario() == 1) {
                        
                        
                        if (cl.getId_Cliente() != 0) {
                            
                            v.setClienteVenta(cl);
                            
                            

                        }
                    }else{
                        
                         v.setClienteVenta(cl);
                    }


                }
               if (usuarioSesion.getRolUsuario().getId_RolUduario() !=1 ) {

                Venta ves = (Venta) request.getSession().getAttribute("venta");
                ves.setClienteVenta(usuarioSesion.getClienteUsuario());

                }


                if (accion.equals("validarCorreoCliente")) {
                    if (clienteCRUD.validarCorreo(request.getParameter("Correo"))) {
                        response.setContentType("text/plain");
                        response.getWriter().write("false");
                    } else {
                        response.setContentType("text/plain");
                        response.getWriter().write("true");
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
