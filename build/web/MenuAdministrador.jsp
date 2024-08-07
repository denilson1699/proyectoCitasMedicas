<%-- 
    Document   : MenuPaciente
    Created on : Dec 10, 2020, 10:22:39 PM
    Author     : jaram
--%>

<%@page import="presentacion.ModeloPrincipal"%>
<%@page import="presentacion.ModeloLogin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion</title>
        <style>@import"Styles/cssHeaderMenus.css";@import"Styles/EstilosAdministrador.css";

            
#contenedor{
    float: left;
    width: 100%;
    height: 512px;
    padding-top: 55px;
    margin-left: -10px;
    color: #cf770e;
}
#cajaizquierda{
    float: left;
    width: 249px;
    height: 90%;
    background: #79aec8cf;
    margin-left: 0px;
    padding-left: 18px;
    padding-right: 21px;
    height: 100%;
    text-align: center;
}
#cajaizquierda input[type="submit"]{
    background: #79aec8;
    border: none;
    height: 35px;
    font-family: finger;
    font-size: medium;
    text-align: justify;
    cursor: pointer;
    margin-bottom: 5px;
    width: 122%;
    margin-left: -35px;
    text-align: center;
    
}
#cajaizquierda input[type="submit"]:hover{
    background: #417690;
    color: white;
    transform: scale(1.05);
    text-align: center;
    border-radius: 3px;
}
#cajaderecha{
    float: right;
    width: 961px;
    height: 95%;
    background: #79aec882;
    margin-right: -18px;
    background-image: url(img/fondoAdministracion.jpg);
    background-repeat: no-repeat;
    background-size: 100% 100%;
    border-radius: 25px;
    margin-top: 20px;
    margin-left: -3px;
    margin-bottom: 25px;
    margin-right: 0px;
    padding-left: -97px;
}



</style>
    </head>

    <body>
        <% ModeloLogin ml=(ModeloLogin)session.getAttribute("modLog"); %>
        <header>
        <form action="ControlEspecialista" method="Post">
            <div class="cajaheader">
                <label>La casa del Pediatra</label>
                <p>
                    Bienvenido<input type="text" name="" value='' readonly="">
                    <img src="./img/iconSession.png" width="30" height="30" style=" margin-left: -28px; margin-bottom: -11px;">
                   <a class="btnCerrarCession" href="index.html">Cerrar Sesión</a>
                </p>
            </div>
            <div class="cajaMenuPrincipal">
            </div>
        </form>
        </header>
        <div id="contenedor" >
            <div id="cajaizquierda">
                <h2>Administración</h2>
                <form action="ControlAdministrador" method="Post">

                <div >
                    <input class="btnMHor" type="submit" name="acc" value="Mantener Horarios" ><br>
                    <input class="btnMPac" type="submit" name="acc" value="Mantener Pacientes" ><br>
                    <input class="btnMEsp" type="submit" name="acc" value="Mantener Especialistas"><br>
                    <input class="btnMCit" type="submit" name="acc" value="Mantener Citas"><br>
                    <input class="btnMMed" type="submit" name="acc" value="Mantener Medico"><br>
                </div>
                </form>
            </div>
            <div id ="cajaderecha">
               
            </div>
        </div>
          
    </body>
</html>
