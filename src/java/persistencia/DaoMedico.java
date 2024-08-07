
package persistencia;

import java.util.List;
import negocio.*;

public interface DaoMedico {

    public List listarMedicos();
    public Medico BuscarMedicoID(String id);   
   
    public String MantenerMedico(String Oper,String IDMedico,String IdEsp, String idTEMedico, String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado);
 
}
