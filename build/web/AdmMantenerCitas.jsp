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
<%@page import="negocio.Cita"%>
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
#comentario{ 
    border: solid 1px #79aec8ad;
    width: 405px;
    background: none;
    height: 43px;
    border-radius: 4px;
    margin-bottom: -20px;
}
        </style>
        <title>Citas</title>
    </head>
    <body>    
    <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
    <% ModeloLogin mlog=(ModeloLogin)session.getAttribute("modLog"); %>
    <header>
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
    </header>
     <h2>Mantenimiento de Citas</h2>
    <form action="ControlAdministrador" method="Post">

    <div>
        <input class="DatHorario" type="text" name="ValorBuscarCita" value='' placeholder="Buscar codigo" size="10">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar Cita'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar Citas'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
    </div><br>
    </form>   
     <div class="cajaLista" style="margin-left: 0px;">
        <table>
            <thead>
            <tr>
                <td>Codigo</td>
                <td>ID Paciente</td>
                <td>ID Horario</td>
                <td>Fecha</td>
                <td>Estado</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisDet().size();i++){ %> 
            <% Cita c=(Cita)mp.getLisDet().get(i); %>
            <form action="ControlAdministrador" method="Post">
            <tr>
                <td><input class="ListDato" type="text" name="idCita" value='<%= c.getCodigoCita() %>' size="4"></td>
                <td><input class="ListDato" type="text" value='<%= c.getIdpac().getIDPac() %>' size="7"></td>
                <td><input class="ListDato" type="text" value='<%= c.getIdHora().getIDHorario() %>' size="7"></td>
                <td><input class="ListDato" type="text" value='<%= c.getFechaReg() %>' size="14"></td>
                <td><input class="ListDato" type="text" value='<%= c.getEstado() %>' size="5"></td>
                <td><input class="btnItemElegido" type="submit" name="acc" value='Editar Cita'></td>
            </tr>
            </form>
            <% } %>
            </tbody>
        </table> 
    </div>
    <div class="CajaEditDatos" style="margin-left:50px; width: 45%">
        <table id="">
        <% Cita cit=mp.getCita(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td>codigo:<br><input class="itemEditar" type="text" name="IDCitaAct" value='<%= cit.getCodigoCita() %>' readonly=""></td>
                    <td>Fecha:<br><input class="itemEditar"  type="text"  name="fechCitAct" value='<%= cit.getFechaReg() %>' ></td>
                    <td>Estado:<br><input class="itemEditar"  type="text" name="estCitAct" value='<%= cit.getEstado()  %>' ></td>
                </tr>
                <tr>
                    <td>Datos del paciente:<br> <input class="itemEditar"  type="text" name="IDPacAct" value='<%= cit.getIdpac().getIDPac() %>'></td>
                </tr>
                <tr>
                    <td>Dni:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdpac().getDNIPac() %>'></td>  
                    <td>nombre:<br><input class="itemEditar"  type="text" value='<%= cit.getIdpac().getNombrePac() %>'></td>
                    <td>apellidos:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdpac().getApellidoPatPac().concat(cit.getIdpac().getApellidoMatPac()) %>'></td>
                </tr>
                <tr>
                    <td>Datos del Horario<input class="itemEditar"  type="text" name="IDHorarioAct" value='<%= cit.getIdHora().getIDHorario() %>'></td>
                </tr>
                <tr>
                    <td>Medico<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getMedico().getIDMedico() %>'></td>
                    <td>Local:<br><input class="itemEditar"  type="text" value='<%= cit.getIdHora().getLocal().getIDLocal() %>'></td>
                    <td>Fecha:<br><input class="itemEditar"  type="text" value='<%= cit.getIdHora().getFecha() %>'></td>
                    <td>Hora:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getHora() %>' size="4"></td>
                </tr>
                <tr>
                    <td colspan="3">Comentario:<br><input id="comentario" type="text" name="comentarioCitAct"  value='<%= cit.getComentario() %>' ></td>
                </tr >
                <tr>
                    <td><input class="btnActualizar"  type="submit" name="acc" value='Actualizar Cita' ></td>
                    <td><input class="btnEliminar"  type="submit" name="acc" value='Dar de baja' ></td>
                </tr >
                <tr>
                    <td colspan="2"  class="msgRespuesta"  ><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
