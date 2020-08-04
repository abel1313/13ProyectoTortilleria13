<%-- 
    Document   : DatosDireccion
    Created on : Jul 9, 2020, 4:15:18 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



 <%-- <header><h2>Registrar Cliente</h2></header> --%>
        
        
            <fieldset>
                <legend>Direccion Cliente</legend>


                <input type="hidden" name="action" value="addClientObra"/>
                <div class="contUser animate__animated animate__bounce" id="contDirection">
                    <%-- ___________________________________________________________________________________________________ --%>        
                    <div class="row"> <%-- Start row Direction --%>

                        <div class="col-sm-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <select class="form-control col-md-12 mx-auto BoxText" id="pais" name="Pais" >
                                    <option value="default">Seleccione Pais</option>
                                    <option selected>Mexico</option>
                                </select>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                        <div class="col-sm-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
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
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                        <div class="col-sm-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" required="" value="LLuvianos" class="form-control col-sm-12 BoxText" id="municipio" name="Municipio" placeholder="Ingrese su Municipio"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                    </div> <%-- end row Direction --%>
                    <%-- ___________________________________________________________________________________________________ --%>

                    <%-- ___________________________________________________________________________________________________ --%>

                    <div class="row"> <%-- Start row Direction --%>

                        <div class="col-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" value="Colonia" class="form-control col-sm-12 BoxText" id="calle" name="Calle" placeholder="Ingrese su Calle"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                        <div class="col-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" value="Colonia" class="form-control col-sm-12 BoxText" id="colonia" name="Colonia" placeholder="Ingrese su Colonia"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                        <div class="col-4"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" value="51440" class="form-control col-sm-12 BoxText" id="postal" name="CodigoPostal" placeholder="Ingrese su Codigo Postal"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                    </div> <%-- end row Direction --%>
                    <%-- ___________________________________________________________________________________________________ --%>

                    <%-- ___________________________________________________________________________________________________ --%>
                    <div class="row"> <%-- Start row Direction --%>

                        <div class="col-6"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" value="512" class="form-control col-8 BoxText" id="exterior" name="NumeroExterior" placeholder="Ingrese su Numero Exterior"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>

                        <div class="col-6"> <%-- Start col Direction --%>
                            <div class="form-group"> <%-- Start group Direction --%>
                                <input type="text" value="513" class="form-control col-8 BoxText" id="interior" name="NumeroInterior" placeholder="Ingrese su Numero Interior"/>
                            </div> <%-- end group Direction --%>
                        </div> <%-- end col Direction --%>



                    </div> <%-- end row Direction --%>
                    <%-- ___________________________________________________________________________________________________ --%>        

                </div>


            </fieldset>
          
                    <link href="./Estilos/DetalleVenta/DatosDireccion.css" rel="stylesheet" type="text/css"/>

