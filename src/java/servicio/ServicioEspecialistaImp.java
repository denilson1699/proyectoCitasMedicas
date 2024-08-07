// proyecto Hotel
package servicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.*;
import persistencia.*;

public class ServicioEspecialistaImp implements ServicioEspecialista{
   private DaoEspecialista daoEsp;
   private DaoCita daoCit;     
   private DaoPaciente daoPac;
   private ServicioAdministrador serAdm;
   
    public ServicioEspecialistaImp() {
        daoEsp= new DaoEspecialistaImp();
        daoCit= new DaoCitaImp();
        daoPac= new DaoPacienteImp();
        serAdm= new ServicioAdministradorImp();
    }

 // recuperar la fecha del sistema
    public String getFecha(){
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
  
    @Override
    public Object[] Login(String dni, String pass) {
        Especialista esp= daoEsp.Login(dni,pass);
      if(esp!=null){
        Object[] f= new Object[11];
        f[0]= esp.getIDEspe();
        f[1]= esp.getDNIEsp();
        f[2]= esp.getApellidoPatEsp();
        f[3]= esp.getApellidoMatEsp();
        f[4]= esp.getNombreEsp();
        f[5]= esp.getEmailEsp();
        f[6]= esp.getSexoEsp();
        f[7]= esp.getTelefEsp();
        f[8]= esp.getFechaInscripEsp();
        f[9]= esp.getEstadoEsp();
        f[10]= esp.getPassEsp();
        return f;
      }
        return  null;
    }

    @Override
    public List verListaCitas() {
       List Lista =daoCit.listarCitas();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public String ConsultarCitas(String oper, String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario) {
        return daoCit.MantenerCitas(oper,CodigoCita, Idpac, idHora, FechaReg, Estado, Comentario);
    }

    @Override
    public Cita buscarCitaidPac(String id) {
     Cita cit =daoCit.buscarCitasId(id);
      if(cit!=null){
      return cit;
     }
     return null;
    }

    @Override
    public Paciente BuscarPacientId(String id) {
     Paciente pac =daoPac.BuscarPacienteID(id);
      if(pac!=null){
      return pac;
     }
     return null;
    }

    @Override
    public Especialista buscarEspecialistaID(String id) {
        return daoEsp.BuscarEspecialistaID(id);
    }
      
}
