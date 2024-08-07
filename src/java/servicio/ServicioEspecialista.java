// proyecto Hotel
package servicio;

import java.util.List;
import negocio.*;

public interface ServicioEspecialista {
    //listo
    public Object[] Login(String dni, String pass);
    
    public List verListaCitas();
    public Paciente BuscarPacientId(String id);
    public String ConsultarCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario);
    public Cita buscarCitaidPac(String id);
    
    public Especialista buscarEspecialistaID(String id);
    
}
