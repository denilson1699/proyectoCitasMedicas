<%-- 
    Document   : AdmBuscarHorario
    Created on : 31/05/2021, 05:35:05 PM
    Author     : jaram
--%>

<%@page import="negocio.TipoEspecialidadMedico"%>
<%@page import="negocio.Medico"%>
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
    padding-top: 70px;
    margin-bottom: 25px;
    text-align: center;
    color: #cf770e;
}
#tablaNuevoMedico{
    padding: 10px 10px 10px 10px;
    margin-left: 25%;
    background: aliceblue;
    border-radius: 7px;
}
#tablaNuevoMedico td{
    
    font-size: 13px;
    font-weight: 700;
    padding-bottom: 10px;
}
#tablaNuevoMedico input[type="text"],#tablaNuevoMedico input[type="time"],#tablaNuevoMedico input[type="date"],#tablaNuevoMedico input[type="email"],#tablaNuevoMedico input[type="number"]{
    border: solid 1px #cf770e;
    border-radius: 4px;
    height: 25px;
}
#tablaNuevoMedico select{
    border-radius: 4px;
    height: 25px;
    background-color: #88a6ba;
    color: white;
    width: 200px;
}

#tablaNuevoMedico input[type="submit"]:hover{
    transform: scale(1.2);

}
#btnNuevoMed{    
    border: none;
    width: 121px;
    border-radius: 3px;
    background: #417690;
    color: white;
    height: 38px;
    cursor: pointer;
    background-image: url(img/mas.png);
    background-size: 18px 18px;
    font-size: 12px;
    padding-left: 15px;
    background-repeat: no-repeat;
    background-position: 0.5rem center;
}
#btnReMed{
    border: none;
    width: 141px;
    border-radius: 3px;
    background: #417690;
    color: white;
    height: 38px;
    cursor: pointer;
    background-image: url(img/registrar.png);
    background-size: 18px 18px;
    font-size: 12px;
    padding-left: 15px;
    background-repeat: no-repeat;
        background-position: 0.5rem center;
    
}
#btnretroce{
    border: none;
    width: 141px;
    border-radius: 3px;
    background: #417690;
    color: white;
    height: 38px;
    cursor: pointer;
    background-image: url(img/atras.png);
    background-size: 18px 18px;
    font-size: 12px;
    padding-left: 15px;
    background-repeat: no-repeat;
    background-position: 0.5rem center;
    
}
                </style>
        <title>Medico</title>
    </head>
    <body>    
    <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
    <% Object[]IDAuto=mp.getFil(); %>
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
    <h2>Registrar Nuevo Médico</h2>
    <div id="CajaEditDatosHorario">
        <table id="tablaNuevoMedico">
        <% Medico med=mp.getMedico(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td><input id="btnNuevoMed" type="submit" name="acc" value='New Medico'></td>
                </tr>
                <tr>
                    <td>ID:<br><input type="text" name="IDMedAct" value='<%= IDAuto[0].toString() %>' readonly=""></td>
                    <td>DNI:<br><input type="text" name="DniMedAct" value='<%= med.getDniMed() %>' ></td>
                    <td>
                        <select name="estMedAct">
                            <option value="Activo">Activo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>nombre:<br><input type="text" name="nombMedAct"value='<%= med.getNombre() %>'></td>
                    <td>apellido paterno:<br><input type="text" name="apePaMedAct" value='<%= med.getApellidoPatMed() %>'></td>
                    <td>apellido Materno:<br><input type="text" name="apeMaMedAct" value='<%= med.getApellidoMatMed() %>'></td>  
                </tr>
                <tr>
                    <td>Password:<br><input type="text" name="password" value='<%= med.getPass() %>'></td>
                    <td>Telfono:<br><input type="number" name="TelfoMedAct" value='<%= med.getTelefono() %>'></td>
                    <td>Email:<br><input type="email" name="emailMedAct" value='<%= med.getEmail() %>'></td>
                </tr>
                <tr>
                    <td>Hora Ingreso:<br><input type="time" name="HingMedAct" value='<%= med.getHoraIngreso() %>'></td>
                    <td>Hora Salida:<br><input type="time" name="HsalMedAct" value='<%= med.getHoraSalida() %>'></td>
                </tr>
                <tr>
                    <td>
                        <select class="fi" name="IdTEMedAct">
                        <option class="" value='vacio'>Especialidad</option>
                        <% for(int i=0;i<mp.getLis1().size();i++){ %> 
                        <% TipoEspecialidadMedico TEM=(TipoEspecialidadMedico)mp.getLis1().get(i); %>
                        <option class="fi" value='<%= TEM.getIDTEMedico() %>'><%= TEM.getDescripcion() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td>
                        <select name="geneMedAct">
                            <option value="vacio">genero</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                        </select>
                    </td>
                    <td>
                        <select class="fi" name="IDEspMedAct">
                        <option class="" value='vacio'>Asistente</option>
                        <% for(int i=0;i<mp.getLis2().size();i++){ %> 
                        <% Especialista Esp=(Especialista)mp.getLis2().get(i); %>
                        <option class="fi" value='<%= Esp.getIDEspe() %>'><%= Esp.getNombreEsp().concat(Esp.getApellidoPatEsp()) %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input id="btnReMed" type="submit" name="acc" value='Registrar Medico' ></td>
                    <td><input id="btnretroce" type="submit" name="acc" value='Retroceder' ></td>
                </tr >
                <tr>
                    <td colspan="3" class="msgRespuesta"><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
