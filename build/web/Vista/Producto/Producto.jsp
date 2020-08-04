<%-- 
    Document   : Producto
    Created on : Jul 30, 2020, 11:27:07 PM
    Author     : trece
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
         Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(9))
     {

%>
<div class="productosContenido">
    <div class="row">
        <div class="col-12">
            <div class="form-group"><label for="buscarPrducto">Buscar producto</label>
                <input type="text" class="form-control col-3" id="buscarPrducto" placeholder="Buscar producto">
            </div>
        </div>
    </div>
    <div class="productos">

    </div>
</div>


<link href="./Estilos/Producto/Producto.css" rel="stylesheet" type="text/css"/>
<script src="./Javascript/Producto/Producto.js" type="text/javascript"></script>

<%
    }
%>