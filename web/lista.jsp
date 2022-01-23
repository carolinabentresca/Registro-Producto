<%@page import="java.util.List"%>
<%@page import="modelo.Producto1"%>
<%@page import="controlador.Producto1JpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros de Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head> 
    <%
        Producto1JpaController Jpa = new Producto1JpaController();
        Producto1 pro = new Producto1();
        List<Producto1> lista = Jpa.findProducto1Entities();
    %>
    <body style="background: #333333;font-family: cursive">
    <center>
        <h3 style="color: #00ff00">Registros de Productos</h3>
        <table border="1" style="color: #ffffff">
            <thead>
                <tr>
                    <th style="background: #00ff00;color: #333333">Id</th>
                    <th style="background: #00ff00;color: #333333">Marca</th>
                    <th style="background: #00ff00;color: #333333">Modelo</th>
                    <th style="background: #00ff00;color: #333333">Color</th>
                    <th style="background: #00ff00;color: #333333">Precio</th>
                    <th style="background: #00ff00;color: #333333">Cuota</th>
                </tr>
            </thead>
            <%
                for (Producto1 p : lista) {
            %>
            <tbody>
                <tr>  
                    <td> <%= p.getId()%></td>
                    <td> <%= p.getMarca()%></td>
                    <td> <%= p.getModelo()%></td>   
                    <td> <%= p.getColor()%></td>
                    <td> <%= p.getPrecio()%></td>
                    <td> <%= p.getCuota()%></td> 
                </tr>
            </tbody>
            <%
                }
            %>
        </table> 
    </body>
</center>
</html>
