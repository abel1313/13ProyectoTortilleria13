<%-- 
    Document   : TodosClientes
    Created on : Jul 10, 2020, 8:05:28 PM
    Author     : trece
--%>

<%@page import="Consultas.ConsultaCliente"%>
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

<table class="table" style=" color: whitesmoke !important; ">
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
                <button type="button" class="btn btn-light agregarClienteEncontrado" value="<%=i%>">Agregar</button>
            </td>
        </tr>
                <%
                 }
             %>
    </tbody>
</table>



<script src="./Javascript/Cliente/TodosClientes.js" type="text/javascript"></script>

<%
    }
%>