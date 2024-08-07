    // proyecto Hotel
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.*;
public class DaoEspecialistaImp implements DaoEspecialista{

    

// logear un paciente
      @Override
    public Especialista Login(String dni, String pass) {
        String sql="EXECUTE LOGIN_ESPECIALISTA '"+dni+"','"+pass+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Especialista cli=new Especialista();
            cli.setIDEspe(fila[0].toString().trim());
            cli.setDNIEsp(fila[1].toString().trim());
            cli.setApellidoPatEsp(fila[2].toString().trim());
            cli.setApellidoMatEsp(fila[3].toString().trim());
            cli.setNombreEsp(fila[4].toString().trim());
            cli.setEmailEsp(fila[5].toString().trim());
            cli.setSexoEsp(fila[6].toString().trim());
            cli.setTelefEsp(fila[7].toString().trim());
            cli.setFechaInscripEsp(fila[8].toString().trim());
            cli.setEstadoEsp(fila[9].toString().trim());
            cli.setPassEsp(fila[10].toString().trim());
            return cli;
        }
        return null;
    }

    @Override
    public Especialista BuscarEspecialistaID(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'ESPECIALISTA', '"+id+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Especialista cli=new Especialista();
            cli.setIDEspe(fila[0].toString().trim());
            cli.setDNIEsp(fila[1].toString().trim());
            cli.setApellidoPatEsp(fila[2].toString().trim());
            cli.setApellidoMatEsp(fila[3].toString().trim());
            cli.setNombreEsp(fila[4].toString().trim());
            cli.setSexoEsp(fila[5].toString().trim());
            cli.setTelefEsp(fila[6].toString().trim());
            cli.setEmailEsp(fila[7].toString().trim());
            cli.setFechaInscripEsp(fila[8].toString().trim());
            cli.setPassEsp(fila[9].toString().trim());
            cli.setEstadoEsp(fila[10].toString().trim());
            return cli;
        }
        return null; 
    }

    @Override
    public List listarEspecialista() {
      List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'ESPECIALISTA'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[11];
              fila=(Object[])lista.get(i);
              Especialista hc= new Especialista();
              hc.setIDEspe(fila[0].toString().trim());
              hc.setDNIEsp(fila[1].toString().trim());
              hc.setApellidoPatEsp(fila[2].toString().trim());
              hc.setApellidoMatEsp(fila[3].toString().trim());
              hc.setNombreEsp(fila[4].toString().trim());
              hc.setSexoEsp(fila[5].toString().trim());
              hc.setTelefEsp(fila[6].toString().trim());
              hc.setEmailEsp(fila[7].toString().trim());
              hc.setFechaInscripEsp(fila[8].toString().trim());
              hc.setPassEsp(fila[9].toString().trim());
              hc.setEstadoEsp(fila[10].toString().trim());              
              lis.add(hc);
          }
          return lis;
      }
    return lis;
    }


    @Override
    public String MantenerEspecialista(String oper, String ID, String dni, String ApePar, String apelMat, String nomb, String sex, String telf,String mail, String fchIns, String pass,String est ) {
        String sql="EXECUTE sp_especialista_mantenimiento "+oper+",'"+ID+"','"+dni+"','"+ApePar+"','"+apelMat+"','"+nomb+"','"+sex+"','"+telf+"','"+mail+"','"+fchIns+"','"+pass+"','"+est+"'";
        return Operacion.ejecutarConRespuesta(sql);
    }
    
}


    
    

