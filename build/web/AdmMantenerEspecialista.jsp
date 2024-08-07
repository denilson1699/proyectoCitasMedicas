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
        <title>Especialista</title>
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
     <h2>Mantenimiento de Especialistas</h2>
    <form action="ControlAdministrador" method="Post">

    <div>
        <input class="DatHorario" type="text" name="ValorABuscarEspe" value='' placeholder="Buscar ID" size="10">
        <input class="btnBuscar" type="submit" name="acc" value='Buscar Especialista'>
        <input class="btnNuevo" type="submit" name="acc" value='New Especialista'>
        <input class="btnRefescar" type="submit" name="acc" value='Refrescar Lista'>
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
            <% Especialista p=(Especialista)mp.getLisDet().get(i); %>
            <form action="ControlAdministrador" method="Post">
            <tr>
                <td><input class="ListDato" type="text" name="idespecialista" value='<%= p.getIDEspe() %>' size="5"></td>
                <td><input class="ListDato" type="text" value='<%= p.getDNIEsp() %>' size="8"></td>
                <td><input class="ListDato" type="text" value='<%= p.getApellidoPatEsp().concat(" "+p.getApellidoMatEsp()) %>' size="20"></td>
                <td><input class="ListDato" type="text" value='<%= p.getNombreEsp() %>' size="15"></td>
                <td><input class="btnItemElegido" type="submit" name="acc" value='Editar especialista'></td>
            </tr>
            </form>
            <% } %>
            </tbody>
        </table> 
    </div>
    <div class="CajaEditDatos" style="margin-left:100px; width: 45%"><br><br><br>
        <table >
        <% Especialista pac=mp.getEspesc(); %>
            <form action="ControlAdministrador" method="Post">
                <tr>
                    <td>ID:<br><input class="itemEditar"  type="text" name="IDEspAct" value='<%= pac.getIDEspe() %>' readonly=""></td>
                    <td>DNI:<br><input class="itemEditar"  type="text" name="DniEspAct" value='<%= pac.getDNIEsp() %>' ></td>
                    <td>Estado:<br><input class="itemEditar"  type="text" name="estEspAct" value='<%= pac.getEstadoEsp() %>' ></td>
                </tr>
                <tr>
                    <td>nombre:<br><input class="itemEditar"  type="text" name="nombEspAct"value='<%= pac.getNombreEsp() %>'></td>
                    <td>apellido paterno:<br><input class="itemEditar"  type="text" name="apePaEspAct" value='<%= pac.getApellidoPatEsp() %>'></td>
                    <td>apellido Materno:<br><input class="itemEditar"  type="text" name="apeMaEspAct" value='<%= pac.getApellidoMatEsp() %>'></td>  
                </tr>
                <tr>
                    <td>genero:<br><input class="itemEditar"  type="text" name="geneEspAct" value='<%= pac.getSexoEsp() %>'></td>
                    <td>Telfono:<br><input class="itemEditar"  type="number" name="TelfoEspAct" value='<%= pac.getTelefEsp() %>'></td>
                    <td>Email:<br><input class="itemEditar"  type="email" name="emailEspAct" value='<%= pac.getEmailEsp() %>'></td>
                </tr>
                <tr>
                    <td>Fecha de Registro:<br><input class="itemEditar"  name="fechEspAct" type="text"value='<%= pac.getFechaInscripEsp() %>'></td>
                    <td>Password:<br><input class="itemEditar"  type="text" name="passEspAct" value='<%= pac.getPassEsp() %>'></td>
                </tr>
                <tr>
                <td><input class="btnActualizar" type="submit" name="acc" value='Actualizar Especialista' ></td>
                <td><input class="btnRegristrar" type="submit" name="acc" value='Registrar Especialista' ></td>
                <td><input class="btnEliminar" type="submit" name="acc" value='Eliminar Especialista' ></td>
                </tr >
                <tr>
                    <td colspan="2"  class="msgRespuesta" ><%= mp.getMsg() %></td>
                </tr>
            </form>
        </table>
                
    </div>
    </body>
</html>
