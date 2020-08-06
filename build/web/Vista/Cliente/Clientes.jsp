<%-- 
    Document   : Clientes
    Created on : Aug 6, 2020, 12:55:25 PM
    Author     : trece
--%>

<%@page import="Modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuarioSesion =(Usuario)session.getAttribute("us");
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(1)) 
        {
            
ArrayList<Cliente>clientes = session.getAttribute("cliente") !=null ? 
(ArrayList<Cliente>)session.getAttribute("cliente"):new ArrayList();
session.setAttribute("clienteListo", clientes);
%>
<div style="">
    <table class="table">
    <thead>
        <tr>
            <th>Nombre cliente</th>
            <th>Apellidos cliente</th>
            <th>Acción</th>
        </tr>
    </thead>
    <tbody>
                     <%
                 for (int i = 0; i < clientes.size(); i++) {
                         Cliente c=(Cliente)clientes.get(i);
                     
             %>
        <tr>
            <td><%=(c.getPersonaCliente().getNombre_Persona())%></td>
            <td><%=(c.getPersonaCliente().getPaterno_Persona() +" "+c.getPersonaCliente().getMaterno_Persona() )%></td>
            <td>
                <button type="button" class="btn btn-light editarCCliente" value="<%=i%>">Editar</button>
            </td>
        </tr>
                <%
                 }
             %>
    </tbody>
</table>
</div>


<script src="./Javascript/Cliente/Clientes.js" type="text/javascript"></script>

<%
    }
%>
