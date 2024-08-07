
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.Horarios;
import negocio.TipoEspecialidadMedico;


public class DaoTEMedicoImp implements DaoTEMedico{

    TipoEspecialidadMedico TEMedcioVacio= new TipoEspecialidadMedico("","");
    @Override
    public List listarTipoEspecialidadMedico() {
       List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'TIPOESPECIALIDADMEDICO'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[2];
              fila=(Object[])lista.get(i);
              TipoEspecialidadMedico hc= new TipoEspecialidadMedico();
              hc.setIDTEMedico(fila[0].toString().trim());
              hc.setDescripcion(fila[1].toString().trim());
              lis.add(hc);
          }
          return lis;
      }
    return lis;}

    @Override
    public TipoEspecialidadMedico buscarTipoEspecialidadMedicoID(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'TIPOESPECIALIDADMEDICO','"+id+"'";
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            TipoEspecialidadMedico hc= new TipoEspecialidadMedico();
            hc.setIDTEMedico(fila[0].toString().trim());
            hc.setDescripcion(fila[1].toString().trim());
            return hc;
        }
        return TEMedcioVacio;
    }

    @Override
    public String MantenerLocal(String oper,String IDLoc, String Descr) {
        String sql="EXECUTE sp_TipoEspecialidadMedico_mantenimiento "+oper+",'"+IDLoc+"','"+Descr+"'";
        return Operacion.ejecutarConRespuesta(sql);
    }

    
}
