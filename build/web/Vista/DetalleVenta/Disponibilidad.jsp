<%-- 
    Document   : Disponibilidad
    Created on : Jul 8, 2020, 10:50:45 PM
    Author     : trece
--%>

<%@page import="Consultas.ConsultaProducto"%>
<%@page import="MCRUD.CRUD"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Venta"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%
//          CRUD producto= new ConsultaProducto();
     Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(13))
     {
         
//         Producto pr=(Producto)session.getAttribute("productoEncontrado")!=null?
//         (Producto) session.getAttribute("productoEncontrado"):new Producto();
         
ArrayList<Producto> prod = session.getAttribute("producEncontrado") != null ? 
(ArrayList<Producto>) session.getAttribute("producEncontrado") : new ArrayList();


Venta vek =(Venta)session.getAttribute("venta");

%>

     <div class="mostrarCliente">
<%
    
    if(vek.getClienteVenta().getId_Cliente() !=0 )
    {
        
%>  
         <div class="row" id="">

             <div class="col-12">
                 <div class="card text-white bg-dark mb-3" style="display: inline-grid; width: 100%">
                     <div class="card-header"><header>Cliente</header></div>
                     <div class="card-body">

                         <p class="card-text">Nombre Cliente <br/><%=vek.getClienteVenta().getPersonaCliente().getNombre_Persona()%></p>
                        <%
                        if(!vek.getClienteVenta().getPersonaCliente().getTelefono_Persona().equals(""))
                        {
                        %>
                         <p class="card-text"><%=vek.getClienteVenta().getPersonaCliente().getTelefono_Persona()%><br/></p>
                         <%
                             }else{
                         %>
                         <p class="card-text">Sin Telefono</p>
                         <%
                             }
                         %>
                     </div>                                         

                 </div>
             </div>


         </div>
                     <%
                       }
                     %>
   
     </div>
     
                     <div class="mostrarTortillasDisponibles n">
                         <div class="row">
                             <%
                                 for (int i = 0; i < prod.size(); i++) {
                                     Producto pro = prod.get(i);

                             %>
                             <div class="col-12">
                                 <div class="card text-white mb-3" style="display: inline-grid; width: 100%; background-color: #6B7C7C;">
                                     <div class="card-header"><header>Disponibilidad de <%=(pro.getNombre_Producto().toLowerCase())%></header></div>
                                     <div class="card-body">

                                         <p class="card-text"><%=(pro.getExistencias_Producto())%> Kilos <br/></p>


                                     </div>                                         

                                 </div>
                             </div>
                             <%
                                 }
                             %>
                         </div>       
                     </div>
    


<%
    
    }
%>

<script src="./Javascript/DetalleVenta/Disponibilidad.js" type="text/javascript"></script>