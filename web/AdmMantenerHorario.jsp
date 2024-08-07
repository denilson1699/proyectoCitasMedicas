<%-- 
    Document   : AdmBuscarHorario
    Created on : 31/05/2021, 05:35:05 PM
    Author     : jaram
--%>

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
    margin-bottom: 30px;
    text-align: center;
    color: #cf770e;
}       



        </style>
        <title>Horarios</title>
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
     <h2>Mantenimiento de horarios</h2>
    <form action="ControlAdministrador" method="Post">
    <div>
        <input class="DatHorario" type="text" name="ValorABuscar" value='' placeholder="Buscar ID" size="10">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar'>
        <input class="btnNuevo" type="submit" name="acc" value='New Registro'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
    </div><br>
    </form>   
    <div class="cajaLista">
        <table>
            <thead>
            <tr>
                <td>ID</td>
                <td>Fecha</td>
                <td>Hora</td>
                <td>Estado</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisHorario().size();i++){ %> 
            <% Horarios h=(Horarios)mp.getLisHorario().get(i); %>
            <form action="ControlAdministrador" method="Post">
            <tr>
                <td><input class="ListDato" type="text" name="idHorario" value='<%= h.getIDHorario() %>' size="10"></td>
                <td><input class="ListDato" type="text" value='<%= h.getFecha() %>' size="12"></td>
                <td><input class="ListDato" type="text" value='<%= h.getHora() %>' size="7"></td>
                <td><input class="ListDato" type="text" value='<%= h.getEstado() %>' size="20"></td>
                <td><input class="btnItemElegido" type="submit" name="acc" value='Editar'></td>
            </tr>
            </form>
            <% } %>
            </tbody>
        </table>
    </div>
     <div class="CajaEditDatos"  style=" width: 45%; text-align: center">
        <% Horarios hDato=mp.getHorario(); %><br><br>
        <table >
            <form action="ControlAdministrador" method="Post">
            <thead>
                <tr>
                    <td>ID:<br><input class="itemEditar" type="text" name="IDHOrAct" value='<%= hDato.getIDHorario() %>' readonly=""></td>
                </tr>
                <tr>
                    <td>Fecha:<br><input class="itemEditar"  type="text" value='<%= hDato.getFecha() %>'></td>
                    <td>Fecha:<br><input type="date" name="NuevaFechaAct" value=''></td>  
                </tr>
                <tr>
                    <td>Hora:<br><input class="itemEditar"  type="text"value='<%= hDato.getHora() %>'></td>
                    <td>Hora:<br><input type="time" name="NuevaHoraAct" value=''></td>
                </tr>
                <tr>
                    <td>Estado:<br><input  class="itemEditar" type="text" name="estado" value='<%= hDato.getEstado() %>' readonly=""></td>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>Datos del medico:</td>
            </tr>
            <tr>
                <td>ID:<br><input class="itemEditar"  type="text" name="IDMediAct" value='<%= hDato.getMedico().getIDMedico() %>' readonly=""></td>
                <td>Nombre:<br><input class="itemEditar"  type="text"  value='<%= hDato.getMedico().getNombre() %>' readonly=""></td>
                <td>Apelidos:<br><input class="itemEditar"  type="text" value='<%= hDato.getMedico().getApellidoPatMed() %>' readonly=""></td>
            </tr>                  
            <tr>
                <td>Datos del Local:</td>
            </tr>
            <tr>
                <td>ID:<br><input class="itemEditar"  type="text" name="IDLocalAct" value='<%= hDato.getLocal().getIDLocal() %>' readonly=""></td>
                <td>Descripción:<br><input class="itemEditar"  type="text"  value='<%= hDato.getLocal().getDescripcionLocal()%>' readonly=""></td>
                <td>Direccion:<br><input class="itemEditar"  type="text"  value='<%= hDato.getLocal().getDireccion() %>' readonly=""></td>
            </tr>             
            <tr>
                <td colspan="3"><input class="btnActualizar" type="submit" name="acc" value='Actualizar' >
                    <input class="btnEliminar" type="submit" name="acc" value='Eliminar' ></td>
            </tr >
            <td colspan="2" class="msgRespuesta"><%= mp.getMsg() %></td>
            </tbody>
            </form>
        </table>
                
    </div>
    </body>
</html>
