
package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Especialista;
import negocio.Paciente;
import servicio.*;


@WebServlet(name = "ControlLogin", urlPatterns = {"/ControlLogin"})
public class ControlLogin extends HttpServlet {
   private ModeloPrincipal modPri;
   private ModeloLogin modLog;
    private ServicioPaciente serPac;
    private ServicioEspecialista serEsp;
    private ServicioAdministrador serAdm;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String acc= request.getParameter("acc");
      
        if(acc.equals("Ingresar")){     
            modPri= new ModeloPrincipal();
            modLog= new ModeloLogin();
            serPac= new ServicioPacienteImp();
            serEsp= new ServicioEspecialistaImp();
            serAdm= new ServicioAdministradorImp();
            String usu=request.getParameter("usuario");
            String pass=request.getParameter("password");
            String perfil=request.getParameter("perfil");
            int i=0;
            if(usu.equals("")){i++;}
            if(pass.equals("")){i++;}
            if(i==0){
                if(perfil.equals("Paciente")){
                Object [] pac= serPac.Login(usu, pass);         
                    if(pac!=null){  
                       modPri.setPaciente(serPac.BuscarPacientId(pac[0].toString()));     
                       request.getSession().setAttribute("modPri", modPri); 
                       response.sendRedirect("MenuPaciente.jsp");
                    }
                    else{
                        response.sendRedirect("index.html");
                    }
                }
                if(perfil.equals("Especialista")){
                  Object [] esp= serEsp.Login(usu, pass);
                    if(esp!=null){
                        modPri.setEspesc(serEsp.buscarEspecialistaID(esp[0].toString()));
                        request.getSession().setAttribute("modPri", modPri);
                        response.sendRedirect("MenuEspecialista.jsp");
                    }
                    else{
                        response.sendRedirect("index.html");
                    }   
                }
                if(perfil.equals("Administrador")){
                  Object [] adm= serAdm.Login(usu, pass);
                    if(adm!=null){
                    modLog.setFil(adm);
                    request.getSession().setAttribute("modLog", modLog);
                    response.sendRedirect("MenuAdministrador.jsp");
                    }
                    else{
                        response.sendRedirect("index.html");
                    }   
                }
                
            }
            else
            {
              modPri.setMsg("Atención!!! ingrese usuario y contraseña");  
              request.getSession().setAttribute("modPri", modPri);
              response.sendRedirect("Mensaje.jsp");
            }
                       
                       
        }
        
        
        
        if(acc.equals("Registrarse")){     
            modPri= new ModeloPrincipal();
            serPac= new ServicioPacienteImp();
            modPri.setMsg("");
            modPri.setPaciente(serPac.nuevoPaciente());
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("RegistrarPaciente.jsp");
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
