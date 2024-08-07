
package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.*;
import negocio.*;


@WebServlet(name = "ControlAdministrador", urlPatterns = {"/ControlAdministrador"})
public class ControlAdministrador extends HttpServlet {
    private ModeloPrincipal modPri;
    private ModeloLogin modLog;
    private ServicioPaciente serPac;
    private ServicioEspecialista serEsp;
    private ServicioAdministrador serAdm;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acc= request.getParameter("acc");

//------------------------------------------------
//ventana de Mantener Horarios Administrador****
//------------------------------------------------    
        if(acc.equals("Mantener Horarios")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            //Object[] datoLogin= {"",request.getParameter("dato1"),request.getParameter("dato2"),"",request.getParameter("dato3")};
            //modLog.setFil(datoLogin);
            modPri.setLisHorario(serAdm.verAllHorarios());
            modPri.setHorario(serAdm.nuevoHorario());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            //request.getSession().setAttribute("modLog", modLog);
            response.sendRedirect("AdmMantenerHorario.jsp");
        } 
        if(acc.equals("Buscar")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String valorbuscarHorario=request.getParameter("ValorABuscar").trim();
            if(valorbuscarHorario.equals("")){
                modPri.setLisHorario(serAdm.verAllHorarios());
                modPri.setHorario(serAdm.nuevoHorario());
                modPri.setMsg("Ingrese el ID del Horario");
            }else{
                Horarios hr=serAdm.buscarHorarioId(valorbuscarHorario);
                if(hr!=null){
                    //Convertimos un objecto horario en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisHorario(lis);
                    modPri.setHorario(serAdm.buscarHorarioId(valorbuscarHorario));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisHorario(serAdm.verAllHorarios());
                    modPri.setHorario(serAdm.nuevoHorario());
                    modPri.setMsg("*No existe un horario con el código "+valorbuscarHorario);
                        
                }    
            }
            request.getSession().setAttribute("modLog", modLog);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerHorario.jsp");
        }    
        
        
        if(acc.equals("New Registro")){    
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLis1(serAdm.verAllMedicos());
            modPri.setLis2(serAdm.verAllLocales());
            Object[] numeroIDAutGne ={serAdm.GenerarCodigoAuto("horario")};
            modPri.setFil(numeroIDAutGne);
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmNuevoHorario.jsp");
        } 
          
        if(acc.equals("Refrescar")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Horarios").forward(request, response);
        } 
        
        if(acc.equals("Regresar")){  
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            response.sendRedirect("MenuAdministrador.jsp");
        }
        
         if(acc.equals("Editar")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisHorario(serAdm.verAllHorarios());
            String idHor=request.getParameter("idHorario").trim();
            modPri.setHorario(serAdm.buscarHorarioId(idHor));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerHorario.jsp");
        } 
         
        if(acc.equals("Actualizar")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDHOrAct=request.getParameter("IDHOrAct").trim();
            String IDMediAct=request.getParameter("IDMediAct").trim();
            String IDLocalAct=request.getParameter("IDLocalAct").trim();
            String NuevaFechaAct=request.getParameter("NuevaFechaAct").trim();
            String NuevaHoraAct=request.getParameter("NuevaHoraAct").trim();
            String estado=request.getParameter("estado").trim();
            if (IDHOrAct.equalsIgnoreCase("")){
                modPri.setHorario(serAdm.nuevoHorario());;
                modPri.setMsg("*Debe elegir un Horario");
            }
            else{
                if(NuevaFechaAct.equalsIgnoreCase("")|| NuevaHoraAct.equalsIgnoreCase("")){
                    modPri.setHorario(serAdm.buscarHorarioId(IDHOrAct));
                    modPri.setMsg("*Eliga una fecha y una hora");  
                }
                else{
                  modPri.setMsg(serAdm.MantenerHorario("2",IDHOrAct, IDMediAct, IDLocalAct,NuevaFechaAct, NuevaHoraAct,estado));
                  modPri.setHorario(serAdm.buscarHorarioId(IDHOrAct));
                }
            }
            modPri.setLisHorario(serAdm.verAllHorarios());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerHorario.jsp");
        }
        
