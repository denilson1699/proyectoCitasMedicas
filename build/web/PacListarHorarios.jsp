<%-- 
    Document   : PacGenerarCita
    Created on : 07/06/2021, 05:33:41 PM
    Author     : jaram
--%>

<%@page import="negocio.Paciente"%>
<%@page import="negocio.Horarios"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horarios </title>
        <style>@import"Styles/cssHeaderMenus.css";
@font-face{
	font-family: "yanone";
	src: url("fonts/yanone.ttf");
}
#tablaHorariosDisponibles{
    float: left;
    background: #115d746b;
    border-radius: 7px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    margin: 0px 170px auto;
    border-collapse: collapse;
    margin-bottom: 20px;
}
h2{
    float: left;
    width: 100%;
    height: 10px;
    padding-top: 70px;
    margin-bottom: 25px;
    text-align: center;
    color: #cf770e;
}


#tablaHorariosDisponibles thead tr td {
    text-align: center;
    color: #417690;
    font-weight: 900;
    color: white;
}
#tablaHorariosDisponibles tbody tr td {
    padding-bottom: 10px;
    padding-top: 10px;
}
#tablaHorariosDisponibles tbody tr td input[type="text"] {
    border: none;
    background: none;
}
#tablaHorariosDisponibles tbody tr td input[type="text"]:focus {
    outline: none;
}
.filaHorarioDisponible:nth-child(even){
    background-color: #ddd;
}
.filaHorarioDisponible:hover td{
    background-color: #115d746b;
    color: white;
}
th,td{
    padding: 10px;
}
.btnRegresar{
    width: 120px;
    border-radius: 4px;
    border: none;
    height: 30px;
    font-family: cursive;
    color: white;
    background: #417690c9;
    margin-bottom: 12px;
    cursor: pointer;
    background-image: url(img/atras.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position: 0.5rem center;
}
.btnelegirHorario{
    border: none;
    border-radius: 3px;
    margin-left: 3px;
    margin-right: 3px;
    font-family: cursive;
    color: white;
    background: #79aec8;
    cursor: pointer;
    font-size: 11px;
    width: 80px;
    height: 22px; 
    background-image: url(img/check.png);
    background-size: 15px 15px;
    background-repeat: no-repeat;
    background-position: left center;
}
.btnRegresar:hover, .btnelegirHorario:hover{
        transform: scale(0.85);
        background: #417690c9;
}
.textidPac{
    width:0px; overflow:hidden; height:0px; text-indent:-5000px; margin:0px; padding:0px;
}


       </style>
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
                   <h2>Horarios Disponibles</h2>
     <table id="tablaHorariosDisponibles">
            <thead>
                
                <tr>
                    <td colspan="2"><input class="btnRegresar"type="submit" name="acc" value="Regresar"></td>
                </tr>
            </form>
                <tr>
                    <td >ID</td>
                    <td>Medico</td>
                    <td>Especialidad</td>
                    <td>Local</td>
                    <td>Fecha</td>
                    <td>Hora</td>
                    <td>Estado</td>
                </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<mp.getLisHorario().size();i++){ %> 
            <% Horarios h=(Horarios)mp.getLisHorario().get(i); %>
            <form action="ControlPaciente" method="Post">
               
            <tr class="filaHorarioDisponible">
                <td><input class="DatHorario" type="text" name="idHorario" value='<%= h.getIDHorario() %>' size="5" readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getMedico().getNombre().concat(h.getMedico().getApellidoPatMed()) %>' readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getMedico().getIdTEMedico().getDescripcion() %>' size="10" readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getLocal().getDireccion() %>' size="15" readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getFecha() %>' size="5" readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getHora() %>' size="3" readonly=""></td>
                <td><input class="DatHorario" type="text" value='<%= h.getEstado() %>' size="5" readonly=""></td>
                <td><input class="btnelegirHorario" type="submit" name="acc" value='Elegir' size="15"></td >
                <td><input class="textidPac" type="text" name="idPaciente" value='<%= p.getIDPac() %>' size="1" readonly=""></td>
            </tr>
            </form>
            <% } %>
                
            </tbody>
        </table>
    </body>
    
</html>
