<%-- 
    Document   : Empleados
    Created on : 4/08/2020, 09:51:57 PM
    Author     : elver
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        Usuario usuarioSesion =(Usuario)session.getAttribute("us");
        if (usuarioSesion != null && usuarioSesion.getRolUsuario().getPermisos().contains(5)) 
        {
            
ArrayList<Empleado>empleadosArray = session.getAttribute("ListaEmpleados") !=null ? 
(ArrayList<Empleado>)session.getAttribute("ListaEmpleados"):new ArrayList();
session.setAttribute("EmpleadoListo", empleadosArray);
%>
<div class="tablaEmpleados container-fluid">
    <table class="table table-info">
        <thead>
            <tr>
                <th>Empleado</th>
                <th>Puesto</th>
                <th>Sueldo Día</th>
                <th>Accion</th>

            </tr>
        </thead>
        <tbody>
            <%
            for(int i = 0; i<empleadosArray.size(); i++)
            {
                Empleado em = empleadosArray.get(i);
            %>
            <tr>
                <td><%=(em.getPersonaCliente().getNombre_Persona()+" "+em.getPersonaCliente().getPaterno_Persona()+" "+em.getPersonaCliente().getMaterno_Persona())%></td>
                <td><%=(em.getPuesto_Empleado())%></td>
                <td><%=(em.getSueldoDia_Empleado())%></td>
                <td><button class="btn btn-info enviarEditars" value="<%=i%>">Editar</button></td>
            </tr>
             <%
                 }
            %>
        </tbody>
    </table>
</div>

<link href="./Estilos/Empleado/Empleados.css" rel="stylesheet" type="text/css"/>

            <%
                }
            %>
            
            
            <script src="./Javascript/Empleado/Empleados.js" type="text/javascript"></script>