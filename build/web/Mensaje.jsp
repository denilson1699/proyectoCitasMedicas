<%-- 
    Document   : Mensaje
    Created on : Dec 30, 2020, 1:09:41 PM
    Author     : jaram
--%>

<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            h1{
                color: #417690;
                width: 100%;
                text-align: center;
            }
            h3{
                
                color: #246355;
                width: 100%;
                text-align: center;
            }
            h5{
                text-align: center;
                width: 100%;
            }
            a{                
                color: #cf770e;
            }
            a:hover{
                transform: scale(1.85);
                color: #417690;
            }
        </style>
        <title>Error</title>
    </head>
    <body>
        <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        
        <h1>mensaje</h1>
        <h3><%= mp.getMsg() %></h3>
        <h5><a href="index.html">Volver a intentar</a></h5>
    </body>
</html>
