<%-- 
    Document   : NuevoUsuario
    Created on : Aug 5, 2020, 12:39:20 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container" id="sals">
                    <div class="tenerOver">
                    <form id="formNuevoUsuarioD">
                        <input type="hidden" name="accion" value="AgregarUsuarioDts"/>
                        <legend>Nuevo Usuario</legend>
                        <fieldset>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control col-8" required="" name="userName" id="userk" placeholder="Ingrese su usuario">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="password" class="form-control col-8" name="pass" id="pass" placeholder="Ingrese su contrasena">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="password" class="form-control col-8" name="ConfPass" id="confPass" placeholder="Repita su contrasena">
                                    </div>
                                </div>
                            </div>

                            
                        <div class="registrarDireccion">
                            <header class="mx-auto"><h2>Registrar dirección</h2></header>
                            <div class="row">

                                <div class="col-3">
                                    <div class="form-group"><label for="estado">País*</label>
                                        <select class="form-control col-md-12 mx-auto BoxText" id="pais" name="Pais" >
                                            <option value="pais">Seleccione País*</option>
                                            <option selected>Mexico</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group"><label for="estado">Estádo*</label>
                                        <select class="form-control col-md-12 BoxText" id="estado" name="Estado">
                                            <option value="estado">Seleccione Estádo</option>
                                            <%       String municipios[] = {"Ciudad de Mexico", "Aguascalientes", "Baja California", "Baja California Sur",
                                                    "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango", "Estado de Mexico",
                                                    "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacan", "Morelos", "Nayarit",
                                                    "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi",
                                                    "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas"};

                                                for (String mun : municipios) {
                                            %>
                                            <option selected><%=mun%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">

                                        <div class="form-group"><label for="municipio">Municipio*</label>
                                            <input type="text" class="form-control" id="municipio" name="Municipio" placeholder="Ingrese su municipio">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="calle">Calle*</label>
                                            <input type="text" class="form-control" id="calle" name="Calle" placeholder="Ingrese su calle">
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="row">

                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="colonia">Colonia*</label>
                                            <input type="type" class="form-control" id="colonia" name="Colonia" placeholder="Ingrese su colonia">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="postal">Código postal*</label>
                                            <input type="text" class="form-control" id="postal" name="Postal" placeholder="Ingrese su codigo postal">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="exterior">Número exterior</label>
                                            <input type="text" class="form-control" id="exterior" name="Exterior" placeholder="Ingrese su exterior">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="interior">Número Interior</label>
                                            <input type="text" class="form-control" id="interior" name="Interior" placeholder="Ingrese su interior">
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                                        
                        <div class="RegistrarPersona">

                            <div class="row">

                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="nombre">Nombre*</label>
                                            <input type="text" class="form-control" id="nombre" placeholder="Ingrese su nombre" name="Nombre">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="paterno">Apellido Paterno*</label>
                                            <input type="text" class="form-control" id="paterno" name="Paterno" placeholder="Ingrese Apellido Paterno">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="materno">Apellido Materno*</label>
                                            <input type="text" class="form-control" id="materno" name="Materno" placeholder="Ingrese Apellido Materno">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label>Fecha de nacimiento*</label>
                                            <input type="date" class="form-control" id="nacimiento" name="Nacimiento">
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="row">


                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="telefono">Teléfono</label>
                                            <input type="text" class="form-control" id="telefono" name="Telefono" placeholder="Ingrese su telefono">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1">Seleccione sexo*</label>
                                        <select class="form-control" id="exampleFormControlSelect1" name="Sexo">
                                            <option value="sex">Seleccione sexo</option>
                                            <option>Hombre</option>
                                            <option>Mujer</option>

                                        </select>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="correo">Correo</label>
                                            <input type="email" class="form-control" id="correo" name="Correo" placeholder="Ingrese su correo">
                                        </div>
                                    </div>
                                </div>
                            <div class="col-3">
                                <div class="form-group"><br/>
                                    <button type="submit" class="btn btn-info dale" id="">
                                        <i class="recorrer"></i>Registrarse
                                    </button>
                                    <div class="agregarSpiner"></div>
                                </div>
                            </div>

                            </div>

                        </div>

                        </fieldset>
                        <div class="row btnRegistrar">

                        </div>
                    </form>
                                        </div>
                </div>
                
                
                
                <script src="./Javascript/Usuario/NuevoUsuario.js" type="text/javascript"></script>
                <link href="./Estilos/Usuario/NuevoUsuario.css" rel="stylesheet" type="text/css"/>
                