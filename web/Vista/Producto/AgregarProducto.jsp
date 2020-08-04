<%-- 
    Document   : AgregarProducto
    Created on : Jul 30, 2020, 9:47:37 PM
    Author     : trece
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (request.getSession().getAttribute("us") == null) {
        response.sendRedirect("../../View/Login.jsp");
    }
    if (request.getSession().getAttribute("us") != null
            && ((Usuario) request.getSession().getAttribute("us")).getRolUsuario().getPermisos().contains(9)) {
%>
<%

%>

<%       
    if (session.getAttribute("Mensaje") != null) {
%>
<div class="mensajeUsuariox mx-auto" id="" style="width: 50rem;">

    <div class="alert alert-info" role="alert">
        <button type="button" class="close" data-dismiss="alert">&times;</button>

        <h3><%= session.getAttribute("Mensaje").toString()%> </h3>

    </div>
</div>
<%

        session.removeAttribute("Mensaje");

    }
%> 
<div class="">

    <div class="card mx-auto" style="width: 50rem;">
        <div class="card-header">
            Tortíllas
        </div>
        <div class="card-body">
            <h5 class="card-title">Realizar las mejores descripciones posibles</h5>

            <form id="formAgregarProducto">
                <input type="hidden" name="accion" value="agregarProducto">
                <fieldset>
                    <legend>Producto disponible</legend>
                    <div class="row">
                        <div class="col-3">
                            <div class="form-group">
                                <label for="nameService">Ingrese nombre del producto
                                    <input type="text" required="" class="form-control" name="nameService" id="NameService" placeholder="Ingrese nombre del producto">
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="descriptionService">Ingrese la descripcion del producto
                                    <textarea cols="20" rows="3" class="form-control" name="DescriptionService" id="descriptionService" placeholder="Ingrese la descripcion del producto"></textarea>
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="precioService">Ingrese el precio por kilo
                                    <input type="text" class="form-control" name="PrecioService" id="precioService" placeholder="Ingrese el precio por kilo" min="1" onkeypress="return filterFloat(event, this);" >
                                </label>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="kilosDisponibles">Ingrese kilos disponibles
                                    <input type="text" class="form-control" name="KilosDisponibles" id="kilosDisponibles" placeholder="Ingrese kilos disponibles" min="1" onkeypress="return filterFloat(event, this);" >
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <button type="submit" class="btn btn-info form-control col-6" style="margin-left: 25%;" id="">Agregar producto</button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>

        </div>

    </div>

</div>




<%
    }
%>

<script src="./Javascript/Producto/AgregarProducto.js" type="text/javascript"></script>


