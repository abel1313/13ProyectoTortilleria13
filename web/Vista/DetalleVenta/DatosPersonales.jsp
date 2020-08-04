<%-- 
    Document   : DatosPersonales
    Created on : Jul 9, 2020, 4:15:06 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <fieldset>

                <div class="contPersona" id="containerPerson">

                    <legend> <h3>Datos Personales</h3></legend>
                    <%-- ___________________________________________________________________________________________________ --%>        
                    <div class="row"> <%-- Start row Person --%>

                        <div class="col-sm-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="text" required="" value="Abel" minlength="5" class="form-control col-sm-12 BoxText" id="nombreClientObra" name="Nombre" placeholder="Ingrese su Nombre"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                        <div class="col-sm-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="text" required="" value="Tiburcio" minlength="5" class="form-control col-sm-12 BoxText" id="paternoClientObra" name="Paterno" placeholder="Ingrese su Paterno"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                        <div class="col-sm-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="text" required="" value="Felipe" minlength="5" class="form-control col-sm-12 BoxText" id="maternoClientObra" name="Materno" placeholder="Ingrese su Materno"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                    </div> <%-- end row Person --%>
                    <%-- ___________________________________________________________________________________________________ --%>

                    <%-- ___________________________________________________________________________________________________ --%>

                    <div class="row"> <%-- Start row Person --%>

                        <div class="col-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <select type="text" class="form-control col-sm-12 BoxText" required="" id="sexo" name="Sexo">
                                    <option value="sex">Seleccione Sexo</option>
                                    <%
                                        String sexo[] = {"Hombre", "Mujer", "Otro"};
                                        for (String sex : sexo) {
                                    %>
                                    <option selected><%=sex%></option>
                                    <%
                                        }
                                    %>

                                </select>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                        <div class="col-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="text" minlength="10" value="7221111793" maxlength="10" class="form-control col-sm-12 BoxText" id="telefono" name="Telefono" placeholder="Ingrese su telefono"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                        <div class="col-4"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="date" value="13-05-1994" required="" class="form-control col-sm-12 BoxText" id="fechaNacimiento" name="FechaNacimiento"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>

                    </div> <%-- end row Person --%>
                    <%-- ___________________________________________________________________________________________________ --%>

                    <%-- ___________________________________________________________________________________________________ --%>
                    <div class="row"> <%-- Start row Person --%>

                        <div class="col-6"> <%-- Start col Person --%>
                            <div class="form-group"> <%-- Start group Person --%>
                                <input type="email" minlength="10" value="abel@gmail.com" class="form-control col-10 BoxText" id="correo" name="Correo" placeholder="Ingrese su Correo Electronico"/>
                            </div> <%-- end group Person --%>
                        </div> <%-- end col Person --%>




                    </div> <%-- end row Person --%>
                    <%-- ___________________________________________________________________________________________________ --%>        

                </div>

            </fieldset>
                    
                    
