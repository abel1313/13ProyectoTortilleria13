<%-- 
    Document   : Menu
    Created on : Jul 3, 2020, 4:09:53 PM
    Author     : trece
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuarioSession = (Usuario) request.getSession().getAttribute("us");

    if (usuarioSession == null) {
        response.sendRedirect("../../Vista/Login/Login.jsp");

    }
    if (usuarioSession != null && usuarioSession.getRolUsuario().getPermisos().contains(14)) {

%>
<meta name="google-signin-client_id" content="331670075591-i8qluf5rffepumk3a8v00r2n0qfvqs38.apps.googleusercontent.com">

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="#">Bienvenido <%=(usuarioSession.getUserName().toUpperCase())%></a>
    <button class="navbar-toggler ocultarContenedor" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <%
                if (usuarioSession.getRolUsuario().getPermisos().contains(12)) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item agregarUsuario" href="#">Agregar</a>
                    <a class="dropdown-item mostrarUsuario" href="#">Consultar</a>

                   

                </div>
            </li>
            <%
                }
            %>
                        <%
                if (usuarioSession.getRolUsuario().getPermisos().contains(1)) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Cliente
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item agregarCliente" href="#">Agregar</a>
                    <a class="dropdown-item mostrarCliente" href="#">Consultar</a>
                    <%
                       if(usuarioSession.getRolUsuario().getId_RolUduario() == 2)
                       {
                    %>
                    <a class="dropdown-item ActualizarCliente" href="#">Actualizar</a>
                    <%
                        }
                    %>
                </div>
            </li>
            
                        <%
                            }
                if (usuarioSession.getRolUsuario().getPermisos().contains(5)) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Empleado
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item agregarEmpleado" href="#">Agregar</a>
                    <a class="dropdown-item mostrarEmpleado" href="#">Consultar</a>

                </div>
            </li>
            
                        <%
                }
                if (usuarioSession.getRolUsuario().getPermisos().contains(13)) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Venta
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item agregarVenta" href="#">Agregar</a>
                    

                </div>
            </li>
            <%
    }

                if (usuarioSession.getRolUsuario().getPermisos().contains(9)&& 
            (usuarioSession.getRolUsuario().getId_RolUduario() == 1||usuarioSession.getRolUsuario().getId_RolUduario() == 3) ) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Producto
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item agregarProduc" href="#">Agregar</a>
                    <a class="dropdown-item mostrarProducto" href="#">Consultar</a>

                </div>
            </li>
                <%
                    }
                %>
            <li class="nav-item dropdown">
                <button class="btn btn-info btnSalir" id="salirSistema" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Salir
                </button>
            </li>

        </ul>
    </div>

</nav>
<script>

    $(() => {
        $('#salirSistema').click(signOutGoogle);
        $('.agregarProducto').click(function () {
            FB.logout(function (response) {
                console.log(response);
// user is now logged out
            });
        });


    });
    function signOutGoogle() {

        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            $(location).attr('href', 'Vista/Login/Login.jsp');
            console.log('User signed out.');
        });
        salirSistema();

    }

    function salirSistema() {
        $.ajax({
            type: 'POST',
            url: 'DatosUsuario',
            data: {accion: "sairSistema"},
            success: function (rec) {
                location.reload();



            },
            error: function (xhr, status) {
                console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                console.log('Petición realizada');
            }
        });
    }
    function onLoad() {
        gapi.load('auth2', function () {
            gapi.auth2.init();
        });
    }
</script> 


<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script> 
<script src="./Javascript/Menu/Menu.js" type="text/javascript"></script>

<%
    }
%>
