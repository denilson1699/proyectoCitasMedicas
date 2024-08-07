
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.Horarios;

public class DaoAdministradorImp  implements DaoAdministrador{

    @Override
    public Object[] logearAdministrador(String dni, String pass) {
        String sql ="select * from especialista where DNIESP='"+dni+"' and PASSESP='"+pass+"' and ESTADOESP='Administrador'";
        Object[] f= Operacion.buscar(sql);
        return f;
    }

  
    
}
