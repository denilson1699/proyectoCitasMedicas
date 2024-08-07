<%-- 
    Document   : AdmBuscarHorario
    Created on : 31/05/2021, 05:35:05 PM
    Author     : jaram
--%>

<%@page import="negocio.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Especialista"%>
<%@page import="presentacion.ModeloLogin"%>
<%@page import="negocio.Horarios"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>@import"Styles/cssHeaderMenus.css"; @import"Styles/cssGeneral.css";
  
h2{
    float: left;
    width: 100%;
    height: 10px;
    padding-top: 70px;
    margin-bottom: 25px;
    text-align: center;
    color: #cf770e;
}


#btnExaminarPacienteEsp{ 
    border: none;
    border-radius: 3px;
    margin-left: 3px;
    margin-right: 3px;
    font-family: cursive;
    color: transparent;
    background: none;
    cursor: pointer;
    font-size: 11px;
    width: 25px;
    height: 22px; 
    background-image: url(img/editar.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position:  center;
}

#btnExaminarPacienteEsp:hover{
    transform: scale(1.85);
}


#msgBuscarPacEsp{   
    color: #cf770e;
    text-align: center;
    width: 100%;
    height: 30px;
}


</style>
        <title>Pacientes</title>
    </head>
    <body>    
    <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
    <% Especialista esp=mp.getEspesc(); %>
    <form action="ControlEspecialista" method="Post">
        <header>
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
        </header>
                   <h2>Buscar Paciente</h2>
        <div>
            <input type="text" name="ValorABuscarPaciente" value='' placeholder="Buscar ID" size="15">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
        </div><br>
    </form>   
    <div class="cajaLista">
        <table>
            <thead>
            <tr>
                <td>ID</td>
                <td>DNI</td>
                <td>Apellidos</td>
                <td>Nombre</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisDet().size();i++){ %> 
            <% Paciente p=(Paciente)mp.getLisDet().get(i); %>
            <tr>
            <form action="ControlEspecialista" method="Post">
                <td><input class="ListDato" type="text" name="idpaciente" value='<%= p.getIDPac() %>' size="3"></td>
                <td><input class="ListDato" type="text" value='<%= p.getDNIPac() %>' size="8"></td>
                <td><input class="ListDato" type="text" value='<%= p.getApellidoPatPac().concat(" "+p.getApellidoMatPac()) %>'></td>
                <td><input class="ListDato" type="text" value='<%= p.getNombrePac() %>' size="10"></td>
                <td><input id="btnExaminarPacienteEsp"  type="submit" name="acc" value='Ver'></td>
                <td><input class="textOculto" type="text" name="IdEsp" value='<%= esp.getIDEspe() %>'></td>
            </form>
            </tr>
            <% } %>
            </tbody>
        </table> 
    </div>
            <div class="CajaEditDatos"><br><br>
        <table >
        <% Paciente pac=mp.getPaciente(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td>ID:<br><input class="itemEditar" type="text" name="IDPacAct" value='<%= pac.getIDPac() %>' readonly=""></td>
                    <td>DNI:<br><input class="itemEditar" type="text" name="DniPacAct" value='<%= pac.getDNIPac() %>' readonly=""></td>
                    <td>Estado:<br><input  class="itemEditar"  type="text" name="estPacAct" value='<%= pac.getEstadoPac() %>' readonly=""></td>
                </tr>
                <tr>
                    <td>nombre:<br><input class="itemEditar"  type="text" name="nombPacAct"value='<%= pac.getNombrePac() %>' readonly=""></td>
                    <td>apellido paterno:<br><input class="itemEditar"  type="text" name="apePaPacAct" value='<%= pac.getApellidoPatPac() %>' readonly=""></td>
                    <td>apellido Materno:<br><input class="itemEditar"  type="text" name="apeMaPacAct" value='<%= pac.getApellidoMatPac() %>' readonly=""></td>  
                </tr>
                <tr>
                    <td>genero:<br><input class="itemEditar"  type="text" name="genePacAct" value='<%= pac.getGeneroPac() %>' readonly=""></td>
                    <td>Telfono Movil(+51):<br><input class="itemEditar"  type="number" name="TelfoPacAct" value='<%= pac.getTelefPac() %>' readonly=""></td>
                    <td>Email:<br><input class="itemEditar"  type="email" name="emailPacAct" value='<%= pac.getEmailPac() %>' readonly=""></td>
                </tr>
                <tr>
                    <td>Fecha de Registro:<br><input class="itemEditar"  name="fechPacAct" type="text"value='<%= pac.getFechaRegistroPac() %>' readonly=""></td>
                    <td>Password:<br><input class="itemEditar"  type="text" name="passPacAct" value='<%= pac.getPassPac() %>' readonly=""></td>
                </tr>
                <tr>
                    <td colspan="3" id="msgBuscarPacEsp"><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
