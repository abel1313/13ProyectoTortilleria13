<%-- 
    Document   : Mensaje
    Created on : Jul 30, 2020, 10:44:18 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
        
        if (session.getAttribute("Mensaje") != null) {
    %>
<div class="alert alert-info" role="alert">
    <button type="button" class="close" data-dismiss="alert">&times;</button>

    <h3><%= session.getAttribute("Mensaje").toString()%> </h3>
    <%

            session.removeAttribute("Mensaje");

        }
    %>  
</div>