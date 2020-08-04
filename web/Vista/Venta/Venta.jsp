<%-- 
    Document   : Venta
    Created on : Jul 3, 2020, 9:58:59 PM
    Author     : trece
--%>

<%@page import="Modelo.Venta"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


     <%
     Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(13))
     {

       if (session.getAttribute("venta") == null) {
        session.setAttribute("venta", new Venta());
    }

     %>
     <div class="contVenta">
         
     <div class="divVenta">
         
     </div>
     
     <div class="mostrarDetalleVenta">

     </div>
         
     </div>

<script src="./Javascript/Venta/Venta.js" type="text/javascript"></script>
<link href="./Estilos/Venta/Venta.css" rel="stylesheet" type="text/css"/>


<script>
    

</script>
     
     <%
         }


     %>