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
        <style>@import"Styles/cssHeaderMenus.css";@import"Styles/cssGeneral.css"; @import"Styles/cssConsultarCitas.css";
        
        
h2{
    float: left;
    width: 100%;
    height: 10px;
    padding-top: 70px;
    margin-bottom: 25px;
    text-align: center;
    color: #cf770e;
}
#btnAtenderCita{
    
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
    margin-bottom: 15px;
    background-image: url(img/check.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position:  1rem center;
}
#btnAtenderCita:hover{
        transform: scale(0.85);
        background: #417690c9;
}


        </style>
        <title>Citas</title>
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
    <h2>Consultar Citas</h2>
    <div>
        <input class="DatHorario" type="text" name="ValorBuscarCita" value='' placeholder="Buscar codigo">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar Cita'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
    </div><br>
    </form>   
    <div class="cajaLista">
        <table>
            <thead>
            <tr>
                <td>Codigo</td>
                <td>Paciente</td>
                <td>Horario</td>
                <td>Fecha</td>
                <td>Estado</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisDet().size();i++){ %> 
            <% Cita c=(Cita)mp.getLisDet().get(i); %>
            <form action="ControlEspecialista" method="Post">
            <tr>
                <td><input class="ListDato" type="text" name="idCita" value='<%= c.getCodigoCita() %>' size="3"></td>
                <td><input class="ListDato" type="text" name="idPaciente" value='<%= c.getIdpac().getIDPac() %>' size="3"></td>
                <td><input class="ListDato" type="text" value='<%= c.getIdHora().getIDHorario() %>' size="4"></td>
                <td><input class="ListDato" type="text" value='<%= c.getFechaReg() %>' size="15"></td>
                <td><input class="ListDato" type="text" value='<%= c.getEstado() %>' size="5"></td>
                <td><input class="btnExaminarCita" type="submit" name="acc" value='Examinar'></td>
                <td><input class="textOculto" type="text" name="IdEsp" value='<%= esp.getIDEspe() %>'></td>
            </tr>
            </form>
            <% } %>
            </tbody>
        </table> 
    </div>
    <div class="CajaEditDatos">
        <table >
        <% Cita cit=mp.getCita(); %>
            <form action="ControlEspecialista" method="Post">
                <tr>
                    <td><input class="textOculto" type="text" name="IdEspAct" value='<%= esp.getIDEspe() %>'readonly=""></td>
                </tr>
                <tr>
                    <td>codigo:<br><input class="itemEditar" type="text" name="IDCitaAct" value='<%= cit.getCodigoCita() %>' readonly=""></td>
                    <td>Fecha:<br><input class="itemEditar" type="text"  name="fechCitAct" value='<%= cit.getFechaReg() %>' ></td>
                    <td>Estado:<br><input class="itemEditar" type="text" name="estCitAct" value='<%= cit.getEstado()  %>' ></td>
                </tr>
                <tr>
                    <td>paciente:</td>
                </tr>
                <tr>
                    <td>ID:<br><input class="itemEditar" name="IDPacAct" type="text"  value='<%= cit.getIdpac().getIDPac() %>'></td>  
                    <td>nombre:<br><input class="itemEditar" type="text" value='<%= cit.getIdpac().getNombrePac() %>'></td>
                    <td>apellidos<br><input class="itemEditar" type="text"  value='<%= cit.getIdpac().getApellidoPatPac().concat(" "+cit.getIdpac().getApellidoMatPac()) %>'></td>
                </tr>
                <tr>
                    <td>Horario</td>
                </tr>
                <tr>
                    <td>Local:<br><input class="itemEditar" type="text" value='<%= cit.getIdHora().getLocal().getIDLocal() %>'></td>
                    <td>Fecha:<br><input class="itemEditar" type="text" value='<%= cit.getIdHora().getFecha() %>'></td>
                    <td>Hora:<br><input class="itemEditar" type="text"  value='<%= cit.getIdHora().getHora() %>'></td>
                </tr>
                <tr>
                    <td>Medico</td>
                </tr>
                <tr>
                    <td>Nombre:<br><input class="itemEditar" type="text"  value='<%= cit.getIdHora().getMedico().getNombre() %>'></td>
                    <td>Apelldios:<br><input class="itemEditar" type="text"  value='<%= cit.getIdHora().getMedico().getApellidoPatMed().concat(" "+cit.getIdHora().getMedico().getApellidoMatMed()) %>'></td>
                    <td>Especialidad:<br><input class="itemEditar" type="text"  value='<%= cit.getIdHora().getMedico().getIdTEMedico().getDescripcion() %>'></td>
                </tr>
            
                <tr>
                    <td colspan="3">Comentario (*opcional):<br><input class="comentarioCita" type="text" name="comentarioCitAct"  value='<%= cit.getComentario() %>' ></td>
                </tr >
                <tr>
                    <td colspan="3" class="msgRespuesta"><%= mp.getMsg() %></td>
                </tr>
                <tr style="text-align: center">
                    <td colspan="3" ><input id="btnAtenderCita" type="submit" name="acc" value='Cita Atendida' ></td>
                </tr >
            </form>
        </table>
                
    </div>
    </body>
</html>
