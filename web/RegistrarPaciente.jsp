<%-- 
    Document   : VistaHabitacion
    Created on : 28/10/2020, 07:58:25 PM
    Author     : Usuario
--%>

<%@page import="negocio.Paciente"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registrarse</title>
        <style> @import"Styles/cssRegistrarPaciente.css";
            input[type="submit"]:active{
    transform: scale(0.85);

}</style>
        
    </head>
    <body>
        <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        <% Paciente pac= (Paciente)mp.getPaciente(); %>
        
        <form action="ControlPaciente" memethod="Post" >
            <table>
                <tr>
                    <td colspan="2"><strong>Regístrate</strong></td>
                </tr>
                <tr>
                    <td ><input id="btnNuevo" type="submit" name="acc" value="Nuevo" ><input id="btnIniciarSession" type="submit" name="acc" value="Iniciar Sesion" /></td>

                </tr>
                <tr>
                    <td> <input class="noEditable" type="text" size="20" name="fecha" value='<%= pac.getFechaRegistroPac() %>'  readonly=""/></td>
                    <td> <input class="noEditable" type="text" size="20" name="codigo" value='<%= pac.getIDPac() %>'  readonly=""/></td>
                </tr>  
                <tr>
                    <td > <input type="text"  size="20" name="DNIPac" value='<%= pac.getDNIPac() %>' placeholder="DNI"/></td>       
                    <td><select name="GeneroPac">
                            <option value="Masculino">Genero</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> <input type="text" size="40" name="NombrePac" value='<%= pac.getNombrePac() %>' placeholder="Nombre"></td>
                    <td> <input  type="email" size="40" name="EmailPac" value='<%= pac.getEmailPac() %>' placeholder="Email"/></td>
                </tr>             
                <tr>
                    <td> <input type="text" size="40" name="ApellidoPatPac" value='<%= pac.getApellidoPatPac() %>' placeholder="Apellidos Paterno"/></td>
                    <td> <input  type="number" size="20" name="TelefPac" value='<%= pac.getTelefPac() %>' placeholder="Movil (+51)"/></td>
                </tr>               
                <tr>
                    <td> <input type="text" size="40" name="ApellidoMatPac" value='<%= pac.getApellidoMatPac() %>' placeholder="Apellidos Materno"/></td>
                    <td> <input  type="text" size="20" name="PassPac" value='<%= pac.getPassPac() %>' placeholder="Contraseña"/></td>
                </tr> 
                <tr>
                    <td colspan="2" id="msg"><%= mp.getMsg() %></td>
                </tr>
                <tr> 
                    <td colspan="2" ><input id="btnRegistrarCuenta" type="submit" name="acc" value="Registrar Cuenta" />  </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                </tr>
               
            </table> 
        </form>
        
            </div>
    </body>
</html>
