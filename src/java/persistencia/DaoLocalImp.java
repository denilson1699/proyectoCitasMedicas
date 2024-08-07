
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.Horarios;
import negocio.Local;

public class DaoLocalImp implements DaoLocal{

    @Override
    public Local BuscarLocal(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'LOCAL', '"+id+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Local cli=new Local();
            cli.setIDLocal( fila[0].toString().trim());
            cli.setDescripcionLocal(fila[1].toString().trim());
            cli.setDireccion(fila[2].toString().trim());
            cli.setProvincia(fila[3].toString().trim());
            cli.setDistrito(fila[4].toString().trim());
            return cli;
        }
        return null; 
    }

    @Override
    public List listarLocales() {
       List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'LOCAL'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[5];
              fila=(Object[])lista.get(i);
                Local cli=new Local();
                cli.setIDLocal( fila[0].toString().trim());
                cli.setDescripcionLocal(fila[1].toString().trim());
                cli.setDireccion(fila[2].toString().trim());
                cli.setProvincia(fila[3].toString().trim());
                cli.setDistrito(fila[4].toString().trim());
              lis.add(cli);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public String MantenerLocal(String oper,String IDLocal, String DescripcionLocal, String Direccion, String Provincia, String Distrito) {
        String sql="EXECUTE sp_local_mantenimiento "+oper+",'"+IDLocal+"','"+DescripcionLocal+"','"+Direccion+"','"+Provincia+"','"+Distrito+"'";  
        return Operacion.ejecutarConRespuesta(sql);
    }
    
}
