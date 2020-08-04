<%-- 
    Document   : TodosClientes
    Created on : Jul 10, 2020, 8:05:28 PM
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

         <div class="row" id="">

             <%
                 for (int i = 0; i < clientes.size(); i++) {
                         Cliente c=(Cliente)clientes.get(i);
                     
             %>
             <div class="col-3">
                 <div class="card text-white bg-dark mb-3" style="display: inline-grid; width: 100%">
                     <div class="card-header"><header>Cliente</header></div>
                     <div class="card-body">

                         <p class="card-text">Nombre Cliente <%=(c.getPersonaCliente().getNombre_Persona())%></p>
                         <p class="card-text">Apellidos <br/><%=(c.getPersonaCliente().getPaterno_Persona() +" "+c.getPersonaCliente().getMaterno_Persona() )%></p>
 
                          
                          <button type="button" class="btn btn-light agregarClienteEncontrado" value="<%=i%>">Agregar</button>
                          
                     </div>                                         

                 </div>
             </div>
             <%
                 }
             %>

         </div>

<script src="./Javascript/Cliente/TodosClientes.js" type="text/javascript"></script>

<%
    }
%>