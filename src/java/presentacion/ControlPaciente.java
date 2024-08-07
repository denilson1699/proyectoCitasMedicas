
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


@WebServlet(name = "ControlPaciente", urlPatterns = {"/ControlPaciente"})
public class ControlPaciente extends HttpServlet {
    private ModeloPrincipal modPri;
    private ServicioPaciente serPac;
    private ServicioEspecialista serEsp;
    private ServicioAdministrador serAdm;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acc= request.getParameter("acc");

        // --------------------------------
        //ventana de Registrar paciente****
        //---------------------------------        
        //boton cancelar
        if(acc.equals("Iniciar Sesion")){
            response.sendRedirect("index.html");
        }  
         //boton nuevo paciente
        if(acc.equals("Nuevo")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            modPri.setMsg("");
            modPri.setPaciente(serPac.nuevoPaciente());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("RegistrarPaciente.jsp");
        }
        //boton registra cuenta del nuevo paciente
        if(acc.equals("Registrar Cuenta")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
             String codigo=request.getParameter("codigo");
             String DNIPac=request.getParameter("DNIPac");
             String ApellidoPatPac=request.getParameter("ApellidoPatPac");
             String ApellidoMatPac=request.getParameter("ApellidoMatPac");
             String NombrePac=request.getParameter("NombrePac");
             String GeneroPac=request.getParameter("GeneroPac");
             String EmailPac=request.getParameter("EmailPac");
             String TelefPac=request.getParameter("TelefPac");
             String Estado ="Activo";
             String PassPac=request.getParameter("PassPac");
             int i=0;
             if(DNIPac.equals("")){i++;}
             if(ApellidoPatPac.equals("")){i++;}
             if(ApellidoMatPac.equals("")){i++;}
             if(NombrePac.equals("")){i++;}
             if(GeneroPac.equals("")){i++;}
             if(EmailPac.equals("")){i++;}
             if(TelefPac.equals("")){i++;}
             if(Estado.equals("")){i++;}
             if(PassPac.equals("")){i++;}
             if(i==0){
                 if(GeneroPac.equalsIgnoreCase("Masculino")){
                     GeneroPac="M";
                 }else{
                     GeneroPac="F";
                 }
                String msg=serPac.RegistrarPaciente("1",codigo,DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac, serPac.GenerarFecActual(), Estado, PassPac);   
                modPri.setMsg(msg);  
                Paciente pac= new Paciente(codigo,DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac,serPac.GenerarFecActual(), Estado, PassPac);
                modPri.setPaciente(pac);
                request.getSession().setAttribute("modPri", modPri);//funciono
                response.sendRedirect("RegistrarPaciente.jsp");
             }
             else{  
                modPri.setMsg("*Complete todos los campos"); 
                Paciente pac= new Paciente(codigo,DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac,serPac.GenerarFecActual(), Estado, PassPac);
                modPri.setPaciente(pac);
                request.getSession().setAttribute("modPri", modPri);//funciono
                response.sendRedirect("RegistrarPaciente.jsp");
             }
        }  
         
        
/*-------------
LISTAR HORARIOS-Pciente
---------------*/
        if(acc.equals("Generar Cita")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            String IdPac=request.getParameter("IdPac");
            modPri.setPaciente(serPac.BuscarPacientId(IdPac));
            modPri.setLisHorario(serPac.verAllHorariosDisponible());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacListarHorarios.jsp");   
        }
        if(acc.equals("Regresar")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            String IdPac=request.getParameter("IdPac");
            modPri.setPaciente(serPac.BuscarPacientId(IdPac));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MenuPaciente.jsp");   
        }
        if(acc.equals("Elegir")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            String idPaciente=request.getParameter("idPaciente");
            String idHorario=request.getParameter("idHorario");
            Object[] autoGene={serPac.GenerarCodigoAuto("citas"),serPac.GenerarFecActual()};
            modPri.setFil(autoGene);
            modPri.setPaciente(serPac.BuscarPacientId(idPaciente));
            modPri.setHorario(serPac.buscarHorarioId(idHorario));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacRegistrarCita.jsp");   
        }
        
/*-------------
REGISTRAR CITAS-Paciente
---------------*/
        if(acc.equals("Registrar Cita")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            serAdm= new ServicioAdministradorImp();
            String CodigoCita=request.getParameter("CodigoCita");
            String idPaciente=request.getParameter("IdPac");
            String idHorario=request.getParameter("idHorario");
            String fechaRegistro=request.getParameter("fechaRegistro");
            String estado="Pendiente";
            String Comentario="";
            modPri.setPaciente(serPac.BuscarPacientId(idPaciente));
            modPri.setHorario(serPac.buscarHorarioId(idHorario));
            Object[] autoGene={CodigoCita,fechaRegistro};
            modPri.setFil(autoGene);
            modPri.setMsg(serPac.RegistrarCitas("1", CodigoCita, idPaciente, idHorario, fechaRegistro, estado, Comentario));
            serPac.CambiarEstadoHorario(idHorario,"Asignado");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacRegistrarCita.jsp");   
        }
        if(acc.equals("Cancelar Registro")){
            request.getRequestDispatcher("ControlPaciente?acc=Generar Cita").forward(request, response);
        }
        if(acc.equals("Cerrar")){
            request.getRequestDispatcher("ControlPaciente?acc=Generar Cita").forward(request, response);
        }
        
/*-------------
CONSULTAR CITAS-Pciente
---------------*/
        if(acc.equals("Ver mis citas")){
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            String IdPac=request.getParameter("IdPac");
            modPri.setPaciente(serPac.BuscarPacientId(IdPac));
            modPri.setLisDet(serPac.ListarCitaIDPac(IdPac));
            modPri.setCita(serPac.NuevaCita());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacConsultarCitas.jsp");
        }
        
