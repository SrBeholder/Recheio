<%-- 
    Document   : fotolistar
    Created on : 06/10/2019, 23:07:39
    Author     : Daniel
--%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="controles.FotoControle"%>
<%@page import="entidades.Foto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud</title>
    </head>
    <body>
        <h1>Ibagens</h1>
        <%
            Usuario usuario = new Usuario(201);
            List<Foto> lista = FotoControle.listar(usuario);
            
            for(Foto foto: lista){                
                byte[] imagem = foto.getFoto();
                String encodedImage = Base64.getEncoder().encodeToString(imagem);     
        %>
                
                <img src="data:image/png;base64,<%=encodedImage%>" width='300' height='300'>
                <br>
        <%
            }
        %>

    </body>
</html>
