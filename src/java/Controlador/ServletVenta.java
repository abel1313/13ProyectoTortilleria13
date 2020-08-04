/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consultas.ConsultaDetalle;

import Consultas.ConsultaVenta;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Venta;
import ModeloDAO.DetalleDAO;
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
@WebServlet(name = "ServletVenta", urlPatterns = {"/DatosVenta"})
public class ServletVenta extends HttpServlet {

    String accion;
    Usuario usuarioSesion = null;
    DetalleDAO detalleDAO = null;
    VentaDAO ventaDAO = null;

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
            out.println("<title>Servlet ServletVenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVenta at " + request.getContextPath() + "</h1>");
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

        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(13)) {
            if (accion != null) {

                String cantidad = request.getParameter("cantidad");
                String producto = request.getParameter("idProducto");

                if (accion.equals("agregarProductoDetalle") && !cantidad.equals("") && !producto.equals("")) {
                    if (Double.parseDouble(cantidad) > 0) {
                        boolean verificando = Boolean.parseBoolean(request.getParameter("verificar"));

                        detalleDAO = new ConsultaDetalle();

                        Producto pe = ((ArrayList<Producto>) request.getSession().getAttribute("productoDisponible")).get(Integer.parseInt(producto));

                        double cie07Pesos = 0;
                        if (verificando) {
                            cie07Pesos = Double.parseDouble(cantidad) / pe.getPrecio_Producto();
                        } else {
                            cie07Pesos = Double.parseDouble(cantidad);
                        }

                        DetalleVenta d = new DetalleVenta();
                        d.setProductoDetalle(pe);
                        d.setCantidad_ProductoDetalle(cie07Pesos);
                        d.setSubtotalDetalle(d.getCantidad_ProductoDetalle() * pe.getPrecio_Producto());

                        if (d.getProductoDetalle().getId_Producto() != 0) {
                            Venta v = (Venta) request.getSession().getAttribute("venta");
                            if (v.getId_Venta() == 0) {
                                double existencias = new ConsultaDetalle().agregarDetalleExistencias(v, d);
                                if (existencias > 0) {
                                    request.getSession().setAttribute("Mensaje", "Solo existen " + existencias + " kilos");
                                }
                            }

                        }
                    }
                } else {

                    request.getSession().setAttribute("Mensaje", "Ingrese cantidad valida");
                }
                if (accion.equals("realizarVenta")) {

                    Venta venta = (Venta) request.getSession().getAttribute("venta");

                    if (venta.getClienteVenta().getId_Cliente() == 0) {
                        venta.getClienteVenta().setId_Cliente(usuarioSesion.getClienteUsuario().getId_Cliente());
                    }

                    venta.getTipoPedidoVenta().setId_TipoPedido(Integer.parseInt(request.getParameter("tipoPedido")));
                    venta.getUsuarioVenta().setId_Usuario(usuarioSesion.getId_Usuario());

                    ventaDAO = new ConsultaVenta();
                    if (ventaDAO.agregarDatos(venta)) {

                        request.getSession().setAttribute("venta", new Venta());
                        request.getSession().setAttribute("Mensaje", "Venta realizada");
                    }
                }
                if (accion.equals("realizarVentaDomicilio")) {

                    Venta venta = (Venta) request.getSession().getAttribute("venta");
                    venta.getTipoPedidoVenta().setId_TipoPedido(Integer.parseInt(request.getParameter("tipoPedido")));
                    venta.getUsuarioVenta().setId_Usuario(usuarioSesion.getId_Usuario());
                    ventaDAO = new ConsultaVenta();
                    ventaDAO.agregarDatos(venta);
                    request.getSession().setAttribute("venta", new Venta());
                }

                if (accion.equals("nuevaVenta")) {
                    request.getSession().setAttribute("venta", new Venta());
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
