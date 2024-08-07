package persistencia;

import java.util.List;
import negocio.*;

public interface DaoTEMedico {
 
    public List listarTipoEspecialidadMedico();
    public TipoEspecialidadMedico buscarTipoEspecialidadMedicoID(String id);
    public String MantenerLocal(String oper,String IDLoc, String Descr);
    
}
