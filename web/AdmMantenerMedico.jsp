<%-- 
    Document   : AdmBuscarHorario
    Created on : 31/05/2021, 05:35:05 PM
    Author     : jaram
--%>

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
    padding-top: 50px;
    margin-bottom: 50px;
    text-align: center;
    color: #cf770e;
}     



</style>
        <title>Medico</title>
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
     <h2>Mantenimiento de Médicos</h2>
    <form action="ControlAdministrador" method="Post">

    <div>
        <input class="DatHorario" type="text" name="ValorABuscarMed" value='' placeholder="Buscar ID" size="10">
            <input class="btnBuscar" type="submit" name="acc" value='Buscar Medico'>
        <input class="btnNuevo" type="submit" name="acc" value='New Medico'>
        <input class="btnRegresar" type="submit" name="acc" value='Regresar'>
    </div><br>
    </form>   
     <div class="cajaLista" style="margin-left: 0px;">
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
            <% Medico p=(Medico)mp.getLisDet().get(i); %>
            <tr>
            <form action="ControlAdministrador" method="Post">
                <td><input class="ListDato" type="text" name="idMedico" value='<%= p.getIDMedico() %>' size="4"></td>
                <td><input class="ListDato" type="text" value='<%= p.getDniMed() %>' size="5"></td>
                <td><input class="ListDato" type="text" value='<%= p.getApellidoPatMed().concat(" "+p.getApellidoMatMed()) %>'></td>
                <td><input class="ListDato" type="text" value='<%= p.getNombre() %>' size="10"></td>
                <td><input class="btnItemElegido" type="submit" name="acc" value='Editar Medico'></td>
            </form>
            </tr>
            <% } %>
            </tbody>
        </table> 
    </div>
            <div class="CajaEditDatos" style="margin-left:70px; width: 45%">
        <table >
        <% Medico med=mp.getMedico(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td>ID:<br><input class="itemEditar"   type="text" name="IDMedAct" value='<%= med.getIDMedico()%>' readonly=""></td>
                    <td>DNI:<br><input class="itemEditar"   type="text" name="DniMedAct" value='<%= med.getDniMed() %>' ></td>
                    <td>Estado:<br><input class="itemEditar"   type="text" name="estMedAct" value='<%= med.getEstado() %>' ></td>
                </tr>
                <tr>
                    <td>nombre:<br><input class="itemEditar"   type="text" name="nombMedAct"value='<%= med.getNombre() %>'></td>
                    <td>apellido paterno:<br><input class="itemEditar"   type="text" name="apePaMedAct" value='<%= med.getApellidoPatMed() %>'></td>
                    <td>apellido Materno:<br><input class="itemEditar"   type="text" name="apeMaMedAct" value='<%= med.getApellidoMatMed() %>'></td>  
                </tr>
                <tr>
                    <td>genero:<br><input class="itemEditar"   type="text" name="geneMedAct" value='<%= med.getSexo() %>'></td>
                    <td>Telfono:<br><input class="itemEditar"   type="number" name="TelfoMedAct" value='<%= med.getTelefono() %>'></td>
                    <td>Email:<br><input class="itemEditar"   type="email" name="emailMedAct" value='<%= med.getEmail() %>'></td>
                </tr>
                <tr>
                    <td>Hora Ingreso:<br><input class="itemEditar"   name="HingMedAct" type="text"value='<%= med.getHoraIngreso() %>'></td>
                    <td>Hora Salida:<br><input class="itemEditar"   type="text" name="HsalMedAct" value='<%= med.getHoraSalida() %>'></td>
                    <td>Password:<br><input class="itemEditar"   type="text" name="password" value='<%= med.getPass() %>'></td>
                </tr>
                <tr>
                    <td>Especialidad</td>
                </tr>
                <tr>
                    <td>ID Especialidad:<br><input class="itemEditar"   type="text" name="IdTEMedAct" value='<%= med.getIdTEMedico().getIDTEMedico() %>' readonly=""></td>
                    <td>Descripcion:<br><input class="itemEditar"   type="text" name="" value='<%= med.getIdTEMedico().getDescripcion() %>'></td>
                </tr>
                <tr>
                <tr>
                    <td>Datos del Asistente Asignado</td>
                </tr>
                <td>ID Asistente:<br><input class="itemEditar"   type="text" name="IDEspMedAct" value='<%= med.getIdEsp().getIDEspe() %>' readonly="" ></td>
                    <td>Nombre:<br><input class="itemEditar"   type="text" name="passEspAct" value='<%= med.getIdEsp().getNombreEsp() %>'></td>
                </tr>
                <tr>
                    <td><input class="btnActualizar" type="submit" name="acc" value='Actualizar Medico' ></td>
                    <td><input class="btnEliminar"  type="submit" name="acc" value='Dar de baja Medico' ></td>
                </tr >
                <tr>
                    <td colspan="2" class="msgRespuesta"><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
