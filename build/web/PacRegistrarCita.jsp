<%-- 
    Document   : PacRegistrarCita
    Created on : 07/06/2021, 06:39:28 PM
    Author     : jaram
--%>

<%@page import="negocio.Paciente"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page import="negocio.Horarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>@import"Styles/cssHeaderMenus.css";
        
#tablaRegistroCita{
    float: left;
    background: #115d746b;
    border-radius: 7px;
    margin: 0px 30% auto;
    border-collapse: collapse;
    font-size: 14px;
    margin-bottom: 20px;
}    
#tablaRegistroCita input[type="text"] {
border: none;
height: 20px;
background: none;
color: #262728d9;
} 

#tablaRegistroCita input[type="text"]:focus {
    outline: none;
} 
.titleDatoCita{
    color: #f5dd5d;
    font-weight: 600;
    text-align: center;
    text-transform: uppercase;
    font-size: 12px;
}
.item{
    padding-left: 135px;
color: #262728d9;
    font-weight: 700;
}
.btnsRegistrarCita{
    text-align: center;
}
.btnsRegistrarCita input[type="submit"]{
    text-align: center;
    border: none;
    border-radius: 3px;
    margin-left: 3px;
    margin-right: 3px;
    font-family: cursive;
    color: white;
    background: #79aec8;
    cursor: pointer;
    font-size: 11px;
    width: 145px;
    height: 28px;
    margin-top: 23px;
    margin-bottom: 15px;
}
.btnsRegistrarCita input[type="submit"]:hover{
    
    transform: scale(0.85);
    background: #417690c9;
}
h3{
    float: left;
    width: 100%;
    height: 10px;
    padding-top: 75px;
    margin-bottom: 39px;
    text-align: center;
    color: #cf770e;
    text-transform: uppercase;
    margin-left: -15px;
}
#btnRegistrarCita{
    background-image: url(img/check.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position: 1rem center;
}
#btnCamcelarRegistro{
    background-image: url(img/cancelar.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position: 0.50rem center;
}
#btnCerrar{
    background-image: url(img/atras.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position: 2rem center;
}
#msgRegistroCita{
    color: blue;
    text-align: center;
    font-size: 14px;
    text-transform: lowercase;
}
        </style>
        <title>Registrar Cita</title>
    </head>
    <body>
        <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        <% Paciente p=mp.getPaciente(); %>
        <% Horarios h=mp.getHorario(); %>
        <% Object[] c=mp.getFil(); %>
            <form action="ControlPaciente" method="Post"> 
        <header>
            <div class="cajaheader">
                <label>La casa del Pediatra</label>
                <p>
                    Bienvenido <input type="text" name="" value='<%= p.getNombrePac() %>' readonly="">
                    <img src="./img/iconSession.png" width="30" height="30" style=" margin-left: -28px; margin-bottom: -11px;">
                   <input type="text" name="IdPac" value='<%= p.getIDPac() %>' readonly="">
                   <a class="btnCerrarCession" href="index.html">Cerrar Sesión</a>
                </p>
                
            </div>
            <div class="cajaMenuPrincipal">
                <input type="submit" name="acc" value="Generar Cita">>
                <input type="submit" name="acc" value="Ver mis citas">
            </div>
        </header>
                   <h3>Registro de Cita</h3>
        <form action="ControlPaciente" method="Post">
            <table id="tablaRegistroCita" >
            <tr>
                <td>Código: <input type="text" name="CodigoCita" value='<%= c[0].toString() %>' readonly="" > </td>
                <td>Fecha: <input type="text" name="fechaRegistro" value='<%= c[1].toString() %>' readonly=""  </td>
            </tr>
            <tr><td class="titleDatoCita" colspan="2">Datos del Horario:</td></tr>
            <tr><td class="item">Código:</td><td><input type="text" name="idHorario" value='<%= h.getIDHorario() %>' readonly=""></td></tr>
            <tr><td class="item">Fecha:</td><td><input type="text" name="" value='<%= h.getFecha() %>' readonly=""></td></tr>
            <tr><td class="item">Hora:</td><td><input type="text" name="" value='<%= h.getHora() %>' readonly=""></td></tr>
            
            <tr><td class="titleDatoCita" colspan="2">Datos del Paciente:</td></tr>
            <tr><td class="item">Código:</td><td><input type="text" name="IdPac" value='<%= p.getIDPac()%>' readonly=""></td></tr>
            <tr><td class="item">Nombre:</td><td><input type="text" name="" value='<%= p.getNombrePac() %>' readonly=""></td></tr>
            <tr><td class="item">Apellidos</td><td><input type="text" name="" value='<%= p.getApellidoPatPac().concat(" "+p.getApellidoMatPac()) %>' readonly=""></td></tr>
            
            <tr><td class="titleDatoCita" colspan="2">Datos del Medico:</td></tr>
            <tr><td class="item">Nombre:</td><td><input type="text" name="" value='<%= h.getMedico().getNombre() %>'></td></tr>
            <tr><td class="item">Apellidos:</td><td><input type="text" name="" value='<%= h.getMedico().getApellidoPatMed().concat(" "+h.getMedico().getApellidoMatMed()) %>' readonly="" size="30"></td></tr>
            <tr><td class="item">Especialidad:</td><td><input type="text" name="" value='<%= h.getMedico().getIdTEMedico().getDescripcion() %>' readonly=""></td></tr>
            
            <tr><td class="titleDatoCita" colspan="2">Datos del Local:</td><tr>
            <tr><td class="item">Razón Social:</td><td><input type="text" name="" value='<%= h.getLocal().getDescripcionLocal() %>'readonly="" ></td></tr>
            <tr><td class="item">Direccion</td><td><input type="text" name="" value='<%= h.getLocal().getDireccion() %>' readonly=""></td ></tr>
            <tr><td colspan="3" id="msgRegistroCita"><%= mp.getMsg() %></td></tr>
            <tr>
                <td colspan="3" class="btnsRegistrarCita">
                    <input id="btnRegistrarCita" type="submit" name="acc" value='Registrar Cita'>
                    <input id="btnCamcelarRegistro" type="submit" name="acc" value='Cancelar Registro'>
                    <input id="btnCerrar" type="submit" name="acc" value='Cerrar'>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
