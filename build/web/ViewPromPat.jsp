<%-- 
    Document   : ViewPromPat
    Created on : 12-01-2018, 23:41:50
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promedio Patología GES</title>
        <!-- libreria bootstrap++  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.rawgit.com/arafkarim/BootstrapPlusPlus/2d8d0b9d/bpp/bpp.min.css">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
        <!-- fin bootstrap -->
    </head>
    <body>
        <div class="jumbotron grey lighten-2">
            <h1 class="display-3">Promedio Patología GES año ${ano_promedio}.</h1>
            <h2>${fecha_prom}</h2>
            <hr>
            <p>Fue el promedio de patologías ingresadas el año ${ano_suma} que tienen relación al cancer.</p>
            <p class="lead">
              <a class="btn btn-primary btn-lg" href="http://localhost:8080/JavaEj4_2/" role="button">Volver</a>
            </p>
        </div>              
    </body>
</html>
