<%-- 
    Document   : EditarCliente
    Created on : Aug 6, 2020, 2:20:39 PM
    Author     : trece
--%>

<%@page import="Modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente cl = ((ArrayList<Cliente>)session.getAttribute("clienteListo")).get(Integer.parseInt(request.getParameter("idCliente")));
    session.setAttribute("EditarClienteZ", cl);
%>

<div class="container" id="">
    <div class="tenerOver">
        <form id="formEditarClienteD">
            <input type="hidden" name="accion" value="EditarClienteDts"/>
            
            <fieldset>

                <div class="registrarDireccion">
                    <header class="mx-auto"><h2>Registrar cliente</h2></header>
                    <div class="row">

                        <div class="col-3">
                            <div class="form-group"><label for="estado">País*</label>
                                <select class="form-control col-md-12 mx-auto BoxText" id="pais" name="Pais">
                                    <option value="pais">Seleccione País*</option>
                                    <option selected>Mexico</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group"><label for="estado">Estádo*</label>
                                <select class="form-control col-md-12 BoxText" id="estado" name="Estado">
                                    <option value="estado">Seleccione Estádo</option>
                                    <%     
                                        System.out.println("mun "+ cl.getPersonaCliente().getDireccionPersona().getEstado_Direccion());
                                        System.out.println("mun "+ cl.getPersonaCliente().getDireccionPersona().getPais_Direccion());
                                        
                                        String municipios[] = {"Ciudad de Mexico", "Aguascalientes", "Baja California", "Baja California Sur",
                                            "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango", "Estado de Mexico",
                                            "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacan", "Morelos", "Nayarit",
                                            "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi",
                                            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas"};

                                        for (String mun : municipios) {
                                        if(mun.equals(cl.getPersonaCliente().getDireccionPersona().getEstado_Direccion()))
                                        {
                                            
                                    %>
                                    <option selected><%=mun%></option>
                                    <%
                                        continue;
                                        }
                                    %>
                                    <option><%=mun%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">

                                <div class="form-group"><label for="municipio">Municipio*</label>
                                    <input type="text" class="form-control" id="municipio" name="Municipio" value="<%=(cl.getPersonaCliente().getDireccionPersona().getMunicipio_Direccion())%>" placeholder="Ingrese su municipio">
                                </div>

                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="calle">Calle*</label>
                                    <input type="text" class="form-control" id="calle" name="Calle" value="<%=(cl.getPersonaCliente().getDireccionPersona().getCalle_Direccion())%>" placeholder="Ingrese su calle">
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="colonia">Colonia*</label>
                                    <input type="type" class="form-control" id="colonia" name="Colonia" value="<%=(cl.getPersonaCliente().getDireccionPersona().getColonia_Direccion())%>" placeholder="Ingrese su colonia">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="postal">Código postal*</label>
                                    <input type="text" class="form-control" id="postal" name="Postal" value="<%=(cl.getPersonaCliente().getDireccionPersona().getCodigoPostal_Direccion())%>" placeholder="Ingrese su codigo postal">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="exterior">Número exterior</label>
                                    <input type="text" class="form-control" id="exterior" name="Exterior" value="<%=(cl.getPersonaCliente().getDireccionPersona().getNumeroExterior_Direccion())%>" placeholder="Ingrese su exterior">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="interior">Número Interior</label>
                                    <input type="text" class="form-control" id="interior" name="Interior" value="<%=(cl.getPersonaCliente().getDireccionPersona().getNumeroInterior_Direccion())%>" placeholder="Ingrese su interior">
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
                                    <input type="text" class="form-control" id="nombre" value="<%=(cl.getPersonaCliente().getNombre_Persona())%>" placeholder="Ingrese su nombre" name="Nombre">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="paterno">Apellido Paterno*</label>
                                    <input type="text" class="form-control" id="paterno" name="Paterno" value="<%=(cl.getPersonaCliente().getPaterno_Persona())%>" placeholder="Ingrese Apellido Paterno">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="materno">Apellido Materno*</label>
                                    <input type="text" class="form-control" id="materno" name="Materno" value="<%=(cl.getPersonaCliente().getMaterno_Persona())%>" placeholder="Ingrese Apellido Materno">
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label>Fecha de nacimiento*</label>
                                    <input type="date" class="form-control" id="nacimiento" value="<%=(cl.getPersonaCliente().getFechaNacimiento_Persona())%>" name="Nacimiento">
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">


                        <div class="col-3">
                            <div class="form-group">
                                <div class="form-group"><label for="telefono">Teléfono</label>
                                    <input type="text" class="form-control" id="telefono" name="Telefono" value="<%=(cl.getPersonaCliente().getTelefono_Persona())%>" placeholder="Ingrese su telefono">
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
                                    <input type="email" class="form-control" id="correo" value="<%=(cl.getPersonaCliente().getCorreo_Persona())%>" name="Correo" placeholder="Ingrese su correo">
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
                                
 <script src="./Javascript/Cliente/EditarCliente.js" type="text/javascript"></script>