        if(acc.equals("Eliminar")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisHorario(serAdm.verAllHorarios());
            String IDHOrAct=request.getParameter("IDHOrAct").trim();
            if (IDHOrAct.equalsIgnoreCase("")){
                modPri.setHorario(serAdm.nuevoHorario());;
                modPri.setMsg("*Debe elegir un Horario");
            }else{
                modPri.setHorario(serAdm.nuevoHorario());
                modPri.setMsg(serAdm.MantenerHorario("3",IDHOrAct, "", "","", "",""));
            }
            modPri.setLisHorario(serAdm.verAllHorarios());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerHorario.jsp");
        }
            

        // --------------------------------
        //ventana de Registro Nuevo Horarios Administrador****
        //---------------------------------    

         if(acc.equals("Registrar Horario")){
            modPri= new ModeloPrincipal();
            serAdm= new ServicioAdministradorImp();
            String IDHOr=request.getParameter("IDHor").trim();
            String IDMedico=request.getParameter("IDMedico").trim();
            String IDLocal=request.getParameter("IDLocal").trim();
            String fecha=request.getParameter("fecha").trim();
            String hora=request.getParameter("hora").trim();
            String estado=request.getParameter("estado").trim();
            if(IDMedico.equalsIgnoreCase("Medico")|| IDLocal.equalsIgnoreCase("Local")||fecha.equalsIgnoreCase("")||hora.equalsIgnoreCase("")){
                modPri.setMsg("*Complete todos los campos");
            }else{
                 modPri.setMsg(serAdm.MantenerHorario("1", IDHOr, IDMedico, IDLocal, fecha, hora,estado));
            }
            modPri.setLis1(serAdm.verAllMedicos());
            modPri.setLis2(serAdm.verAllLocales());
            Object[] numeroIDAutGne ={serAdm.GenerarCodigoAuto("horario")};
            modPri.setFil(numeroIDAutGne);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmNuevoHorario.jsp");
         }
        
        if(acc.equals("Atras")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Horarios").forward(request, response);
        }
        
 // ---------------------------------------------
 //ventana de Mnatener PACIENTE Administrador****
 //----------------------------------------------    
        
        if(acc.equals("Mantener Pacientes")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            modPri.setLisDet(serAdm.verAllPacientes());
            modPri.setPaciente(serAdm.nuevoPaciente());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        }
        
