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
        <style>@import"Styles/cssHeaderMenus.css";@import"Styles/cssGeneral.css";
         
h2{
    float: left;
    width: 100%;
    height: 10px;
    padding-top: 50px;
    margin-bottom: 50px;
    text-align: center;
    color: #cf770e;
}       

        
        </style>
        <title>Pacientes</title>
    </head>
    <body>    
    <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
    <% ModeloLogin mlog=(ModeloLogin)session.getAttribute("modLog"); %>
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
     <h2>Mantenimiento de Pacientes</h2>
    <form action="ControlAdministrador" method="Post">

    <div>
        <input class="DatHorario" type="text" name="ValorABuscarPaciente" value='' placeholder="Buscar ID" size="10">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar paciente'>
        <input class="btnNuevo" type="submit" name="acc" value='New paciente'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar pacientes' style="font-size: 11px;">
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
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisDet().size();i++){ %> 
            <% Paciente p=(Paciente)mp.getLisDet().get(i); %>
            <tr>
            <form action="ControlAdministrador" method="Post">
                <td><input class="ListDato" type="text" name="idpaciente" value='<%= p.getIDPac() %>' size="6"></td>
                <td><input class="ListDato" type="text" value='<%= p.getDNIPac() %>' size="10"></td>
                <td><input class="ListDato" type="text" value='<%= p.getApellidoPatPac().concat(" "+p.getApellidoMatPac()) %>'></td>
                <td><input class="ListDato" type="text" value='<%= p.getNombrePac() %>' size="12"></td>
                <td><input class="btnItemElegido" type="submit" name="acc" value='Editar Paciente'></td>
            </form>
            </tr>
            <% } %>
            </tbody>
        </table> 
    </div>
            <div class="CajaEditDatos" style="margin-left: 105px; width: 45%"><br><br><br>
        <table >
        <% Paciente pac=mp.getPaciente(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td>ID:<br><input class="itemEditar" type="text" name="IDPacAct" value='<%= pac.getIDPac() %>' readonly=""></td>
                    <td>DNI:<br><input class="itemEditar" type="text" name="DniPacAct" value='<%= pac.getDNIPac() %>' ></td>
                    <td>Estado:<br><input class="itemEditar" type="text" name="estPacAct" value='<%= pac.getEstadoPac() %>' ></td>
                </tr>
                <tr>
                    <td>nombre:<br><input class="itemEditar" type="text" name="nombPacAct"value='<%= pac.getNombrePac() %>'></td>
                    <td>apellido paterno:<br><input class="itemEditar" type="text" name="apePaPacAct" value='<%= pac.getApellidoPatPac() %>'></td>
                    <td>apellido Materno:<br><input class="itemEditar" type="text" name="apeMaPacAct" value='<%= pac.getApellidoMatPac() %>'></td>  
                </tr>
                <tr>
                    <td>genero M/F:<br><input class="itemEditar" type="text" name="genePacAct" value='<%= pac.getGeneroPac() %>'></td>
                    <td>Telfono Movil(+51):<br><input class="itemEditar" type="number" name="TelfoPacAct" value='<%= pac.getTelefPac() %>'></td>
                    <td>Email:<br><input class="itemEditar" type="email" name="emailPacAct" value='<%= pac.getEmailPac() %>'></td>
                </tr>
                <tr>
                    <td>Fecha de Registro:<br><input class="itemEditar" name="fechPacAct" type="text"value='<%= pac.getFechaRegistroPac() %>'></td>
                    <td>Password:<br><input class="itemEditar" type="text" name="passPacAct" value='<%= pac.getPassPac() %>'></td>
                </tr>
                <tr>
                    <td><input class="btnActualizar" type="submit" name="acc" value='Actualizar Paciente' ></td>
                    <td><input class="btnRegristrar"type="submit" name="acc" value='Registrar Paciente' ></td>
                <td><input class="btnEliminar" type="submit" name="acc" value='Eliminar Paciente' ></td>
                </tr >
                <tr>
                    <td colspan="2" class="msgRespuesta" ><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
