// proyecto Hotel

package persistencia;

import java.util.List;
import negocio.*;
public interface DaoEspecialista {
    // listos
   public Especialista Login(String dni, String pass);
   public Especialista BuscarEspecialistaID(String id);
    
   public List listarEspecialista();
   public String MantenerEspecialista(String oper, String ID, String dni, String ApePar, String apelMat, String nomb, String sex,String telf,String mail, String fchIns, String pass,String est );
   
}