        if(acc.equals("Buscar paciente")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorABuscarPaciente").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serAdm.verAllPacientes());
                modPri.setPaciente(serAdm.nuevoPaciente());
                modPri.setMsg("Ingrese el ID del paciente");
            }else{
                Paciente hr=serAdm.buscarPacienteID(idBuscar);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setPaciente(serAdm.buscarPacienteID(idBuscar));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serAdm.verAllPacientes());
                    modPri.setPaciente(serAdm.nuevoPaciente());
                    modPri.setMsg("*No existe un paciente con el código "+idBuscar);
                        
                }    
            }
            request.getSession().setAttribute("modLog", modLog);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        }    
        
        
        if(acc.equals("New paciente")){    
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllPacientes());
            Paciente pac= new Paciente(serAdm.GenerarCodigoAuto("paciente"), "", "", "", "", "", "", "",serAdm.GenerarFecActual(), "Activo", "");
            modPri.setPaciente(pac);
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        } 
          
        if(acc.equals("Refrescar pacientes")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Pacientes").forward(request, response);
        } 
        

         if(acc.equals("Editar Paciente")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllPacientes());
            String idHor=request.getParameter("idpaciente").trim();
            modPri.setPaciente(serAdm.buscarPacienteID(idHor));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        } 
         
        if(acc.equals("Actualizar Paciente")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDPacAct=request.getParameter("IDPacAct").trim();
            String DniPacAct=request.getParameter("DniPacAct").trim();
            String apePaPacAct=request.getParameter("apePaPacAct").trim();
            String apeMaPacAct=request.getParameter("apeMaPacAct").trim();
            String nombPacAct=request.getParameter("nombPacAct").trim();
            String emailPacAct=request.getParameter("emailPacAct").trim();
            String genePacAct=request.getParameter("genePacAct").trim();
            String TelfoPacAct=request.getParameter("TelfoPacAct").trim();
            String fechPacAct=request.getParameter("fechPacAct").trim();
            String estPacAct=request.getParameter("estPacAct").trim();
            String passPacAct=request.getParameter("passPacAct").trim();
            Paciente llenadoPac= new Paciente(IDPacAct, DniPacAct,apePaPacAct,apeMaPacAct, nombPacAct, genePacAct, emailPacAct, TelfoPacAct, fechPacAct, estPacAct, passPacAct);
            Paciente busPac= serAdm.buscarPacienteID(IDPacAct);
            if (IDPacAct.equalsIgnoreCase("")|| busPac==null){
                modPri.setPaciente(llenadoPac);
                modPri.setMsg("*Debe elegir un paciente existente");
            }
           else{
                if(DniPacAct.equalsIgnoreCase("")|| apePaPacAct.equalsIgnoreCase("")|| apeMaPacAct.equalsIgnoreCase("")|| nombPacAct.equalsIgnoreCase("")
                        || emailPacAct.equalsIgnoreCase("")|| genePacAct.equalsIgnoreCase("")|| TelfoPacAct.equalsIgnoreCase("")|| fechPacAct.equalsIgnoreCase("")
                        || estPacAct.equalsIgnoreCase("")|| passPacAct.equalsIgnoreCase("")){
                    modPri.setPaciente(llenadoPac);
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    if (DniPacAct.length()!=8 || TelfoPacAct.length()!=9||passPacAct.length()>=16) {
                        modPri.setPaciente(llenadoPac);
                        modPri.setMsg("*Verifique el dni (*"+DniPacAct.length()+") telfono (*"+TelfoPacAct.length()+") password (*"+passPacAct.length()+")"); 
                    }else{
                        if (genePacAct.equalsIgnoreCase("M")|| genePacAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerPaceinte("2", IDPacAct, DniPacAct, apePaPacAct,apeMaPacAct,nombPacAct,genePacAct,emailPacAct, TelfoPacAct, fechPacAct, estPacAct,passPacAct));
                            modPri.setPaciente(llenadoPac);
                        }
                        else{
                            modPri.setPaciente(llenadoPac);
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                    }
                }
            }
            modPri.setLisDet(serAdm.verAllPacientes());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        }
        
        if(acc.equals("Eliminar Paciente")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllPacientes());
            String IDPacAct=request.getParameter("IDPacAct").trim();
            if (IDPacAct.equalsIgnoreCase("")){
                modPri.setPaciente(serAdm.nuevoPaciente());;
                modPri.setMsg("*Debe elegir un paciente");
            }else{
                modPri.setPaciente(serAdm.nuevoPaciente());
                modPri.setMsg(serAdm.MantenerPaceinte("3", IDPacAct, "", "", "", "", "", "", "", "", "", ""));
            }
            modPri.setLisDet(serAdm.verAllPacientes());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        }
         
         if(acc.equals("Registrar Paciente")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDPacAct=request.getParameter("IDPacAct").trim();
            String DniPacAct=request.getParameter("DniPacAct").trim();
            String apePaPacAct=request.getParameter("apePaPacAct").trim();
            String apeMaPacAct=request.getParameter("apeMaPacAct").trim();
            String nombPacAct=request.getParameter("nombPacAct").trim();
            String emailPacAct=request.getParameter("emailPacAct").trim();
            String genePacAct=request.getParameter("genePacAct").trim();
            String TelfoPacAct=request.getParameter("TelfoPacAct").trim();
            String fechPacAct=request.getParameter("fechPacAct").trim();
            String estPacAct=request.getParameter("estPacAct").trim();
            String passPacAct=request.getParameter("passPacAct").trim();
            Paciente llenadoPac= new Paciente(IDPacAct, DniPacAct,apePaPacAct,apeMaPacAct, nombPacAct, genePacAct, emailPacAct, TelfoPacAct, fechPacAct, "Activo", passPacAct);
            if (IDPacAct.equalsIgnoreCase("")){
                modPri.setPaciente(llenadoPac);
                modPri.setMsg("*presione en new paciente para generar codigo y continuar");
            }
            else{
                if(DniPacAct.equalsIgnoreCase("")|| apePaPacAct.equalsIgnoreCase("")|| apeMaPacAct.equalsIgnoreCase("")|| nombPacAct.equalsIgnoreCase("")
                        || emailPacAct.equalsIgnoreCase("")|| genePacAct.equalsIgnoreCase("")|| TelfoPacAct.equalsIgnoreCase("")|| fechPacAct.equalsIgnoreCase("")
                        || estPacAct.equalsIgnoreCase("")|| passPacAct.equalsIgnoreCase("")){
                    modPri.setPaciente(llenadoPac);
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    if (DniPacAct.length()!=8 || TelfoPacAct.length()!=9||passPacAct.length()>=16) {
                        modPri.setPaciente(llenadoPac);
                        modPri.setMsg("*Verifique el dni (*"+DniPacAct.length()+") telfono (*"+TelfoPacAct.length()+") password (*"+passPacAct.length()+")"); 
                    }else{
                        if (genePacAct.equalsIgnoreCase("M")|| genePacAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerPaceinte("1", IDPacAct, DniPacAct, apePaPacAct,apeMaPacAct,nombPacAct,genePacAct,emailPacAct, TelfoPacAct, fechPacAct, "Activo",passPacAct));
                            modPri.setPaciente(llenadoPac);
                        }
                        else{
                            modPri.setPaciente(llenadoPac);
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                    }
                }
            }
            modPri.setLisDet(serAdm.verAllPacientes());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerpaciente.jsp");
        }

        
         
         
          // --------------------------------
        //ventana de Mnatener ESPECIALISTA Administrador****
        //---------------------------------    
        
        if(acc.equals("Mantener Especialistas")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            modPri.setLisDet(serAdm.verAllEspecialistas());
            modPri.setEspesc(serAdm.nuevoEspecialista());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        }
        
        if(acc.equals("Buscar Especialista")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorABuscarEspe").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serAdm.verAllEspecialistas());
                modPri.setEspesc(serAdm.nuevoEspecialista());
                modPri.setMsg("Ingrese el ID del Especialista");
            }else{
                Especialista hr=serAdm.buscarEspecialistaID(idBuscar);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setEspesc(serAdm.buscarEspecialistaID(idBuscar));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serAdm.verAllEspecialistas());
                    modPri.setEspesc(serAdm.nuevoEspecialista());
                    modPri.setMsg("*No existe un especialista con el código "+idBuscar);
                        
                }    
            }
            request.getSession().setAttribute("modLog", modLog);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        }    
        
        
        if(acc.equals("New Especialista")){    
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllEspecialistas());
            Especialista esp= new Especialista(serAdm.GenerarCodigoAuto("especialista"), "", "", "", "", "", "", "",serAdm.GenerarFecActual(), "", "");
            modPri.setEspesc(esp);
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        } 
          
        if(acc.equals("Refrescar Lista")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Especialistas").forward(request, response);
        } 
        

         if(acc.equals("Editar especialista")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllEspecialistas());
            String idEsp=request.getParameter("idespecialista").trim();
            modPri.setEspesc(serAdm.buscarEspecialistaID(idEsp));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        } 
         
        if(acc.equals("Actualizar Especialista")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDEspAct=request.getParameter("IDEspAct").trim();
            String DniEspAct=request.getParameter("DniEspAct").trim();
            String estEspAct=request.getParameter("estEspAct").trim();
            String nombEspAct=request.getParameter("nombEspAct").trim();
            String apePaEspAct=request.getParameter("apePaEspAct").trim();
            String apeMaEspAct=request.getParameter("apeMaEspAct").trim();
            String geneEspAct=request.getParameter("geneEspAct").trim();
            String TelfoEspAct=request.getParameter("TelfoEspAct").trim();
            String emailEspAct=request.getParameter("emailEspAct").trim();
            String fechEspAct=request.getParameter("fechEspAct").trim();
            String passEspAct=request.getParameter("passEspAct").trim();
            Especialista llenandoEsp= new Especialista(IDEspAct, DniEspAct, apePaEspAct, apeMaEspAct, nombEspAct,geneEspAct, emailEspAct, TelfoEspAct, fechEspAct, estEspAct, passEspAct);
            if (IDEspAct.equalsIgnoreCase("")){
                modPri.setEspesc(serAdm.nuevoEspecialista());;
                modPri.setMsg("*Debe elegir un especialista");
            }
            else{
                if(DniEspAct.equalsIgnoreCase("")|| estEspAct.equalsIgnoreCase("")|| nombEspAct.equalsIgnoreCase("")|| apePaEspAct.equalsIgnoreCase("")
                        || apeMaEspAct.equalsIgnoreCase("")|| geneEspAct.equalsIgnoreCase("")|| TelfoEspAct.equalsIgnoreCase("")|| emailEspAct.equalsIgnoreCase("")
                        || fechEspAct.equalsIgnoreCase("")|| passEspAct.equalsIgnoreCase("")){
                    modPri.setEspesc(serAdm.nuevoEspecialista());
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    if (DniEspAct.length()!=8 || TelfoEspAct.length()!=9||passEspAct.length()>=16) {
                        modPri.setEspesc(llenandoEsp);
                        modPri.setMsg("*Verifique el dni (*"+DniEspAct.length()+") telfono (*"+TelfoEspAct.length()+") password (*"+passEspAct.length()+")"); 
                    }else{
                        if (geneEspAct.equalsIgnoreCase("M")|| geneEspAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerEspecialista("2", IDEspAct, DniEspAct, apePaEspAct,apeMaEspAct, nombEspAct, geneEspAct, TelfoEspAct,emailEspAct, fechEspAct, passEspAct,estEspAct));
                            modPri.setEspesc(serAdm.buscarEspecialistaID(IDEspAct));
                        }
                        else{
                            modPri.setEspesc(llenandoEsp);
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                   }
                }
            }
            modPri.setLisDet(serAdm.verAllEspecialistas());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        }
        
        if(acc.equals("Eliminar Especialista")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllEspecialistas());
            String IDEspAct=request.getParameter("IDEspAct").trim();
            if (IDEspAct.equalsIgnoreCase("")){
                modPri.setEspesc(serAdm.nuevoEspecialista());
                modPri.setMsg("*Debe elegir un especialista");
            }else{
                modPri.setEspesc(serAdm.nuevoEspecialista());
                modPri.setMsg(serAdm.MantenerEspecialista("3", IDEspAct, "", "", "", "", "", "", "", "", "", ""));
            }
            modPri.setLisDet(serAdm.verAllEspecialistas());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        }
         
        if(acc.equals("Registrar Especialista")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDEspAct=request.getParameter("IDEspAct").trim();
            String DniEspAct=request.getParameter("DniEspAct").trim();
            String estEspAct=request.getParameter("estEspAct").trim();
            String nombEspAct=request.getParameter("nombEspAct").trim();
            String apePaEspAct=request.getParameter("apePaEspAct").trim();
            String apeMaEspAct=request.getParameter("apeMaEspAct").trim();
            String geneEspAct=request.getParameter("geneEspAct").trim();
            String TelfoEspAct=request.getParameter("TelfoEspAct").trim();
            String emailEspAct=request.getParameter("emailEspAct").trim();
            String fechEspAct=request.getParameter("fechEspAct").trim();
            String passEspAct=request.getParameter("passEspAct").trim();
            Especialista llenandoEsp= new Especialista(IDEspAct, DniEspAct, apePaEspAct, apeMaEspAct, nombEspAct,geneEspAct, emailEspAct, TelfoEspAct, fechEspAct, "Activo", passEspAct);
            if (IDEspAct.equalsIgnoreCase("")){
                modPri.setEspesc(serAdm.nuevoEspecialista());
                modPri.setMsg("*Presione new especialista para generar codigo y continuar");
            }
            else{
                if(DniEspAct.equalsIgnoreCase("")|| estEspAct.equalsIgnoreCase("")|| nombEspAct.equalsIgnoreCase("")|| apePaEspAct.equalsIgnoreCase("")
                        || apeMaEspAct.equalsIgnoreCase("")|| geneEspAct.equalsIgnoreCase("")|| TelfoEspAct.equalsIgnoreCase("")|| emailEspAct.equalsIgnoreCase("")
                        || fechEspAct.equalsIgnoreCase("")|| passEspAct.equalsIgnoreCase("")){
                    modPri.setEspesc(llenandoEsp);
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    
                    if (DniEspAct.length()!=8 || TelfoEspAct.length()!=9||passEspAct.length()>=16) {
                        modPri.setEspesc(llenandoEsp);
                        modPri.setMsg("*Verifique el dni (*"+DniEspAct.length()+") telfono (*"+TelfoEspAct.length()+") password (*"+passEspAct.length()+")"); 
                    }else{
                        if (geneEspAct.equalsIgnoreCase("M")|| geneEspAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerEspecialista("1", IDEspAct, DniEspAct, apePaEspAct, apeMaEspAct,nombEspAct, geneEspAct, TelfoEspAct, emailEspAct,fechEspAct, passEspAct,"Activo"));
                            modPri.setEspesc(llenandoEsp);
                        }
                        else{
                            modPri.setEspesc(llenandoEsp);
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                   }
                }
            }
            modPri.setLisDet(serAdm.verAllEspecialistas());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerEspecialista.jsp");
        }

      
             
          // --------------------------------
        //ventana de Mnatener CITAS Administrador****
        //---------------------------------    
        if(acc.equals("Mantener Citas")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            modPri.setLisDet(serAdm.verAllCitas());
            modPri.setCita(serAdm.NuevaCita());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerCitas.jsp");
        }
        
        if(acc.equals("Buscar Cita")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorBuscarCita").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serAdm.verAllCitas());
                modPri.setCita(serAdm.NuevaCita());
                modPri.setMsg("Ingrese el ID de la Cita");
            }else{
                Cita hr=serAdm.buscarCitaID(idBuscar);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setCita(serAdm.buscarCitaID(idBuscar));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serAdm.verAllCitas());
                    modPri.setCita(serAdm.NuevaCita());
                    modPri.setMsg("*No existe una cita con el código "+idBuscar);
                        
                }    
            }
            request.getSession().setAttribute("modLog", modLog);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerCitas.jsp");
        }    
          
        if(acc.equals("Refrescar Citas")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Citas").forward(request, response);
        } 
        

         if(acc.equals("Editar Cita")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllCitas());
            String IDCitaAct=request.getParameter("idCita").trim();
            modPri.setCita(serAdm.buscarCitaID(IDCitaAct));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerCitas.jsp");
        } 
         
        if(acc.equals("Actualizar Cita")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDCitaAct=request.getParameter("IDCitaAct").trim();
            String IDPacAct=request.getParameter("IDPacAct").trim();
            String IDHorarioAct=request.getParameter("IDHorarioAct").trim();
            String fechCitAct=request.getParameter("fechCitAct").trim();
            String estCitAct=request.getParameter("estCitAct").trim();
            String comentarioCitAct=request.getParameter("comentarioCitAct").trim();
            if (IDCitaAct.equalsIgnoreCase("")){
                modPri.setCita(serAdm.NuevaCita());
                modPri.setMsg("*Debe elegir una Cita");
            }
            else{
                if(IDCitaAct.equalsIgnoreCase("")|| IDPacAct.equalsIgnoreCase("")|| IDHorarioAct.equalsIgnoreCase("")|| 
                        fechCitAct.equalsIgnoreCase("") || estCitAct.equalsIgnoreCase("")){
                    modPri.setCita(serAdm.NuevaCita());
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    modPri.setMsg(serAdm.MantenerCitas("2", IDCitaAct, IDPacAct, IDHorarioAct, fechCitAct, estCitAct, comentarioCitAct));
                    modPri.setCita(serAdm.buscarCitaID(IDCitaAct));
                }
            }
            modPri.setLisDet(serAdm.verAllCitas());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerCitas.jsp");
        }
        
         
        if(acc.equals("Dar de baja")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllCitas());
            String IDCitaAct=request.getParameter("IDCitaAct").trim();
            if (IDCitaAct.equalsIgnoreCase("")){
                modPri.setCita(serAdm.NuevaCita());;
                modPri.setMsg("*Debe elegir una cita");
            }else{
                modPri.setCita(serAdm.NuevaCita());
                modPri.setMsg(serAdm.MantenerCitas("3", IDCitaAct, "", "", "", "", ""));
            }
            modPri.setLisDet(serAdm.verAllCitas());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerCitas.jsp");
        }
        
        
