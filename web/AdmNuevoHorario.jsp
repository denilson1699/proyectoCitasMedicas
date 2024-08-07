<%-- 
    Created on : 29/05/2021, 01:20:50 PM
    Author     : jaram
--%>

<%@page import="negocio.Local"%>
<%@page import="negocio.Medico"%>
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
#tablaNuevoHorraio{
    padding: 10px 10px 10px 10px;
    margin-left: 37%;
    background: aliceblue;
    border-radius: 7px;
}
#tablaNuevoHorraio td{
    
    font-size: 13px;
    font-weight: 700;
    padding-bottom: 10px;
}
#tablaNuevoHorraio input[type="text"],#tablaNuevoHorraio input[type="time"],#tablaNuevoHorraio input[type="date"]{
    border: solid 1px #cf770e;
    border-radius: 4px;
    height: 25px;
}
#tablaNuevoHorraio select{
        border-radius: 4px;
    height: 25px;
    background-color: #88a6ba;
    color: white;
    width: 250px;
}
#tablaNuevoHorraio input[type="submit"]{
    border: none;
    width: 121px;
    border-radius: 3px;
    background: #417690;
    color: white;
    height: 38px;
    cursor: pointer;
}
#tablaNuevoHorraio input[type="submit"]:hover{
    transform: scale(1.2);

}
        </style>
        <title>Nuevo Horario</title>
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
     <h2>Registrar Nuevo Horario</h2>
        <form action="ControlAdministrador" method="Post">
        <table id="tablaNuevoHorraio">
            <tr>
                <td>ID</td>
                <td><input type="text" name="IDHor" value='<%= IDAuto[0].toString() %>' readonly=""></td>
                
            </tr>
            <tr>
                <td>Fecha</td>
                <td><input type="date" name="fecha" value=''></td>
                
            </tr>
            <tr>
                <td>Hora</td>
                <td><input type="time" name="hora" value=''></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td><input type="text" name="estado" value='Disponible' readonly=""></td>
            </tr>
            <tr>
                <td>Datos del medico:</td>
            </tr>
            <tr>
                <td colspan="3">
                    <select class="fi" name="IDMedico">
                        <option class="" value='Medico'>Medico</option>
                    <% for(int i=0;i<mp.getLis1().size();i++){ %> 
                    <% Medico Med=(Medico)mp.getLis1().get(i); %>
                    <option class="fi" value='<%= Med.getIDMedico() %>'><%= Med.getNombre() %></option>
                    <% } %>
                   </select>
                </td>
            </tr>                  
            <tr>
                <td>Datos del Local:</td>
            </tr>
            <tr>
                <td colspan="3">
                    <select class="fi" name="IDLocal">
                    <option class="" value='Local'>Local</option>
                    <% for(int i=0;i<mp.getLis2().size();i++){ %> 
                    <% Local Loc=(Local)mp.getLis2().get(i); %>
                    <option class="fi" value='<%= Loc.getIDLocal() %>'><%= Loc.getDescripcionLocal() %></option>
                    <% } %>
                   </select>
                </td>
            </tr>
            <tr style="    text-align: center;">
                <td><input type="submit" name="acc" value='Registrar Horario' ></td>
                <td><input type="submit" name="acc" value='Atras' ></td>
            </tr>
            <tr>
                <td colspan="2" class="msgRespuesta"><%= mp.getMsg() %></td>
            </tr>
        </table>
        
       </form>
    </body>
</html>
