<%-- 
    Document   : EditarProducto
    Created on : Jul 31, 2020, 12:41:00 AM
    Author     : trece
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
         Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(9))
     {

    Producto p = ((ArrayList<Producto>)session.getAttribute("listaProducto")).get(Integer.parseInt(request.getParameter("indice")));
    session.setAttribute("editarProducto", p);
%>
 <div class="card mx-auto" style="width: 50rem;">
        <div class="card-header">
           Editar Tortíllas
        </div>
        <div class="card-body">
            <h5 class="card-title">Realizar las mejores descripciones posibles</h5>

            <form id="formEditarProducto">
                <input type="hidden" name="accion" value="editarProducto">
                <fieldset>
                    <legend>Producto disponible</legend>
                    <div class="row">
                        <div class="col-3">
                            <div class="form-group">
                                <label for="nameService">Ingrese nombre del producto
                                    <input type="text" required="" class="form-control" value="<%=(p.getNombre_Producto())%>" name="nameService" id="NameService" placeholder="Ingrese nombre del producto">
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="descriptionService">Ingrese la descripcion del producto
                                    <textarea cols="20" rows="3" class="form-control" name="DescriptionService" id="descriptionService" placeholder="Ingrese la descripcion del producto"><%=(p.getDescipcion_Producto())%></textarea>
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="precioService">Ingrese el precio por kilo
                                    <input type="text" class="form-control" name="PrecioService" value="<%=(p.getPrecio_Producto())%>" id="precioService" placeholder="Ingrese el precio por kilo" min="1" onkeypress="return filterFloat(event, this);" >
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="kilosDisponibles">Ingrese kilos disponibles
                                    <input type="text" class="form-control" name="KilosDisponibles" value="<%=(p.getExistencias_Producto())%>" id="kilosDisponibles" placeholder="Ingrese kilos disponibles" min="1" onkeypress="return filterFloat(event, this);" >
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <button type="submit" class="btn btn-info form-control col-6" style="margin-left: 25%;" id="">Editar producto</button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>

        </div>

    </div>
                                
                                <script src="./Javascript/Producto/EditarProducto.js" type="text/javascript"></script>
                                
                                <%
                                    }
                                %>