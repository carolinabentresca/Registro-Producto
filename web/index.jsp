                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
<%@page import="java.util.List"%>
<%@page import="modelo.Producto1"%>
<%@page import="controlador.Producto1JpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Producto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head> 
    <%
        Producto1JpaController Jpa = new Producto1JpaController();
        Producto1 pro = new Producto1();
        List<Producto1> lista = Jpa.findProducto1Entities();
        if (request.getParameter("btnRegistrar") != null) {
            pro.setId(Integer.parseInt(request.getParameter("id")));
            pro.setMarca(request.getParameter("marca"));
            pro.setModelo(request.getParameter("modelo"));
            pro.setColor(request.getParameter("color"));
            pro.setPrecio(Double.parseDouble(request.getParameter("precio")));
            pro.setCuota(Double.parseDouble(request.getParameter("cuota")));
            Jpa.create(pro);
            lista = Jpa.findProducto1Entities();
        }
    %>
    <body style="background: #333333;color: #ffffff;font-family: cursive"> 
    <center>
        <h3 style="color: #cc0099">Registro de Producto</h3>   
        <form method="POST">
            <label>Id (*)</label><br/> 
            <input type="text" name="id"  placeholder="" required="required" style="font-size: 18px" /><br/>
            <label>Marca (*)</label><br/> 
            <input type="text" name="marca"  placeholder=""  required="required" style="font-size: 18px"/><br/> 
            <label>Modelo (*)</label><br/>
            <input type="text" name="modelo"  placeholder="" required="required" style="font-size: 18px" /><br/>
            <label>Color (*)</label><br/> 
            <input type="text" name="color"  placeholder="" required="required" style="font-size: 18px" /><br/>
            <label>Precio (*)</label><br/> 
            <input type="text" name="precio"  placeholder=""  required="required" style="font-size: 18px"/><br/> 
            <label>Cuota (*)</label><br/>
            <input type="text" name="cuota"  placeholder="" required="required" style="font-size: 18px" /><br/>          
            <br/>
            <input type="submit" value="Registrar" name="btnRegistrar" style="background: #cc0099;color: #ffffff;font-size: 18px" onclick="alert('¡¡Producto Registrado!!')"/>
            <a href="lista.jsp" style="color: #ffffff;font-size: 18px;margin-left: 12px">Ir a Registros</a>
        </form>
    </body>
</center>
</html>