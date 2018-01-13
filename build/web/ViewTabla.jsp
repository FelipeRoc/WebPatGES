<%-- 
    Document   : ViewTabla
    Created on : 13-01-2018, 0:43:24
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Patologías GES</title>
        <!-- libreria bootstrap++  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.rawgit.com/arafkarim/BootstrapPlusPlus/2d8d0b9d/bpp/bpp.min.css">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
        <!-- fin bootstrap -->
    </head>
    <body>
        <!--<table border="1">
            <thead style="background-color: #009999">
            <td>Id</td><td>Patología</td><td>2009</td><td>2010</td><td>2011</td><td>2012</td><td>2013</td><td>2014</td><td>2015</td><td>2016</td><td>2017</td>
            </thead>
            <tr style="background-color: #ffffff">
                <td>${id_pat}</td>
                <td>${patologia}</td>
                <td>${a2009}</td>
                <td>${a2010}</td>
                <td>${a2011}</td>
                <td>${a2012}</td>
                <td>${a2013}</td>
                <td>${a2014}</td>
                <td>${a2015}</td>
                <td>${a2016}</td>
                <td>${a2017}</td>                
            </tr>
            Imprimir Personas desde Java MySql 
            ${html}
        </table>-->
        <table class="table table-sm table-dark">
            <thead>
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Patología</th>
                <th scope="col">2009</th>
                <th scope="col">2010</th>
                <th scope="col">2011</th>
                <th scope="col">2012</th>
                <th scope="col">2013</th>
                <th scope="col">2014</th>
                <th scope="col">2015</th>
                <th scope="col">2016</th>
                <th scope="col">2017</th>                              
              </tr>
            </thead>
            <tbody>
              <tr>                                
                  <td>${id_pat}</td>
                  <td>${patologia}</td>
                  <td>${a2009}</td>
                  <td>${a2010}</td>
                  <td>${a2011}</td>
                  <td>${a2012}</td>
                  <td>${a2013}</td>
                  <td>${a2014}</td>
                  <td>${a2015}</td>
                  <td>${a2016}</td>
                  <td>${a2017}</td>
              </tr>
              ${html}
            </tbody>
          </table>
    </body>
</html>
