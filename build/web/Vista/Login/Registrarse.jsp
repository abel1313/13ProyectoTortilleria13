<%-- 
    Document   : Registrarse
    Created on : Jul 18, 2020, 7:47:35 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getSession().getAttribute("us") != null) {
        response.sendRedirect("../../index.jsp");
    }
    if (request.getSession().getAttribute("us") == null) {
%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <!-- Bootstrap CSS -->
        <!--    <meta name="google-signin-scope" content="profile email">-->

        <meta name="google-signin-client_id" content="331670075591-i8qluf5rffepumk3a8v00r2n0qfvqs38.apps.googleusercontent.com">


        <!--   <div id="fb-root"></div>-->
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v7.0&appId=301435451261805&autoLogAppEvents=1" nonce="uMB2DoIg"></script>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--        <link href="../../Estilos/Login/Login.css" rel="stylesheet" type="text/css"/>-->




        <title>Registrarse</title>

    </head>
    <body>




        <div class="contenedorPrincipal">

            <div class="contenedorHeader">
                <header><h1 class="">"Tortillería La Salida"</h1></header>
            </div>
            <div class="contenedorBody">

                <div class="contenedorLogin">

                    <form id="formPreRegistro">
                        <legend>Registrarse</legend>
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
                            <div class="row btnRegistrar">
                                <div class="col-12">
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-info col-8" id="">Registrarse</button>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group" id="">

                                    </div>
                                </div>
                            </div>                
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">

                                        <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                        </fb:login-button>
                                        <div id="status">
                                        </div>
                                    </div>
                                </div>
                            </div>  

                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">

                                        <div id="my-signin2"></div>
                                    </div>
                                </div>
                            </div>  
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <div class="irSesion">Si ya tienes cuenta <a href="#">Iniciar Sesión</a></div>
                                    </div>
                                </div>
                            </div>  


                        </fieldset>
                    </form>


                </div>

                <div class="contenedorDialogo">

                    <div class="img-Tort">

                    </div>

                </div>

            </div>



            <div class="contenedorFooter">

            </div>

        </div>
        <div class="registrarUsuario">

            <div class="divRegistrarUsuario">

                <form id="formRegistrarUsuario">
                    <legend>Terminar registro</legend>
                    <input type="hidden" name="accion" value="AgregarUsuarioDts">
                    <input type="hidden" name="userName" id="userName">
                    <input type="hidden" name="pass" id="passUser">

                    <fieldset>

                        <div class="RegistrarUsuarioDts">

                        </div>

                        <div class="RegistrarPersona">

                            <div class="row">

                                <div class="col-4">
                                    <div class="form-group">
                                        <div class="form-group"><label for="nombre">Nombre</label>
                                            <input type="text" class="form-control" id="nombre" placeholder="Ingrese su nombre" name="Nombre">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="form-group">
                                        <div class="form-group"><label for="paterno">Apellido Paterno</label>
                                            <input type="text" class="form-control" id="paterno" name="Paterno" placeholder="Ingrese Apellido Paterno">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="form-group">
                                        <div class="form-group"><label for="materno">Apellido Materno</label>
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
                                        <div class="form-group"><label for="telefono">Teléfono</label>
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

                        <div class="registrarDireccion">
                            <header class="mx-auto"><h2>Registrar dirección</h2></header>
                            <div class="row">

                                <div class="col-3">
                                    <div class="form-group"><label for="estado">País</label>
                                        <select class="form-control col-md-12 mx-auto BoxText" id="pais" name="Pais" >
                                            <option value="pais">Seleccione País</option>
                                            <option selected>Mexico</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group"><label for="estado">Estádo</label>
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

                                        <div class="form-group"><label for="municipio">Municipio</label>
                                            <input type="text" class="form-control" id="municipio" name="Municipio" placeholder="Ingrese su municipio">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="calle">Calle</label>
                                            <input type="text" class="form-control" id="calle" name="Calle" placeholder="Ingrese su calle">
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="row">

                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="colonia">Colonia</label>
                                            <input type="type" class="form-control" id="colonia" name="Colonia" placeholder="Ingrese su colonia">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <div class="form-group"><label for="postal">código postal</label>
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
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-info trmReg">Terminar Registro</button>
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







        <link href="../../Estilos/Login/Registrar.css" rel="stylesheet" type="text/css"/>
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
        <script src="../../Javascript/Login/Registrar.js" type="text/javascript"></script>

        <script>

            function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
                console.log('statusChangeCallback');
                console.log(response);                   // The current login status of the person.
                if (response.status === 'connected') {
                    datPer();
                    // Logged into your webpage and Facebook.
                    testAPI();
                } else {                                 // Not logged into your webpage or we are unable to tell.
                    document.getElementById('status').innerHTML = 'Please log ' +
                            'into this webpage.';
                }
            }


            function checkLoginState() {               // Called when a person is finished with the Login Button.
                FB.getLoginStatus(function (response) {   // See the onlogin handler
                    statusChangeCallback(response);
                });
            }


            window.fbAsyncInit = function () {
                FB.init({
                    appId: '{301435451261805}',
                    cookie: true, // Enable cookies to allow the server to access the session.
                    xfbml: true, // Parse social plugins on this webpage.
                    version: '{v7.0}'           // Use this Graph API version for this call.
                });


                FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
                    statusChangeCallback(response);        // Returns the login status.
                });
            };
            //2049083958556701
            //2049083958556701
            //3997112000359567

            function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
                console.log('Welcome!  Fetching your information.... ');
                FB.api('/me', {"fields": "email,first_name,last_name,id,gender"}, function (response) {
                    //      console.log('Successful login for: ' + response.name);
                    //      console.log('Successful login for: ' + response.id);
                    //      console.log('Successful login for: ' + response.email);
                    //      console.log('Successful login for: ' + response.last_name);
                    document.getElementById('status').innerHTML =
                            'Thanks for logging in, ' + response.name + '!';
                });
            }

            function datPer() {

                FB.api(
                        '/me',
                        'GET',
                        {"fields": "email,first_name,last_name,id,gender"},
                        function (response) {
                            usrNombre = response.first_name;
                            usrApellidos = response.last_name;
                            usrCorreo = response.email;
                            usrID = response.id;

                            $('#nombre').val(usrNombre);
                            $('#paterno').val(usrApellidos);
                            $('#correo').val(usrCorreo);

                            $('.registrarUsuario').css({"display": "block"});



                        }
                );

            }
            function onSuccess(googleUser) {

                console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
                var profile = googleUser.getBasicProfile();
                //        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                //        console.log('Full Name: ' + profile.getName());
                //        console.log('Given Name: ' + profile.getGivenName());
                //        console.log('Family Name: ' + profile.getFamilyName());

                console.log("Email: " + profile.getEmail());

                $('#nombre').val(profile.getName());
                $('#paterno').val(profile.getGivenName());
                $('#correo').val(profile.getEmail());

                $('.registrarUsuario').css({"display": "block"});
            }
            function onFailure(error) {
                console.log(error);
            }
            function renderButton() {
                gapi.signin2.render('my-signin2', {
                    'scope': 'profile email',
                    'width': 190,
                    'height': 30,
                    'longtitle': true,
                    'theme': 'dark',
                    'onsuccess': onSuccess,
                    'onfailure': onFailure
                });
            }






        </script>




        <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>

        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>



        <script src="../../Javascript/jQuery/js/jquery.validate.js" type="text/javascript"></script>
        <script src="../../Javascript/jQuery/js/jQueryValidarCampos.js" type="text/javascript"></script>
        <script src="../../Javascript/Login/Registrar.js" type="text/javascript"></script>



        <!--    <script src="../../Javascript/Login/Login.js" type="text/javascript"></script>-->
        <!--    <script src="../../Javascript/Login/LoginGoogle.js" type="text/javascript"></script>-->
        <!--    <script src="../../Javascript/Login/LoginFacebook.js" type="text/javascript"></script>-->

    </body>
</html>


<%
    }
%>

