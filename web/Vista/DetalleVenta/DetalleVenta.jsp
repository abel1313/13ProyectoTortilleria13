<%-- 
    Document   : DetalleVenta
    Created on : Jul 3, 2020, 10:44:25 PM
    Author     : trece
--%>

<%@page import="Modelo.DetalleVenta"%>
<%@page import="Modelo.Venta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Consultas.ConsultaProducto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="Modelo.Producto"%>
<%@page import="MCRUD.CRUD"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%> 
<%
    CRUD producto = new ConsultaProducto();
    Usuario usuarioSession = (Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
        response.sendRedirect("../../Vista/Login/Login.jsp");

    }
    if (usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(13)) {

        ArrayList<Producto> pro = producto.buscar(0);
        session.setAttribute("productoDisponible", pro);

        Venta ve = (Venta) session.getAttribute("venta");
System.out.println(usuarioSession.getClienteUsuario().getId_Cliente());
%>


<div class="contDetalle">

    <%
        if (usuarioSession.getClienteUsuario().getId_Cliente() == 63) {
    %>
    <div class="divExisteCliente">

        <div class="row">
            <div class="col-12">
                <h2>Seleccione cliente</h2>
            </div>
        </div> 
        <div class="row">
            <div class="col-12">
                <div class="btn btn-group centrarBoton">
                    <button type="button" class="btn btn-info" id="ExisteClienteDetalle">Buscar cliente</button>
                    <button type="button" class="btn btn-danger" id="noExisteClienteDetalle">Nuevo cliente</button>
                </div> 
            </div>
        </div> 
    </div>   
    <%    
        }
    %>


    <div class="row">
        <div class="col-6">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Seleccione Producto </label>
                <select class="form-control col-12" id="exampleFormControlSelect1">
                    <option value="0">Seleccione Producto</option>
                    <%
                        for (int i = 0; i < pro.size(); i++) {
                            Producto p = pro.get(i);


                    %> 
                    <option selected="" value="<%=i%>"><%=(p.getNombre_Producto())%></option>
                    <%
                        }
                    %>     

                </select>

            </div>
        </div>
        <div class="col-3">
            <div class="form-group">
                <label for="cantidadTortillas" id="cantTor">cantidad </label>
                <input type="text" class="form-control col-12" name="cantidadTortillas" id="cantidadTortillas" placeholder="Ingrese cantidad"/>

            </div>
        </div>
        <div class="col-3">
            <div class="form-group">
                <br/>
                <button class="btn btn-info agregarCantidad" id="">Agregar</button>
            </div>
        </div>
                    
    </div>


    <div class="Mensajex">
        
    </div>

    <div class="divTablaDetalle">
        <table class="table">
            <thead>
                <tr class="table">
                    <th>Producto</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Pedido</th>
                    <th>Sub total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < ve.getDetalleVenta().size(); i++) {
                        DetalleVenta d = ve.getDetalleVenta().get(i);
                %>
                <tr>
                    <td><%=(d.getProductoDetalle().getNombre_Producto())%></td>
                    <td><%=(d.getProductoDetalle().getDescipcion_Producto())%></td>
                    <td>$ <%=(d.getProductoDetalle().getPrecio_Producto())%></td>
                    <td><%=(d.getCantidad_ProductoDetalle())%> kg</td>           
                    <td>$ <%=(d.getSubtotalDetalle())%></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td>
                        <%
                            if (ve.getDetalleVenta().size() > 0 && ve.getId_Venta() == 0 && usuarioSession.getRolUsuario().getNombre_RolUsuario().equals("Administrador")) {
                        %>
                        <button type="button" class="btn btn-info realizarVenta" value="realizarVenta">Agregar</button>
                        <%
                            }
                        %>
                        <%
                            if (ve.getDetalleVenta().size() > 0 && ve.getId_Venta() == 0 && ve.getClienteVenta().getId_Cliente() != 0) {
                        %>
                        <button type="button" class="btn btn-info realizarCOmpraDomicilio" value="realizarVentaDomicilio">Comprar</button>
                        <%
                            }
                        %> 
                                                <%
                            if (ve.getDetalleVenta().size() > 0) {
                        %>
                        <button type="button" class="btn btn-info" id="nuevaVenta">Nueva Venta</button>
                        <%
                            }
                        %>
                    </td>
                    <td>

                    </td>
                    <td>


                    </td>
                    <td></td>

                    <td>Total $ <%=(ve.getTotal_Venta())%></td>
                </tr>
            </tbody>
        </table>
    </div>

    

 

</div>

<div class="clienteCompra">

</div>


<div class="AgregarClienteDetalle">

    <div class="divCentrarDatos">

        <form id="formDatos">
            <input type="hidden" name="accion" value="agregarCliente">

            <div class="datosDireccion">

            </div>
            <div class="datosPersonales">

            </div>


            <div class="btn btn-group">
                <button type="submit" class="btn btn-info" id="agregarCliente">Agregar</button>
                <button type="button" class="btn btn-danger" id="cancelarAgregarCliente">cancelar</button>
            </div>

        </form>


    </div>



</div>

<div class="VerClientes">

    <div class="contCliente">

        <div class="BuscarCliente">

            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="buscarCliente" class="p-2">Buscar Cliente</label>
                        <input type="text" class="form-control" name="BuscarCliente" id="buscarCliente" placeholder="Buscar Cliente">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <button class="btn btn-danger cerrarClientes">cerrar</button>
                    </div>
                </div>
            </div>

        </div>

        <div class="TodosClientes">

        </div>

    </div>

</div>
    
    <div class="idActualizarTortillas">
        
    </div>

<link href="./Estilos/DetalleVenta/DetalleVenta.css" rel="stylesheet" type="text/css"/>
<script src="./Javascript/DetalleVenta/DetalleVenta.js" type="text/javascript"></script>


<%
    }
%>

