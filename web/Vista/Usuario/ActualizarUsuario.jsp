<%-- 
    Document   : ActualizarUsuario
    Created on : Jul 20, 2020, 9:22:46 PM
    Author     : trece
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

Usuario usrs = ((ArrayList<Usuario>)session.getAttribute("UsuarioListo")).get(Integer.parseInt(request.getParameter("idUsuario")));
session.setAttribute("usuarioListoActualizar", usrs);

%>
<style>
    .cssActualizarUsuario{
        width: 100vw;
    }
</style>
<div class="cssActualizarUsuario">

    <div class="divRegistrarUsuario">

        <form id="formActUsu">
            <legend>Actualizar Usuario</legend>
            <input type="hidden" name="accion" value="ActualizarUsuarioDts">
            <fieldset>


                <div class="RegistrarUsuarioDts">

                </div>

                <div class="RegistrarPersona">
                    <div class="row">

                        <div class="col-6">
                            <div class="form-check">

                                <input class="form-check-input" type="checkbox" value="true" name="DtsPersonales" id="dtsPersonales">
                                <label class="form-check-label" for="dtsPersonales">
                                    Datos Personales del Usuario
                                </label>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-check">

                                <input class="form-check-input" type="checkbox" value="true" name="DtsDireccion" id="dtsDirecion">
                                <label class="form-check-label" for="dtsDirecion">
                                    Direccion del Usuario
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="divDtsUsuario">
                        <div class="row">
                            <div class="col-6">

                                <div class="form-group"><label for="userName">Nuevo User Name</label>
                                    <input type="text" class="form-control col-8" id="userName" value="<%=(usrs.getUserName())%>"  placeholder="Ingrese nuevo User Name" name="UsrName">
                                </div>

                            </div>
                            <div class="col-6">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="true" name="cambiarPass" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        Cambiar Contrasena
                                    </label>

                                </div>

                            </div>
                        </div>

                        <div class="row divCambContrUsuario">
                            <div class="col-3">

                                <div class="form-group"><label for="pass">Nueva Contrasena</label>
                                    <input type="password" class="form-control" id="pass" placeholder="Nueva Contrasena" name="NuevaContra">
                                </div>

                            </div>
                            <div class="col-3">

                                <div class="form-group"><label for="conpass">Confirma Contrasena</label>
                                    <input type="password" class="form-control" id="pass" placeholder="Confirma Contrasena" name="ConPass">
                                </div>

                            </div>

                        </div>
                    </div>


                    <div class="dtsPersonaUsuario">
                        <div class="row">


                            <div class="col-4">
                                <div class="form-group">
                                    <div class="form-group"><label for="nombre">Ingrese su nombre</label>
                                        <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getNombre_Persona())%>" id="nombre" placeholder="Ingrese su nombre" name="Nombre">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="form-group">
                                    <div class="form-group"><label for="paterno">Ingrese Apellido Paterno</label>
                                        <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getPaterno_Persona())%>" id="paterno" name="Paterno" placeholder="Ingrese Apellido Paterno">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="form-group">
                                    <div class="form-group"><label for="materno">Ingrese Apellido Materno</label>
                                        <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getMaterno_Persona())%>" id="materno" name="Materno" placeholder="Ingrese Apellido Materno">
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="row">

                            <div class="col-3">
                                <div class="form-group">
                                    <div class="form-group"><label>Fecha de nacimiento</label>
                                        <input type="date" value="<%=(usrs.getPersonaUsuario().getFechaNacimiento_Persona())%>" class="form-control" id="nacimiento" name="Nacimiento">
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-group">
                                    <div class="form-group"><label for="telefono">Ingrese su telefono</label>
                                        <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getTelefono_Persona())%>" id="telefono" name="Telefono" placeholder="Ingrese su telefono">
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Seleccione sexo</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="Sexo">
                                        <option value="sex">Seleccione sexo</option>


                                        <%
                                            if (usrs.getPersonaUsuario().getSexo_Persona().equals("Hombre")) {
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
                            </div>
                            <div class="col-3">
                                <div class="form-group">
                                    <div class="form-group"><label for="correo">Ingrese su correo</label>
                                        <input type="email" value="<%=(usrs.getPersonaUsuario().getCorreo_Persona())%>" class="form-control" id="correo" name="Correos" placeholder="Ingrese su correo">
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>

                <div class="registrarDireccion">
                    <header>Registrar su Direccion</header>
                    <div class="row">

                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label>Pais</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getPais_Direccion())%>" id="pais" name="Pais" placeholder="Ingrese su pais">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="estado">Ingrese su estado</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getEstado_Direccion())%>" id="estado" name="Estado" placeholder="Ingrese su estado">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">

                                <div class="form-group"><label for="municipio">Ingrese su municipio</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getMunicipio_Direccion())%>" id="municipio" name="Municipio" placeholder="Ingrese su municipio">
                                </div>

                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="calle">Ingrese su calle</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getCalle_Direccion())%>" id="calle" name="Calle" placeholder="Ingrese su calle">
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="colonia">Ingrese su colonia</label>
                                    <input type="type" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getColonia_Direccion())%>" id="colonia" name="Colonia" placeholder="Ingrese su colonia">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="postal">Ingrese su codigo postal</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getCodigoPostal_Direccion())%>" id="postal" name="Postal" placeholder="Ingrese su codigo postal">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="exterior">Ingrese su exterior</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getNumeroExterior_Direccion())%>" id="exterior" name="Exterior" placeholder="Ingrese su exterior">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="interior">Ingrese su interior</label>
                                    <input type="text" class="form-control" value="<%=(usrs.getPersonaUsuario().getDireccionPersona().getNumeroInterior_Direccion())%>" id="interior" name="Interior" placeholder="Ingrese su interior">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <button type="submit" class="btn btn-info l">Terminar Registro</button>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <button type="button" class="btn btn-info cancerarRegistro">Cancelar</button>
                        </div>
                    </div>
                </div>

            </fieldset>
        </form>

    </div>

</div>

<link href="./Estilos/Login/Registrar.css" rel="stylesheet" type="text/css"/>
<script src="./Javascript/Usuario/ActualizarUsuario.js" type="text/javascript"></script>
<script src="./Javascript/Usuario/ActualizandoUsuario.js" type="text/javascript"></script>
