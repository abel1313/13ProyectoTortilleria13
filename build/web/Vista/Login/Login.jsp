<%-- 
    Document   : Login
    Created on : Jul 4, 2020, 7:51:33 PM
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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Pragma" content="no-cache"> 
        <meta http-equiv="Cache-Control"  content="no-cache"> 
        <meta http-equiv="Expires" content="Sat, 01 Dec 2012 00:00:00 GMT"> 
        <meta name="google-signin-client_id" content="331670075591-i8qluf5rffepumk3a8v00r2n0qfvqs38.apps.googleusercontent.com">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="../../Estilos/Login/Login.css" rel="stylesheet" type="text/css"/>




        <title>Index</title>

    </head>
    <body>




        <div class="contenedorPrincipal">

            <div class="contenedorHeader">
                <header><h1>"Tortillería La Salida13"</h1></header>
            </div>
            <div class="contenedorBody">

                <div class="contenedorLogin">
                    <header><h2>Inicio de Sesión</h2></header>
                    <div class="">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="idUsuario">Ingrese Usuario</label>
                                <input type="text" class="form-control" name="Usuario" id="idUsuario" placeholder="Usuario">
                            </div>
                        </div>
                    </div>
                    <div class="">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="idUsuario">Ingrese Contraseña</label>
                                <input type="password" class="form-control" name="Contrasena" id="idContrasena" placeholder="Contraseña">
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="col-12">
                            <div class="form-group">
                                <button class="btn btn-info btnIniciarSession btn-block" value="Normal">
                                    <i class=" iIniciarSesion"></i>Iniciar Sesión
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="filaGoogle">
                        <div class="col-12">
                            <div class="form-group" id="">
                                <button id="my-signin2" class="btnIniciarSessionGoggle col-8 btn-block" value="Google">

                                </button>
                            </div>
                        </div>
                    </div>                
                    <div class="filaGoogle">
                        <div class="col-12">
                            <div class="form-group">
                                <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                </fb:login-button>

                                <div id="status">
                                </div>

                            </div>
                        </div>
                    </div>  

                    <div id="mensaje" >
                        <%if (session.getAttribute("Mensaje") != null) {


                        %>

                        <h3 style="color: red;font-size: 1em; text-align: center;"><%=(session.getAttribute("Mensaje").toString())%></h3>

                        <%
                                session.removeAttribute("Mensaje");
                            }
                        %>
                    </div>
                    <div class="registrarse">
                        <div class="col-12">
                            <div class="form-group">
                                <p>¿No tiene cuenta?<a href="#">Registrarse</a></p>

                            </div>
                        </div>
                    </div>

                </div>

                <div class="contenedorDialogo">

                    <div class="img-Tort">

                    </div>

                </div>

            </div>



            <div class="contenedorFooter">

            </div>

        </div>





        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v7.0&appId=301435451261805&autoLogAppEvents=1" nonce="OjHG1puq"></script>


        <script>

            function InicioSesionGoogle(correoElectronico)
            {
                $.ajax({
                    type: 'POST',
                    url: '../../DatosUsuario',
                    data: {accion: "accederSistema", userName: $('#idUsuario').val(), contra: $('#idContrasena').val(),correoElect:correoElectronico},
                    success: function (rec) {
                        location.reload();


                    },
                    error: function (xhr, status) {
                        //                console.log('Disculpe, existió un problema');
                    },

                    // código a ejecutar sin importar si la petición falló o no
                    complete: function (xhr, status) {
                        //                console.log('Petición realizada');
                    }
                });

            }
            function onSuccess(googleUser) {


                var profile = googleUser.getBasicProfile();
                //        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                //        console.log('Full Name: ' + profile.getName());
                //        console.log('Given Name: ' + profile.getGivenName());
                //        console.log('Family Name: ' + profile.getFamilyName());
                //        console.log("Image URL: " + profile.getImageUrl());
                //        console.log("Email: " + profile.getEmail());
                InicioSesionGoogle(profile.getEmail());


            }
            function onFailure(error) {
                console.log(error + 'Mas error');
            }

            function renderButton() {
                gapi.signin2.render('my-signin2', {
                    'scope': 'profile email',
                    'width': 170,
                    'height': 30,
                    'longtitle': true,
                    'theme': 'dark',
                    'onsuccess': onSuccess,
                    'onfailure': onFailure
                });
            }




            function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
                // The current login status of the person.
                if (response.status === 'connected') {   // Logged into your webpage and Facebook.

                    datPer();
                    testAPI();
                } else {                                 // Not logged into your webpage or we are unable to tell.
                    //      document.getElementById('status').innerHTML = 'Please log ' +
                    //        'into this webpage.';
                }
            }


            function checkLoginState() {
                // Called when a person is finished with the Login Button.
                FB.getLoginStatus(function (response) {   // See the onlogin handler

                    statusChangeCallback(response);
                });
            }


            window.fbAsyncInit = function () {
                FB.init({
                    appId: '301435451261805',
                    cookie: true, // Enable cookies to allow the server to access the session.
                    xfbml: true, // Parse social plugins on this webpage.
                    version: 'v7.0'           // Use this Graph API version for this call.
                });


                FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
                    statusChangeCallback(response);        // Returns the login status.
                });
            };

            function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
                //    console.log('Welcome!  Fetching your information.... ');
                FB.api('/me', function (response) {
                    //        console.log(response.id);
                    //        console.log(response.name);
                    //        console.log(response.email);
                    //        console.log(response.first_name);
                    //        console.log(response.last_name);
                    //        
                    //      console.log('Successful login for: ' + response.name);
                    //      console.log(response);
                    //      document.getElementById('status').innerHTML =
                    //        'Thanks for logging in, ' + response.name + '!';

                    console.log('Lego ');
                    return false;
                    $(location).attr('href', '../../');

                }, {scope: 'email,user_likes'});



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
                            usrSexo = response.gender;
                            InicioSesionGoogle(response.email);
                            //        console.log("NOmbres "+ usrNombre +" APellidos "+usrApellidos+" correo "+usrCorreo+" Sexo "+usrSexo + " Id" +usrID);
                        }
                );

            }
        </script>




        <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>

        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="../../Javascript/Login/Login.js" type="text/javascript"></script>
        <!--    <script src="../../Javascript/Login/LoginGoogle.js" type="text/javascript"></script>-->
        <script src="../../Javascript/Login/LoginFacebook.js" type="text/javascript"></script>


        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script> 

    </body>
</html>


<%
    }
%>

<script>


</script>