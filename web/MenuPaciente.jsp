
<%@page import="negocio.Paciente"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <style>@import"Styles/cssHeaderMenus.css";</style>
        
    </head>
    <body>
        <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        <% Paciente p=mp.getPaciente(); %>
        <header>
            <form action="ControlPaciente" method="Post"> 
            <div class="cajaheader">
                <label>La casa del Pediatra</label>
                <p>
                    Bienvenido <input type="text" name="" value='<%= p.getNombrePac() %>' readonly=""><img src="./img/iconSession.png" width="30" height="30" style=" margin-left: -28px; margin-bottom: -11px;">
                   <input type="text" name="IdPac" value='<%= p.getIDPac() %>' readonly="">
                   <a class="btnCerrarCession" href="index.html">Cerrar Sesión</a>
                </p>
                
            </div>
            <div class="cajaMenuPrincipal">
                <input type="submit" name="acc" value="Generar Cita">>
                <input type="submit" name="acc" value="Ver mis citas">
            </div>
            </form>
        </header>
            <img id="imagenCovid1" src="img/covi2.png">
            <img id="imagenCovid2" src="img/covi1.jpg">
            <img id="imagenCovid3" src="img/covid3.jpg">
                
    </body>
</html>
