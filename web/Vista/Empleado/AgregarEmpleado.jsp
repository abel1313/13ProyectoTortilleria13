<%-- 
    Document   : AgregarEmpleado
    Created on : 5/08/2020, 02:23:51 PM
    Author     : elver
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getSession().getAttribute("us") == null) {
        response.sendRedirect("../../View/Login.jsp");
    }
    if (request.getSession().getAttribute("us") != null
            && ((Usuario) request.getSession().getAttribute("us")).getRolUsuario().getPermisos().contains(5)) {
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
<div class="container">
    <br>
    <br>
    <div class="container datos" style="overflow-y:scroll; width: 100%; height: 500px;">
    <div class="card">
        <div class="card-header">
            <h2>Agregando un nuevo empleado...</h2>
        </div>
        <div class="card-body">
            <h5 class="card-title">Datos del empleado Dirección.</h5>
            <form id="formEmp">
                <div class="row">
                  <div class="form-group col-md-4">
                        <label for="pais">País:</label>
                        <input type="text" class="form-control" id="pais" name="pais" placeholder="País">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="estado">Estado:</label>
                        <input type="text" class="form-control" id="estado" name="estado" placeholder="Estado">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="muni">Municipio:</label>
                        <input type="text" class="form-control" id="muni" name="muni" placeholder="Municipio">
                    </div>   
                </div>
                <div class="row">
                  <div class="form-group col-md-4">
                        <label for="col">Colonia:</label>
                        <input type="text" class="form-control" id="col" name="col" placeholder="Colonia">
                    </div>
                    <div class="form-group col-md-8">
                        <label for="call">Calle:</label>
                        <input type="text" class="form-control" id="call" name="call" placeholder="Calle">
                    </div>    
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="cp">Código Postal:</label>
                        <input type="number" class="form-control" id="cp" name="cp" placeholder="Código Postal">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nex">No Exterior:</label>
                        <input type="number" class="form-control" id="nex" name="nex" placeholder="No Exterior">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="nin">No Interior:</label>
                        <input type="number" class="form-control" id="nin" name="nin" placeholder="No Interior">
                    </div> 
                </div>
                <br>
                <h5 class="card-title">Datos Personales del Empleado.</h5>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ApPa">Apellido Paterno:</label>
                        <input type="text" class="form-control" id="ApPa" name="ApPa" placeholder="Apellido Paterno">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="ApMa">Apellido Materno:</label>
                        <input type="text" class="form-control" id="ApMa" name="ApMa" placeholder="Apellido Materno">
                    </div> 
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="fech">Fecha de Nacimiento:</label>
                        <input type="date" class="form-control" id="fech" name="fech" placeholder="Fecha de Nacimiento">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="Sexo">Sexo:</label>
                        <select class="form-control" id="Sexo" name="Sexo">
                            <option>Hombre</option>
                            <option>Mujer</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="email">Correo:</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Correo">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="tel">Telefono:</label>
                        <input type="text" class="form-control" id="tel" name="tel" placeholder="Telefono">
                    </div>
                    
                </div>
                <br>
                <h5 class="card-title">Datos del Puesto del Empleado.</h5>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="puesto">Puesto:</label>
                        <input type="text" class="form-control" id="puesto" name="puesto" placeholder="Puesto">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="sueldo">Sueldo:</label>
                        <input type="number" class="form-control" id="Sueldo" name="Sueldo" placeholder="Sueldo">
                    </div>  
                </div>

                <br>
                <div class="form-group">
                    <input type="hidden" name="accion" value="agregarEmp">
                    <button type="submit" class="btn btn-primary " name="btnguardar">Guardar Empleado</button>
                    <button type="button" id="btncancelar" class="btn btn-secondary gg" >Cancelar</button>
                </div>
            </form>  
        </div>
    </div>
   </div>
</div>
<%
    }
%>

<script src="./Javascript/Empleado/AgregarEmpleado.js" type="text/javascript"></script>