// proyecto Hotel

package persistencia;

import java.util.List;
import negocio.*;
public interface DaoCita {
    public List listarCitas();
    public Cita buscarCitasId(String id);
    public Cita buscarCitasIdCit_IDPac(String idCita, String IdPac);
    public String MantenerCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario);
    public List ListarCitaIDPac(String idPac);
}
