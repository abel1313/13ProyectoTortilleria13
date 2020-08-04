<%-- 
    Document   : Usuarios
    Created on : Jul 21, 2020, 5:17:45 PM
    Author     : trece
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        Usuario usuarioSesion =(Usuario)session.getAttribute("us");
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(12)) 
        {
            
ArrayList<Usuario>usuariosArray = session.getAttribute("usuariosEncontados") !=null ? 
(ArrayList<Usuario>)session.getAttribute("usuariosEncontados"):new ArrayList();
session.setAttribute("UsuarioListo", usuariosArray);
%>
<div class="tablaUsuarios container-fluid">
    <table class="table table-info">
        <thead>
            <tr>
                <th>Nombre y Usuario</th>
                <th>Apellidos</th>
                <th>Pais y Estado</th>
                <th>Correo</th>
                <th>Rol</th>
                <th>Accion</th>

            </tr>
        </thead>
        <tbody>
            <%
            for(int i = 0; i<usuariosArray.size(); i++)
            {
                Usuario us = usuariosArray.get(i);
            %>
            <tr>
                <td><%=(us.getPersonaUsuario().getNombre_Persona() + " " +us.getUserName())%></td>
                <td><%=(us.getPersonaUsuario().getPaterno_Persona() +" " + us.getPersonaUsuario().getMaterno_Persona())%></td>
                <td><%=(us.getPersonaUsuario().getDireccionPersona().getPais_Direccion() + " " + us.getPersonaUsuario().getDireccionPersona().getEstado_Direccion())%></td>
                <td><%=(us.getPersonaUsuario().getCorreo_Persona())%></td>
                <td><%=(us.getRolUsuario().getNombre_RolUsuario())%></td>
                <td><button class="btn btn-info enviarEditars" value="<%=i%>">Editar <%=i%></button></td>
            </tr>
             <%
                 }
            %>
        </tbody>
    </table>
</div>

<link href="./Estilos/Usuario/Usuarios.css" rel="stylesheet" type="text/css"/>

            <%
                }
            %>
            
            
            <script src="./Javascript/Usuario/Usuarios.js" type="text/javascript"></script>