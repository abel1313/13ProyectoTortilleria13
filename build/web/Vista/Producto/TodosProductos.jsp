<%-- 
    Document   : TodosProductos
    Created on : Jul 30, 2020, 11:36:13 PM
    Author     : trece
--%>

<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%

     Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(9))
     {

         
ArrayList<Producto> prod = session.getAttribute("listaProducto") != null ? 
(ArrayList<Producto>) session.getAttribute("listaProducto") : new ArrayList();


%>
<style>
   .tablaProd{

    overflow: scroll;
    overflow-x: hidden;
   
}
</style>
<%       
    if (session.getAttribute("Mensaje") != null) {
%>
<div class="mensajeUsuariox mx-auto" id="" style="width: 50rem;">

    <div class="alert alert-info" role="alert">
        <button type="button" class="close" data-dismiss="alert">&times;</button>

        <h3><%= session.getAttribute("Mensaje").toString()%> </h3>

    </div>
</div>
<%

        session.removeAttribute("Mensaje");

    }
%>
<div class="tablaProd">
    <table class="table">
    <thead>
        <tr>
            <th>Nombre del producto</th>
            <th>Descripcion del producto</th>
            <th>Precio del producto</th>
            <th>Kilos en existencia</th>
            <th>Acción</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (int i = 0; i < prod.size(); i++) 
            {        
            Producto p = prod.get(i);
        %>
        <tr>
            <td><%=(p.getNombre_Producto())%></td>
            <td><%=(p.getDescipcion_Producto())%></td>
            <td>$ <%=(p.getPrecio_Producto())%></td>
            <td><%=(p.getExistencias_Producto())%></td>
            <td>
                <button class="btn btn-info editarProducto" value="<%=i%>">Editar</button>
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</div>


<%
    }
%>

<script src="./Javascript/Producto/TodosProductos.js" type="text/javascript"></script>
