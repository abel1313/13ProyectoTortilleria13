<%-- 
    Document   : ActualizarEmpleado
    Created on : 5/08/2020, 08:49:15 PM
    Author     : elver
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
         Usuario usuarioSession =(Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
             response.sendRedirect("../../Vista/Login/Login.jsp");
             
     } 
     if(usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(5))
     {

    Empleado e = ((ArrayList<Empleado>)session.getAttribute("ListaEmpleados")).get(Integer.parseInt(request.getParameter("idEmpleado")));
   // Producto p = ((ArrayList<Producto>)session.getAttribute("listaProducto")).get(Integer.parseInt(request.getParameter("indice")));
    session.setAttribute("editarEmpleadoListo", e);
%>
<div class="container">
    <br>
    <br>
    <div class="container datos" style="overflow-y:scroll; width: 100%; height: 500px;">
    <div class="card">
        <div class="card-header">
            <h2>Actualizar datos empleado...</h2>
        </div>
        <div class="card-body">
            <h5 class="card-title">Datos del empleado Dirección.</h5>
            <form id="formAcEmp">
                <div class="row">
                  <div class="form-group col-md-4">
                        <label for="pais">País:</label>
                        <input type="text" class="form-control" id="pais" name="pais" placeholder="País" value="<%=(e.getPersonaCliente().getDireccionPersona().getPais_Direccion())%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="estado">Estado:</label>
                        <input type="text" class="form-control" id="estado" name="estado" placeholder="Estado" value="<%=(e.getPersonaCliente().getDireccionPersona().getEstado_Direccion())%>">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="muni">Municipio:</label>
                        <input type="text" class="form-control" id="muni" name="muni" placeholder="Municipio" value="<%=(e.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion())%>">
                    </div>   
                </div>
                <div class="row">
                  <div class="form-group col-md-4">
                        <label for="col">Colonia:</label>
                        <input type="text" class="form-control" id="col" name="col" placeholder="Colonia" value="<%=(e.getPersonaCliente().getDireccionPersona().getColonia_Direccion())%>">
                    </div>
                    <div class="form-group col-md-8">
                        <label for="call">Calle:</label>
                        <input type="text" class="form-control" id="call" name="call" placeholder="Calle" value="<%=(e.getPersonaCliente().getDireccionPersona().getCalle_Direccion())%>">
                    </div>    
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="cp">Código Postal:</label>
                        <input type="number" class="form-control" id="cp" name="cp" placeholder="Código Postal" value="<%=(e.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion())%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nex">No Exterior:</label>
                        <input type="number" class="form-control" id="nex" name="nex" placeholder="No Exterior" value="<%=(e.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion())%>">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="nin">No Interior:</label>
                        <input type="number" class="form-control" id="nin" name="nin" placeholder="No Interior" value="<%=(e.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion())%>">
                    </div> 
                </div>
                <br>
                <h5 class="card-title">Datos Personales del Empleado.</h5>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="<%=(e.getPersonaCliente().getNombre_Persona())%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ApPa">Apellido Paterno:</label>
                        <input type="text" class="form-control" id="ApPa" name="ApPa" placeholder="Apellido Paterno" value="<%=(e.getPersonaCliente().getPaterno_Persona())%>">
                    </div>  
                    <div class="form-group col-md-4">
                        <label for="ApMa">Apellido Materno:</label>
                        <input type="text" class="form-control" id="ApMa" name="ApMa" placeholder="Apellido Materno" value="<%=(e.getPersonaCliente().getMaterno_Persona())%>">
                    </div> 
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="fech">Fecha de Nacimiento:</label>
                        <input type="date" class="form-control" id="fech" name="fech" placeholder="Fecha de Nacimiento" value="<%=(e.getPersonaCliente().getFechaNacimiento_Persona())%>">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="Sexo">Sexo:</label>
                        <select class="form-control" id="Sexo" name="Sexo">
                            <%
                                            if (e.getPersonaCliente().getSexo_Persona().equals("Hombre")) {
                                        %>
                                        <option selected="">Hombre</option>
                                        <option>Mujer</option>
                                        <%
                                        } else {
                                        %>
                                        <option selected="">Mujer</option>
                                        <option>Hombre</option>
                                        <%
                                            }
                                        %>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="email">Correo:</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Correo" value="<%=(e.getPersonaCliente().getCorreo_Persona())%>">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="tel">Telefono:</label>
                        <input type="text" class="form-control" id="tel" name="tel" placeholder="Telefono" value="<%=(e.getPersonaCliente().getTelefono_Persona())%>">
                    </div>
                    
                </div>
                <br>
                <h5 class="card-title">Datos del Puesto del Empleado.</h5>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="puesto">Puesto:</label>
                        <input type="text" class="form-control" id="puesto" name="puesto" placeholder="Puesto" value="<%=(e.getPuesto_Empleado())%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="sueldo">Sueldo:</label>
                        <input type="number" class="form-control" id="Sueldo" name="Sueldo" placeholder="Sueldo" value="<%=(e.getSueldoDia_Empleado())%>">
                    </div>  
                </div>

                <br>
                <div class="form-group">
                    <input type="hidden" name="accion" value="actuaizarEmpleado">
                    <button type="submit" class="btn btn-primary " name="btnguardar">Actualizar Empleado</button>
                    <button type="button" id="btncancelar" class="btn btn-secondary gg" >Cancelar</button>
                </div>
            </form>  
        </div>
    </div>
   </div>
</div>
 <script src="./Javascript/Empleado/ActualizarEmpleado.js" type="text/javascript"></script>
                                
                                <%
                                    }
                                %>