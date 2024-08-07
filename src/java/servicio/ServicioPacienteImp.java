
package servicio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import negocio.*;
import persistencia.*;
public class ServicioPacienteImp implements ServicioPaciente{
    private DaoPaciente daoPac; 
    private DaoHorario daoHor;
    private  DaoCita daoCit;
    private ServicioAdministrador serAdm;
    
    public ServicioPacienteImp() {
        daoPac = new DaoPacienteImp();
        daoHor = new DaoHorarioImp();
        daoCit= new DaoCitaImp();
        serAdm= new ServicioAdministradorImp();
    }

    
    // recuperar la fecha del sistema
    public String getFecha(){
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
// logear un paciente
    @Override
    public Object[] Login(String dni, String pass) {
      Paciente pac= daoPac.Login(dni,pass);
      if(pac!=null){
        Object[] f= new Object[11];
        f[0]= pac.getIDPac();
        f[1]= pac.getDNIPac();
        f[2]= pac.getApellidoPatPac();
        f[3]= pac.getApellidoMatPac();
        f[4]= pac.getNombrePac();
        f[5]= pac.getEmailPac();
        f[6]= pac.getGeneroPac();
        f[7]= pac.getTelefPac();
        f[8]= getFecha();
        f[9]= pac.getEstadoPac();
        f[10]= pac.getPassPac();
        return f;
      }
      return null;
    }
    
    @Override
    public Paciente nuevoPaciente() {
        Paciente pac= new Paciente(serAdm.GenerarCodigoAuto("paciente"), "", "", "", "", "", "", "", serAdm.GenerarFecActual(),"Activo","" );
        return pac;
    }

    @Override
    public String RegistrarPaciente(String oper, String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac) {
        return daoPac.MantenerPaceinte(oper, IDPac, DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac, FechaRegistroPac, EstadoPac, PassPac);
    }

    @Override
    public String GenerarCodigoAuto(String NombreTabla) {
        return serAdm.GenerarCodigoAuto(NombreTabla);
    }

    @Override
    public String GenerarFecActual() {
        return serAdm.GenerarFecActual();
    }

    @Override
    public List verAllHorariosDisponible() {
      List Lista =daoHor.listarHorariosDisponibles();// falta
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public Cita NuevaCita() {
        return serAdm.NuevaCita();
    }

    @Override
    public List ListarCitaIDPac(String idPac ) {
      List Lista =daoCit.ListarCitaIDPac(idPac);
       if(Lista!=null){
      return Lista;
     }
     return null;
    
    }

    @Override
    public String RegistrarCitas(String oper, String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario) {
        return daoCit.MantenerCitas(oper,CodigoCita, Idpac, idHora, FechaReg, Estado, Comentario);
    }

    @Override
    public Paciente BuscarPacientId(String id) {
        return serAdm.buscarPacienteID(id);
    }

    @Override
    public Horarios buscarHorarioId(String id) {
        return serAdm.buscarHorarioId(id);
    }

    @Override
    public Cita BuscarCitaId(String id) {
        return  serAdm.buscarCitaID(id);
    }

    @Override
    public String CambiarEstadoHorario(String idHor,String estado) {
        return daoHor.CambiarEstadoHorario(idHor,estado);
    }

    @Override
    public Cita buscarCitasIdCit_IDPac(String idCita, String IdPac) {
        return daoCit.buscarCitasIdCit_IDPac(idCita, IdPac);
    }

    
    
}
