package servicio;

import java.util.List;
import negocio.*;

public interface ServicioAdministrador {

 public Object[] Login(String dni, String pass);
    
    public String GenerarCodigoAuto(String NombreTabla);
    public String GenerarFecActual();
    
    public Horarios nuevoHorario();
    public List verAllHorarios();
    public Horarios buscarHorarioId(String id);
    public String MantenerHorario(String operacion, String IDHorario, String IDMedico, String IDLoca, String fecha, String hora, String est);
    
    
    public Medico nuevoMedico();
    public Medico llenandoNuevoMedico(String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado);
    public List verAllMedicos();
    public Medico buscarMedidoID(String id);
    public String MantenerMedico(String Oper,String IDMedico,String IdEsp, String idTEMedico, String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado);
    
    public Paciente nuevoPaciente();
    public List verAllPacientes();
    public Paciente buscarPacienteID(String id);
    public String MantenerPaceinte(String oper,String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac);
 
    
    public Especialista nuevoEspecialista();
    public List verAllEspecialistas();
    public Especialista buscarEspecialistaID(String id);
    public String MantenerEspecialista(String oper, String ID, String dni, String ApePar, String apelMat, String nomb, String sex, String telf,String mail, String fchIns, String pass,String est );
    
    public Local nuevoLocal();
    public List verAllLocales();
    public Local buscarLocalID(String id);
    public String MantenerLocal(String oper,String IDLocal, String DescripcionLocal, String Direccion, String Provincia, String Distrito);
    
    
    public TipoEspecialidadMedico nuevoTipoEspecialidadMedico();
    public List verAllTipoEspecialidadMedico();
    public TipoEspecialidadMedico buscarTipoEspecialidadMedicoID(String id);
    public String MantenerTipoEspMedico(String oper,String IDLoc, String Descr);
    
    public Cita NuevaCita();
    public List verAllCitas();
    public Cita buscarCitaID(String id);
    public String MantenerCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario);
    
    
}
