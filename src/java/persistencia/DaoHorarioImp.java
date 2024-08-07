
package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Horarios;

public class DaoHorarioImp implements DaoHorario{
    
    
    private CallableStatement Stm;
    
    private Connection Cn = null;
    
      @Override
    public List listarHorarios() {
      List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'HORARIOS'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[6];
              fila=(Object[])lista.get(i);
              Horarios hc= new Horarios();
              hc.setIDHorario(fila[0].toString().trim());
                DaoMedico daoEspmed= new DaoMedicoImp();
              hc.setMedico(daoEspmed.BuscarMedicoID(fila[1].toString().trim()));
                DaoLocal daoLocal= new DaoLocalImp();
              hc.setLocal(daoLocal.BuscarLocal(fila[2].toString().trim()));
              hc.setFecha(fila[3].toString().trim());
              hc.setHora(fila[4].toString().trim());
              hc.setEstado(fila[5].toString().trim());
              
              lis.add(hc);
          }
          return lis;
      }
    return lis;
    }

    
    
    @Override
    public Horarios buscarHorariosId(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'HORARIOS','"+id+"'";
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Horarios hc= new Horarios();
            hc.setIDHorario(fila[0].toString());
                DaoMedico daoEspmed= new DaoMedicoImp();
            hc.setMedico(daoEspmed.BuscarMedicoID(fila[1].toString()));
                DaoLocal daoLocal= new DaoLocalImp();
            hc.setLocal(daoLocal.BuscarLocal(fila[2].toString()));
            hc.setFecha(fila[3].toString().trim());
            hc.setHora(fila[4].toString().trim());
            hc.setEstado(fila[5].toString().trim());
              
            return hc;
        }
        return null;
    }

    @Override
    public String MantenerHorario(String operacion, String IDHorario, String IDMedico, String IDLoca, String fecha, String hora, String estado) {
        String sql="EXECUTE sp_horario_mantenimiento "+operacion+",'"+IDHorario+"','"+IDMedico+"','"+IDLoca+"','"+fecha+"','"+hora+"','"+estado+"'";  
        return Operacion.ejecutarConRespuesta(sql);
    }
    
    //Otra froma de ejecutar el mantener de horarios
    /*
      @Override
    public String MantenerHorario(String operacion, String IDHorario, String IDMedico, String IDLoca, String fecha, String hora) {
      String SQL = ("{call sp_horario_mantenimiento (?,?,?,?,?,?)}");
        try {
            Cn = new Conexion().getConexionSQLserverLocal();
            Stm = Cn.prepareCall(SQL);
            Stm.setString(1,operacion);
            Stm.setString(2, IDHorario);
            Stm.setString(3, IDMedico);
            Stm.setString(4, IDLoca);
            Stm.setString(5, fecha);
            Stm.setString(6, hora);
            ResultSet r=Stm.executeQuery();
            String Respuesta="";
            while(r.next()){
            Respuesta=r.getString(1).toString();
            }//Cn.close();
            return Respuesta;
        } catch (SQLException e) {
            System.out.println("*** ERROR:" + e.getMessage());
            return "";
        }
     */

    @Override
    public List listarHorariosDisponibles() {
      List lis=new ArrayList();
      String sql="SELECT * FROM vista_ListarHorariosDisponibles";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[6];
              fila=(Object[])lista.get(i);
              Horarios hc= new Horarios();
              hc.setIDHorario(fila[0].toString().trim());
                DaoMedico daoEspmed= new DaoMedicoImp();
              hc.setMedico(daoEspmed.BuscarMedicoID(fila[1].toString().trim()));
                DaoLocal daoLocal= new DaoLocalImp();
              hc.setLocal(daoLocal.BuscarLocal(fila[2].toString().trim()));
              hc.setFecha(fila[3].toString().trim());
              hc.setHora(fila[4].toString().trim());
              hc.setEstado(fila[5].toString().trim());
              
              lis.add(hc);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public String CambiarEstadoHorario(String idHor,String estado) {
        String sql="UPDATE HORARIOS SET ESTADO='"+estado+"' where IDHORARIO='"+idHor+"'";
        return Operacion.ejecutar(sql);
    }
    
    
   
        
}
