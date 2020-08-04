<%-- 
    Document   : index
    Created on : Jul 3, 2020, 3:11:23 PM
    Author     : trece
--%>
<%@page import="Modelo.Usuario"%>
<%
         Usuario usuarioSession = (Usuario) request.getSession().getAttribute("us");

             if (usuarioSession == null) {
                 response.sendRedirect("Vista/Login/Login.jsp");
                 
             }
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control"  content="no-cache"> 
<meta http-equiv="Expires" content="Sat, 01 Dec 2012 00:00:00 GMT"> 



    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
    <title>Index</title>
    <style>

    </style>
  </head>
  <body>

      <div class="contenedorPrincipal">
          
          <div class="contenedorHeader"></div>
          <div class="contenedorBody"></div>
          <div class="contenedorFooter"></div>
          
      </div>


    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="Javascript/jQuery/js/jquery.validate.js" type="text/javascript"></script>
    <script src="Javascript/Index/IndexMenu.js" type="text/javascript"></script>
    <script src="Javascript/jQuery/js/jQueryValidarCampos.js" type="text/javascript"></script>
    
    <link href="Estilos/Index/IndexMenu.css" rel="stylesheet" type="text/css"/>

  </body>
</html>