        if(acc.equals("Buscar Cita")){
            serPac= new  ServicioPacienteImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorBuscarCita").trim();
            String IdPac=request.getParameter("IdPac").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serPac.ListarCitaIDPac(IdPac));
                modPri.setCita(serPac.NuevaCita());
                modPri.setMsg("*Ingrese el codigo de la Cita");
            }else{
                Cita hr=serPac.buscarCitasIdCit_IDPac(idBuscar, IdPac);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setCita(hr);
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serPac.ListarCitaIDPac(IdPac));
                    modPri.setCita(serPac.NuevaCita());
                    modPri.setMsg("*No se encontro la cita "+idBuscar);
                        
                }    
            }
            modPri.setPaciente(serPac.BuscarPacientId(IdPac));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacConsultarCitas.jsp");
        }    
        if(acc.equals("Refrescar")){
            request.getRequestDispatcher("ControlPaciente?acc=Ver mis citas").forward(request, response);
        } 
        if(acc.equals("Examinar")){
            serPac= new ServicioPacienteImp();
            modPri= new ModeloPrincipal();
            String idPaciente=request.getParameter("idPaciente").trim();
            String idCita=request.getParameter("idCita").trim();
            modPri.setPaciente(serPac.BuscarPacientId(idPaciente));
            modPri.setLisDet(serPac.ListarCitaIDPac(idPaciente));
            modPri.setCita(serPac.BuscarCitaId(idCita));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacConsultarCitas.jsp");
        } 
        
        if(acc.equals("Anular Cita")){
            serPac= new ServicioPacienteImp();
            modPri= new ModeloPrincipal();
            String IdPac=request.getParameter("IdPac").trim();
            String IDPacAct=request.getParameter("IDPacAct").trim();
            String IDCitaAct=request.getParameter("IDCitaAct").trim();
            String estCitAct=request.getParameter("estCitAct").trim();
            String comentarioCitAct=request.getParameter("comentarioCitAct").trim();
            if(IDPacAct.equalsIgnoreCase("")||IDCitaAct.equalsIgnoreCase("")||estCitAct.equalsIgnoreCase("")){
                modPri.setPaciente(serPac.BuscarPacientId(IdPac));
                modPri.setLisDet(serPac.ListarCitaIDPac(IdPac));
                modPri.setCita(serPac.NuevaCita());
                modPri.setMsg("*Primero debe seleccionar una de sus cita");
            }else{
                if(estCitAct.equalsIgnoreCase("Pendiente")){
                    if(comentarioCitAct.equalsIgnoreCase("")){
                        modPri.setPaciente(serPac.BuscarPacientId(IDPacAct));
                        modPri.setLisDet(serPac.ListarCitaIDPac(IDPacAct));
                        modPri.setCita(serPac.BuscarCitaId(IDCitaAct));
                        modPri.setMsg("*Debe agregar un comentario");
                    }else{
                        if(comentarioCitAct.length()<=200){
                        Cita ci=serPac.BuscarCitaId(IDCitaAct);
                        String NuevoComent = ci.getComentario()+" El paciente anulo la cita:"+serPac.GenerarFecActual()+" "+comentarioCitAct;
                        modPri.setPaciente(serPac.BuscarPacientId(IdPac));
                        modPri.setLisDet(serPac.ListarCitaIDPac(IDPacAct));
                        modPri.setCita(serPac.BuscarCitaId(IDCitaAct));
                        modPri.setMsg(serPac.RegistrarCitas("2", IDCitaAct, "", "", "", "Anulada por Paciente", NuevoComent));
                        }else{
                            modPri.setMsg("Su comentario tiene "+comentarioCitAct.length()+" caracteres"); 
                            modPri.setPaciente(serPac.BuscarPacientId(IdPac));
                            modPri.setLisDet(serPac.ListarCitaIDPac(IDPacAct));
                            modPri.setCita(serPac.BuscarCitaId(IDCitaAct));
                        }
                    }              
                }else{
                    modPri.setPaciente(serPac.BuscarPacientId(IDPacAct));
                    modPri.setLisDet(serPac.ListarCitaIDPac(IDPacAct));
                    modPri.setCita(serPac.BuscarCitaId(IDCitaAct));
                    modPri.setMsg("La cita ya no se encuetra pendiente");
                }
            }
            
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("PacConsultarCitas.jsp");
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
