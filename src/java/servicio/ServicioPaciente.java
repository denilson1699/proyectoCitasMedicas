
package servicio;

import java.util.List;
import negocio.*;

public interface ServicioPaciente {
    
    public Object[] Login(String dni, String pass);
    
    
    public Paciente nuevoPaciente();
    public Paciente BuscarPacientId(String id);
    public String RegistrarPaciente(String oper,String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac);
    public String GenerarCodigoAuto(String NombreTabla);
    public String GenerarFecActual();
   
    public List verAllHorariosDisponible();
    public Horarios buscarHorarioId(String id);
    
    public Cita NuevaCita();
    public Cita BuscarCitaId(String id);
    public Cita buscarCitasIdCit_IDPac(String idCita, String IdPac);
    public List ListarCitaIDPac(String idPac);
    public String RegistrarCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario);
    public String CambiarEstadoHorario(String idHor,String estado);
      
    
}
