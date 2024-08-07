
package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Cita;
import negocio.Paciente;
import servicio.ServicioEspecialista;
import servicio.*;


@WebServlet(name = "ControlEspecialista", urlPatterns = {"/ControlEspecialista"})
public class ControlEspecialista extends HttpServlet {
    private ModeloPrincipal modPri;
    private ServicioEspecialista serEsp;
    private ServicioAdministrador serAdm;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acc= request.getParameter("acc");
/*----------------------------------
VENTANA BUSCAR PACIENTE-ESPECIALISTA
------------------------------------*/        
        
        if(acc.equals("Buscar Paciente")){
            serAdm= new ServicioAdministradorImp();
            serEsp= new ServicioEspecialistaImp();
            modPri= new ModeloPrincipal();
            String IdEsp=request.getParameter("IdEsp");
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            modPri.setLisDet(serAdm.verAllPacientes());
            modPri.setPaciente(serAdm.nuevoPaciente());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspBuscarPaciente.jsp");
        }
        
        if(acc.equals("Buscar")){
            serAdm= new ServicioAdministradorImp();
            serEsp= new ServicioEspecialistaImp();
            modPri= new ModeloPrincipal();
            String IdEsp=request.getParameter("IdEsp");
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
                    modPri.setPaciente(serEsp.BuscarPacientId(idBuscar));
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serAdm.verAllPacientes());
                    modPri.setPaciente(serAdm.nuevoPaciente());
                    modPri.setMsg("*No existe un paciente con el código "+idBuscar);
                        
                }    
            }
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspBuscarPaciente.jsp");
        }   
        
        if(acc.equals("Refrescar")){
            request.getRequestDispatcher("ControlEspecialista?acc=Buscar Paciente").forward(request, response);
        } 
        
        if(acc.equals("Ver")){
            serAdm= new ServicioAdministradorImp();
            serEsp= new ServicioEspecialistaImp();
            modPri= new ModeloPrincipal();
            modPri.setLisDet(serAdm.verAllPacientes());
            String idpaciente=request.getParameter("idpaciente").trim();
            String IdEsp=request.getParameter("IdEsp").trim();
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            modPri.setPaciente(serEsp.BuscarPacientId(idpaciente));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspBuscarPaciente.jsp");
        } 
        
        if(acc.equals("Regresar")){  
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IdEsp=request.getParameter("IdEsp").trim();
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            response.sendRedirect("MenuEspecialista.jsp");
        }
        
/*----------------------------------
VENTANA cONSULTAR cITAS-ESPECIALISTA
------------------------------------*/        
        if(acc.equals("Consultar Citas")){ 
            modPri= new ModeloPrincipal();
            serAdm= new ServicioAdministradorImp();
            serEsp= new ServicioEspecialistaImp();
            String IdEsp=request.getParameter("IdEsp");
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            modPri.setLisDet(serEsp.verListaCitas());
            modPri.setCita(serAdm.NuevaCita());
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspConsultarCitas.jsp");
        }
        
         if(acc.equals("Buscar Cita")){
            serEsp= new  ServicioEspecialistaImp();
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String idBuscar=request.getParameter("ValorBuscarCita").trim();
            String IdEsp=request.getParameter("IdEsp").trim();
            if(idBuscar.equals("")){
                modPri.setLisDet(serEsp.verListaCitas());
                modPri.setCita(serAdm.NuevaCita());
                modPri.setMsg("*Ingrese el codigo de la Cita ");
            }else{
                Cita hr=serAdm.buscarCitaID(idBuscar);
                if(hr!=null){
                    //Convertimos un objecto paciente en arrayList
                    List lis=new ArrayList();
                    lis.add(hr);
                    modPri.setLisDet(lis);
                    modPri.setCita(hr);
                    modPri.setMsg("Exito");
                }
                else{
                    modPri.setLisDet(serEsp.verListaCitas());
                    modPri.setCita(serAdm.NuevaCita());
                    modPri.setMsg("*No se encontro la cita "+idBuscar);
                        
                }    
            }
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspConsultarCitas.jsp");
        }    
        
        if(acc.equals("Examinar")){
            serEsp= new ServicioEspecialistaImp();
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IdEsp=request.getParameter("IdEsp").trim();
            String idCita=request.getParameter("idCita").trim();
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEsp));
            modPri.setLisDet(serEsp.verListaCitas());
            modPri.setCita(serAdm.buscarCitaID(idCita));
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspConsultarCitas.jsp");
        } 
            
        if(acc.equals("Cita Atendida")){
            serEsp= new ServicioEspecialistaImp();
            serAdm= new ServicioAdministradorImp();
            modPri= new ModeloPrincipal();
            String IdEspAct=request.getParameter("IdEspAct").trim();
            String IDCitaAct=request.getParameter("IDCitaAct").trim();
            String estCitAct=request.getParameter("estCitAct").trim();
            String comentarioCitAct=request.getParameter("comentarioCitAct").trim();
            if(IdEspAct.equalsIgnoreCase("")||IDCitaAct.equalsIgnoreCase("")||estCitAct.equalsIgnoreCase("")){
                modPri.setCita(serAdm.NuevaCita());  
                modPri.setMsg("*Primero debe seleccionar una cita");
            }else{
                if(estCitAct.equalsIgnoreCase("Pendiente")){
                    Cita ci=serAdm.buscarCitaID(IDCitaAct);
                    String NuevoComent = ci.getComentario()+" "+comentarioCitAct;
                    modPri.setMsg(serEsp.ConsultarCitas("2", IDCitaAct, "", "", "", "Atendida", NuevoComent));
                    modPri.setCita(serAdm.buscarCitaID(IDCitaAct));
                   }              
                else{
                      modPri.setCita(serAdm.buscarCitaID(IDCitaAct));
                    modPri.setMsg("La cita ya no se encuetra pendiente");
                }
            }
            modPri.setEspesc(serEsp.buscarEspecialistaID(IdEspAct));
            modPri.setLisDet(serEsp.verListaCitas());          
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("EspConsultarCitas.jsp");
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
