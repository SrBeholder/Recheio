<%-- 
    Document   : fotoinserir
    Created on : 06/10/2019, 20:59:03
    Author     : Daniel
--%>
<%@page import="controles.FotoControle"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.page import="entidades.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="utilidades.HibernateUtil" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud</title>
    </head>
    <body>
        <h1>Inserir foto</h1>
        <form method="POST" action="FotoServletS" enctype="multipart/form-data">
            <input type="file" name="foto" />
            <input type="submit">
        </form>
    </body>
</html>
