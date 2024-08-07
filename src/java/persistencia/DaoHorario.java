
package persistencia;

import java.util.List;
import negocio.Horarios;

public interface DaoHorario {
    
    public List listarHorarios();
    public Horarios buscarHorariosId(String id);
    public String MantenerHorario(String operacion, String IDHorario, String IDMedico, String IDLoca, String fecha, String hora, String estado);
    public List listarHorariosDisponibles();
    public String CambiarEstadoHorario(String idHor,String estado);
    
}
