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
        <style>@import"Styles/cssHeaderMenus.css"; @import"Styles/cssConsultarCitas.css";@import"Styles/cssGeneral.css";
 

        </style>
        <title>Mis citas</title>
    </head>
    <body>    
       <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        <% Paciente p=mp.getPaciente(); %>
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
                   <h2>Mis citas</h2>
    <div>
        <input  type="text" name="ValorBuscarCita"  placeholder="Buscar codigo" size="10">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar Cita'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
    </div><br>
    </form>   
    <div id="cajaListaCitas">
        <table>
            <thead>
            <tr>
                <td>Codigo</td>
                <td>Paciente</td>
                <td>Horario</td>
                <td>Fecha</td>
                <td>Estado</td>
                <td></td>
            </tr>
            </thead>
            <tbody> 
            <% for(int i=0;i<mp.getLisDet().size();i++){ %> 
            <% Cita c=(Cita)mp.getLisDet().get(i); %>
            <tr>
            <form action="ControlPaciente" method="Post">
                <td><input class="ListDato" type="text" name="idCita" value='<%= c.getCodigoCita() %>' size="3" readonly=""></td>
                <td><input class="ListDato" type="text" name="idPaciente" value='<%= c.getIdpac().getIDPac() %>' size="5" readonly=""></td>
                <td><input class="ListDato" type="text" value='<%= c.getIdHora().getIDHorario() %>' size="4" readonly=""></td>
                <td><input class="ListDato" type="text" value='<%= c.getFechaReg() %>' size="15" readonly=""></td>
                <td><input class="ListDato" type="text" value='<%= c.getEstado() %>' size="5" readonly=""></td>
                <td><input class="btnExaminarCita" type="submit" name="acc" value='Examinar' size="3"></td>
            </form>
            </tr>
            <% } %>
            </tbody>
        </table> 
    </div>
    <div class="CajaEditDatos">
        <table >
        <% Cita cit=mp.getCita(); %>
            <form action="ControlPaciente" method="Post">
                
                <input class="textOculto" type="text" name="IdPac" value='<%= p.getIDPac() %>' readonly="">
                <tr>
                    <td>Código:<br><input class="itemEditar" type="text" name="IDCitaAct" value='<%= cit.getCodigoCita() %>' readonly="" size="10"></td>
                    <td>Fecha:<br><input class="itemEditar"  type="text"  name="fechCitAct" value='<%= cit.getFechaReg() %>'  readonly=""></td>
                    <td>Estado:<br><input class="itemEditar"  type="text" name="estCitAct" value='<%= cit.getEstado()  %>'  readonly=""></td>
                </tr>
                <tr>
                    <td><br>PACIENTE</td>
                </tr>
                <tr>
                    <td>Id:<br><input class="itemEditar"  name="IDPacAct" type="text"  value='<%= cit.getIdpac().getIDPac() %>' readonly="" size="10"></td>  
                    <td>Nombre:<br><input class="itemEditar"  type="text" value='<%= cit.getIdpac().getNombrePac() %>' readonly=""></td>
                    <td>Apellidos:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdpac().getApellidoPatPac().concat(" "+cit.getIdpac().getApellidoMatPac()) %>' readonly=""></td>
                </tr>
                <tr>
                    <td><br>HORARIO</td>
                </tr>
                <tr>
                    <td>Local:<br><input class="itemEditar"  type="text" value='<%= cit.getIdHora().getLocal().getIDLocal() %>' readonly="" size="10"></td>
                    <td>Fecha:<br><input class="itemEditar"  type="text" value='<%= cit.getIdHora().getFecha() %>' readonly=""></td>
                    <td>Hora:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getHora() %>' readonly=""></td>
                </tr>
                <tr>
                    <td ><br>MÉDICO</td>
                </tr>
                <tr>
                    <td>Nombre:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getMedico().getNombre() %>'  readonly="" size="10"></td>
                    <td>Apellidos:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getMedico().getApellidoPatMed().concat(" "+cit.getIdHora().getMedico().getApellidoMatMed()) %>' readonly=""></td>
                    <td>Especialidad:<br><input class="itemEditar"  type="text"  value='<%= cit.getIdHora().getMedico().getIdTEMedico().getDescripcion() %>' readonly=""></td>
                </tr>
            
                <tr >
                    <td colspan="3" ><br>Comentario (*max 200 caracteres):
                 </tr >
                 <tr>
                     <td colspan="3"><input class="comentarioCita" type="text" name="comentarioCitAct"  value='<%= cit.getComentario() %>' ></td>
                 </tr>
                <tr>
                    <td colspan="3" class="msgRespuesta"><%= mp.getMsg() %></td>
                </tr>
                <tr>
                    <td colspan="3" style=" margin-top: -42px;"><input id="btnAnularCitaPac" type="submit" name="acc" value='Anular Cita' ></td>
                </tr >
            </form>
        </table>
                
    </div>
    </body>
</html>
