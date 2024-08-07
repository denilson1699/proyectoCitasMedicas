// proyecto Hotel

package persistencia;

import java.util.List;
import negocio.*;
public interface DaoPaciente {
    //listo
   public Paciente Login(String dni, String pass);
 
   public Paciente BuscarPacienteID(String id);
   public List listarPacientes();
   public String MantenerPaceinte(String oper,String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac);
 
   
}
