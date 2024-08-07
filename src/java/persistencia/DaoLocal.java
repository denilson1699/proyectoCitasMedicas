
package persistencia;

import java.util.List;
import negocio.Local;

public interface DaoLocal {

    public Local BuscarLocal(String id);
    public List listarLocales();
    public String MantenerLocal(String oper,String IDLocal, String DescripcionLocal, String Direccion, String Provincia, String Distrito);
}
