<%-- 
    Document   : AgregarUsuario
    Created on : Jul 21, 2020, 10:47:59 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="cssActualizarUsuario">

    <div class="divRegistrarUsuario">

        <form id="formActualizarUsuario">
            <legend>Actualizar Usuario</legend>
            <input type="hidden" name="accion" value="AgregarUsuarioDts">
            <fieldset>
                
                
                <div class="RegistrarUsuarioDts">

                </div>

                <div class="RegistrarPersona">

                    <div class="divDtsUsuario">
                        <div class="row">
                            <div class="col-6">

                                <div class="form-group"><label for="userName">Nuevo User Name</label>
                                    <input type="text" class="form-control col-10" id="userName" placeholder="Ingrese nuevo User Name" name="UsrName">
                                </div>

                            </div>
                            <div class="col-6">
                                <div class="form-check">

                                    <input class="form-check-input" type="checkbox" value="" name="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        Cambiar Contrasena
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="row divCambContrUsuario">
                            <div class="col-3">

                                <div class="form-group"><label for="pass">Nueva Contrasena</label>
                                    <input type="text" class="form-control" id="pass" placeholder="Nueva Contrasena" name="NuevaContra">
                                </div>

                            </div>
                            <div class="col-3">

                                <div class="form-group"><label for="conpass">Confirma Contrasena</label>
                                    <input type="text" class="form-control" id="pass" placeholder="Confirma Contrasena" name="ConPass">
                                </div>

                            </div>

                        </div>
                    </div>


                    <div class="dtsPersonaUsuario">
                    <div class="row">


                        <div class="col-4">
                            <div class="form-group">
                                <div class="form-group"><label for="nombre">Ingrese su nombre</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="Ingrese su nombre" name="Nombre">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <div class="form-group"><label for="paterno">Ingrese Apellido Paterno</label>
                                    <input type="text" class="form-control" id="paterno" name="Paterno" placeholder="Ingrese Apellido Paterno">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <div class="form-group"><label for="materno">Ingrese Apellido Materno</label>
                                    <input type="text" class="form-control" id="materno" name="Materno" placeholder="Ingrese Apellido Materno">
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label>Fecha de nacimiento</label>
                                    <input type="date" class="form-control" id="nacimiento" name="Nacimiento">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="telefono">Ingrese su telefono</label>
                                    <input type="text" class="form-control" id="telefono" name="Telefono" placeholder="Ingrese su telefono">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">Seleccione sexo</label>
                                <select class="form-control" id="exampleFormControlSelect1" name="Sexo">
                                    <option value="sex">Seleccione sexo</option>
                                    <option>Hombre</option>
                                    <option>Mujer</option>

                                </select>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="correo">Ingrese su correo</label>
                                    <input type="email" class="form-control" id="correo" name="Correo" placeholder="Ingrese su correo">
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
                                    <input type="text" class="form-control" id="pais" name="Pais" placeholder="Ingrese su pais">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="estado">Ingrese su estado</label>
                                    <input type="text" class="form-control" id="estado" name="Estado" placeholder="Ingrese su estado">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">

                                <div class="form-group"><label for="municipio">Ingrese su municipio</label>
                                    <input type="text" class="form-control" id="municipio" name="Municipio" placeholder="Ingrese su municipio">
                                </div>

                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="calle">Ingrese su calle</label>
                                    <input type="text" class="form-control" id="calle" name="Calle" placeholder="Ingrese su calle">
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="colonia">Ingrese su colonia</label>
                                    <input type="type" class="form-control" id="colonia" name="Colonia" placeholder="Ingrese su colonia">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="postal">Ingrese su codigo postal</label>
                                    <input type="text" class="form-control" id="postal" name="Postal" placeholder="Ingrese su codigo postal">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="exterior">Ingrese su exterior</label>
                                    <input type="text" class="form-control" id="exterior" name="Exterior" placeholder="Ingrese su exterior">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="interior">Ingrese su interior</label>
                                    <input type="text" class="form-control" id="interior" name="Interior" placeholder="Ingrese su interior">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <button type="submit" class="btn btn-info">Terminar Registro</button>
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
