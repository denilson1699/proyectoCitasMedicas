<%-- 
    Document   : MenuPaciente
    Created on : Dec 10, 2020, 10:22:39 PM
    Author     : jaram
--%>

<%@page import="negocio.Especialista"%>
<%@page import="java.util.List"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>@import"Styles/cssHeaderMenus.css";</style>
        
    </head>
    <body>
       <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
       <% Especialista esp=mp.getEspesc(); %>
       <header>
        <form action="ControlEspecialista" method="Post">
            <div class="cajaheader">
                <label>La casa del Pediatra</label>
                <p>
                    Bienvenido <input type="text" name="" value='<%= esp.getNombreEsp() %>' readonly="">
                    <img src="./img/iconSession.png" width="30" height="30" style=" margin-left: -28px; margin-bottom: -11px;">
                   <input type="text" name="IdEsp" value='<%= esp.getIDEspe() %>' readonly="">
                   <a class="btnCerrarCession" href="index.html">Cerrar Sesión</a>
                </p>
                
            </div>
            <div class="cajaMenuPrincipal">
            <input class="botonDatoPac"type="submit" name="acc" value="Buscar Paciente">
            <input class="botonDatoPac"type="submit" name="acc" value="Consultar Citas">
            </div>
        </form>
        </header>
            <img id="imagenCovid1" src="img/covi2.png">
            <img id="imagenCovid2" src="img/covi1.jpg">
            <img id="imagenCovid3" src="img/covid3.jpg">
    </body>
</html>