//-------------------------------------------
//ventana de Mnatener Medicos Administrador****
//-------------------------------------------  
        if(acc.equals("Mantener Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            modPri.setLisDet(serAdm.verAllMedicos());
            modPri.setMedico(serAdm.nuevoMedico());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerMedico.jsp");
        }
        if(acc.equals("Buscar Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorABuscarMed").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serAdm.verAllMedicos());
                modPri.setMedico(serAdm.nuevoMedico());
                modPri.setMsg("Ingrese el ID del medico");
            }else{
                Medico hr=serAdm.buscarMedidoID(idBuscar);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setMedico(serAdm.buscarMedidoID(idBuscar));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serAdm.verAllMedicos());
                    modPri.setMedico(serAdm.nuevoMedico());
                    modPri.setMsg("*No existe una medico con el código "+idBuscar);
                        
                }    
            }
            request.getSession().setAttribute("modLog", modLog);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerMedico.jsp");
        }    
        
        if(acc.equals("New Medico")){    
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            Object[] numeroIDAutGne ={serAdm.GenerarCodigoAuto("medico")};
            modPri.setFil(numeroIDAutGne);
            modPri.setLis1(serAdm.verAllTipoEspecialidadMedico());
            modPri.setLis2(serAdm.verAllEspecialistas());
            modPri.setMedico(serAdm.nuevoMedico());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmNuevoMedico.jsp");
        } 

         if(acc.equals("Editar Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllMedicos());
            String idMedico=request.getParameter("idMedico").trim();
            modPri.setMedico(serAdm.buscarMedidoID(idMedico));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerMedico.jsp");
        } 

         
        if(acc.equals("Actualizar Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDMedAct=request.getParameter("IDMedAct").trim();
            String DniMedAct=request.getParameter("DniMedAct").trim();
            String estMedAct=request.getParameter("estMedAct").trim();
            String nombMedAct=request.getParameter("nombMedAct").trim();
            String apePaMedAct=request.getParameter("apePaMedAct").trim();
            String apeMaMedAct=request.getParameter("apeMaMedAct").trim();
            String geneMedAct=request.getParameter("geneMedAct").trim();
            String TelfoMedAct=request.getParameter("TelfoMedAct").trim();
            String emailMedAct=request.getParameter("emailMedAct").trim();
            String HingMedAct=request.getParameter("HingMedAct").trim();
            String HsalMedAct=request.getParameter("HsalMedAct").trim();
            String IdTEMedAct=request.getParameter("IdTEMedAct").trim();
            String IDEspMedAct=request.getParameter("IDEspMedAct").trim();
            String password=request.getParameter("password").trim();
            Medico llenarMed= serAdm.llenandoNuevoMedico(DniMedAct, apePaMedAct, apeMaMedAct, nombMedAct, geneMedAct, TelfoMedAct, emailMedAct, HingMedAct, HsalMedAct, password, estMedAct);
            if (IDMedAct.equalsIgnoreCase("")){
                modPri.setMedico(serAdm.nuevoMedico());
                modPri.setMsg("*Debe elegir un medico");
            }
            else{
                if(DniMedAct.equalsIgnoreCase("")|| estMedAct.equalsIgnoreCase("")|| nombMedAct.equalsIgnoreCase("")|| 
                        apePaMedAct.equalsIgnoreCase("") || apeMaMedAct.equalsIgnoreCase("") || geneMedAct.equalsIgnoreCase("")
                         || TelfoMedAct.equalsIgnoreCase("") || emailMedAct.equalsIgnoreCase("") || HingMedAct.equalsIgnoreCase("")
                         || HsalMedAct.equalsIgnoreCase("") || IdTEMedAct.equalsIgnoreCase("") || IDEspMedAct.equalsIgnoreCase("")||password.equalsIgnoreCase("")){
                    modPri.setMedico(llenarMed);
                    modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    if (DniMedAct.length()!=8 || TelfoMedAct.length()!=9||password.length()>=16) {
                        modPri.setMedico(llenarMed);
                        modPri.setMsg("*Verifique el dni (*"+DniMedAct.length()+") telfono (*"+TelfoMedAct.length()+") password (*"+password.length()+")"); 
                    }else{
                        if (geneMedAct.equalsIgnoreCase("M")|| geneMedAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerMedico("2", IDMedAct, IDEspMedAct, IdTEMedAct, DniMedAct, apePaMedAct, apeMaMedAct, nombMedAct, geneMedAct, TelfoMedAct, emailMedAct, HingMedAct, HsalMedAct,password, estMedAct));
                            modPri.setMedico(serAdm.buscarMedidoID(IDMedAct));
                        }
                        else{
                            modPri.setMedico(llenarMed);
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                   }
                }
            }
            modPri.setLisDet(serAdm.verAllMedicos());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerMedico.jsp");
        }
        
         
        if(acc.equals("Dar de baja Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllMedicos());
            String IDMedAct=request.getParameter("IDMedAct").trim();
            if (IDMedAct.equalsIgnoreCase("")){
                modPri.setMedico(serAdm.nuevoMedico());
                modPri.setMsg("*Debe elegir una medico");
            }else{
                modPri.setMedico(serAdm.nuevoMedico());
                modPri.setMsg(serAdm.MantenerMedico("3", IDMedAct, "", "", "", "", "", "", "", "", "", "", "", "", ""));
            }
            modPri.setLisDet(serAdm.verAllMedicos());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmMantenerMedico.jsp");
        }
        
/*------------------------------------
VENTANA DE NUEVO RESTRITO DE MEDICO***
------------------------------------*/
        if(acc.equals("Registrar Medico")){
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IDMedAct=request.getParameter("IDMedAct").trim();
            String DniMedAct=request.getParameter("DniMedAct").trim();
            String estMedAct=request.getParameter("estMedAct").trim();
            String nombMedAct=request.getParameter("nombMedAct").trim();
            String apePaMedAct=request.getParameter("apePaMedAct").trim();
            String apeMaMedAct=request.getParameter("apeMaMedAct").trim();
            String geneMedAct=request.getParameter("geneMedAct").trim();
            String TelfoMedAct=request.getParameter("TelfoMedAct").trim();
            String emailMedAct=request.getParameter("emailMedAct").trim();
            String HingMedAct=request.getParameter("HingMedAct").trim();
            String HsalMedAct=request.getParameter("HsalMedAct").trim();
            String IdTEMedAct=request.getParameter("IdTEMedAct").trim();
            String IDEspMedAct=request.getParameter("IDEspMedAct").trim();
            String password=request.getParameter("password").trim();
            Object[] numeroIDAutGne ={serAdm.GenerarCodigoAuto("medico")};
            modPri.setFil(numeroIDAutGne);
            Medico llenandomed=serAdm.llenandoNuevoMedico(DniMedAct, apePaMedAct, apeMaMedAct, nombMedAct, geneMedAct, TelfoMedAct, emailMedAct, HingMedAct, HsalMedAct, password, estMedAct);
             if (IDMedAct.equalsIgnoreCase("")){
                modPri.setFil(numeroIDAutGne);
                modPri.setLis1(serAdm.verAllTipoEspecialidadMedico());
                modPri.setLis2(serAdm.verAllEspecialistas());
                modPri.setMedico(llenandomed);
                modPri.setMsg("*complete todos los campos");
            }
            else{
                if(DniMedAct.equalsIgnoreCase("")|| estMedAct.equalsIgnoreCase("")|| nombMedAct.equalsIgnoreCase("")|| 
                        apePaMedAct.equalsIgnoreCase("") || apeMaMedAct.equalsIgnoreCase("") || geneMedAct.equalsIgnoreCase("vacio")
                         || TelfoMedAct.equalsIgnoreCase("") || emailMedAct.equalsIgnoreCase("") || HingMedAct.equalsIgnoreCase("")
                         || HsalMedAct.equalsIgnoreCase("") || IdTEMedAct.equalsIgnoreCase("vacio") || IDEspMedAct.equalsIgnoreCase("")||password.equalsIgnoreCase("")){
                        modPri.setMedico(llenandomed);
                        modPri.setMsg("*Complete todos los campos");  
                }
                else{
                    if (DniMedAct.length()!=8 || TelfoMedAct.length()!=9||password.length()>=16) {
                        modPri.setMedico(llenandomed);
                        modPri.setMsg("*Verifique el dni (*"+DniMedAct.length()+") telfono (*"+TelfoMedAct.length()+") password (*"+password.length()+")"); 
                    
                    }else{
                        if (geneMedAct.equalsIgnoreCase("M")|| geneMedAct.equalsIgnoreCase("F")) {
                            modPri.setMsg(serAdm.MantenerMedico("1", IDMedAct, IDEspMedAct, IdTEMedAct, DniMedAct, apePaMedAct, apeMaMedAct, nombMedAct, geneMedAct, TelfoMedAct, emailMedAct, HingMedAct, HsalMedAct,password, estMedAct));
                            modPri.setMedico(serAdm.buscarMedidoID(IDMedAct));
                        }
                        else{
                            
                            modPri.setMsg("*ingrese M para masculino o F para femenino"); 
                        }
                    }
                }
            }
            modPri.setFil(numeroIDAutGne);
            modPri.setLis1(serAdm.verAllTipoEspecialidadMedico());
            modPri.setLis2(serAdm.verAllEspecialistas());
                        
            modPri.setLisDet(serAdm.verAllMedicos());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("AdmNuevoMedico.jsp");
        }

        if(acc.equals("Retroceder")){
            request.getRequestDispatcher("ControlAdministrador?acc=Mantener Medico").forward(request, response);
                
            }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
