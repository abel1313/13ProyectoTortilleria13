<%-- 
    Document   : NuevoUsuario
    Created on : Aug 5, 2020, 12:39:20 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
                <div class="contenedorUsuario">

                    <form id="formNuevoUsuario">
                        <input type="hidden" name="accion" value="AgregarUsuarioDts"/>
                        <legend>Nuevo Usuario</legend>
                        <fieldset>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control col-8 mx-auto" required="" name="userName" id="user" placeholder="Ingrese su usuario">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="password" class="form-control col-8 mx-auto" name="Pass" id="pass" placeholder="Ingrese su contrasena">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="password" class="form-control col-8 mx-auto" name="ConfPass" id="confPass" placeholder="Repita su contrasena">
                                    </div>
                                </div>
                            </div>

                            
                            <div class="datosDir">
                                
                            </div>
                            <div class="datosPer">
                                
                            </div>

                        </fieldset>
                        <div class="row btnRegistrar">
                            <div class="col-12">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-info col-8" id="">Registrarse</button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                
                
                
                <script src="./Javascript/Usuario/NuevoUsuario.js" type="text/javascript"></script>
                <link href="./Estilos/Usuario/NuevoUsuario.css" rel="stylesheet" type="text/css"/>
                