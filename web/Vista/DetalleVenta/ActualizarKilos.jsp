<%-- 
    Document   : ActualizarKilos
    Created on : Aug 3, 2020, 12:41:51 AM
    Author     : trece
--%>

<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//          CRUD producto= new ConsultaProducto();
    Usuario usuarioSession = (Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
        response.sendRedirect("../../Vista/Login/Login.jsp");

    }
    if (usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(13)) {
        ArrayList<Producto> prod = session.getAttribute("producEncontrado") != null
                ? (ArrayList<Producto>) session.getAttribute("producEncontrado") : new ArrayList();

%>

<%                         if (usuarioSession.getRolUsuario().getId_RolUduario() == 1) {

%>

<div class="mostrarTortillasDisponibles nuev">


    <div class="Mensaje">

    </div>
    <%                                     for (int i = 0; i < prod.size(); i++) {
            Producto pr = prod.get(i);
            if (pr.getExistencias_Producto() <= 15) {
    %>
    <div class="row">

        <div class="col-12">
            <div class="card text-white mb-3" style="display: inline-grid; width: 100%; background-color: #6B7C7C;">
                <div class="card-header"><header>Actualizar producto</header></div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group"><label for="actualizarProducto" id="errorCantidad"></label>
                                <input type="text" class="form-control" name="" id="actualizarProducto" placeholder="Actualizar producto">
                                <button class="btn btn-dark btn-block actualozaProducto">Actualizar producto</button>
                            </div>
                        </div>
                    </div>
                </div>                                         

            </div>
        </div>

    </div>  
    <%
            }
        }
    %>
</div>

<%
        }
    }
%>