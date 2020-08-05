/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consultas.ConsultaProducto;
import MCRUD.CRUD;
import Modelo.Producto;
import Modelo.Usuario;
import ModeloDAO.ProductoDAO;
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
@WebServlet(name = "ServletProducto", urlPatterns = {"/DatosProducto"})
public class ServletProducto extends HttpServlet {

    String accion;
    Usuario usuarioSesion = null;
    CRUD productoCRUD = null;

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
            out.println("<title>Servlet ServletProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProducto at " + request.getContextPath() + "</h1>");
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

        // System.out.println("Accion "+accion +" "+ request.getParameter("actualizarProducto"));
        
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(9)) {

            if (accion != null) {

                productoCRUD = new ConsultaProducto();

                if (accion.equals("Producto")) {

                    Producto p = ((ArrayList<Producto>) request.getSession().getAttribute("productoDisponible")).get(Integer.parseInt(request.getParameter("id")));
                    request.getSession().setAttribute("productoEncontrado", p);
                }
                if (accion.equals("buscarProducto") && request.getParameter("filtro") != null) {

                    ArrayList prdEncontrado = productoCRUD.buscar(Integer.parseInt(request.getParameter("filtro")));
                    request.getSession().setAttribute("producEncontrado", prdEncontrado);
                }
                if (accion.equals("agregarProducto")) {
                    productoCRUD = new ConsultaProducto();
                    Producto p = new Producto();
                    p.setNombre_Producto(request.getParameter("nameService"));
                    p.setDescipcion_Producto(request.getParameter("DescriptionService"));
                    p.setPrecio_Producto(Double.parseDouble(request.getParameter("PrecioService")));
                    p.setExistencias_Producto(Double.parseDouble(request.getParameter("KilosDisponibles")));
                    if (productoCRUD.agregarDatos(p));
                    {

                        request.getSession().setAttribute("Mensaje", "El producto se agregó correctamente");
                    }
                }
                if (accion.equals("DatosProducto")) {
                    productoCRUD = new ConsultaProducto();

                    ArrayList listProducto = productoCRUD.buscarTodos(request.getParameter("filtro"));
                    request.getSession().setAttribute("listaProducto", listProducto);
                }
                if (accion.equals("editarProducto")) {
                    productoCRUD = new ConsultaProducto();
                    Producto p = (Producto) request.getSession().getAttribute("editarProducto");

                    p.setNombre_Producto(request.getParameter("nameService"));
                    p.setDescipcion_Producto(request.getParameter("DescriptionService"));
                    p.setPrecio_Producto(Double.parseDouble(request.getParameter("PrecioService")));
                    p.setExistencias_Producto(Double.parseDouble(request.getParameter("KilosDisponibles")));
                    if (productoCRUD.actualizar(p));
                    {

                        request.getSession().setAttribute("Mensaje", "Se actualizo correctamente");
                    }
                }
                    if (accion.equals("actualizarProducto")) {
                        
                    ProductoDAO productoDAO= new ConsultaProducto();
                    Producto p = new Producto();

                    p.setExistencias_Producto(Double.parseDouble(request.getParameter("cantidad")));
                    if (productoDAO.actualizarProductoSolo(p));
                    {
                        
                        request.getSession().setAttribute("Mensaje", "Se actualizo correctamente");
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
