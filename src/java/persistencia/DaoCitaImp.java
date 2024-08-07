// proyecto Hotel
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.*;
public class DaoCitaImp implements DaoCita{

    @Override
    public List listarCitas() {
      List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'CITAS'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[5];
              fila=(Object[])lista.get(i);
              Cita cli= new Cita();
              cli.setCodigoCita(fila[0].toString().trim());
                    DaoPaciente daoPac= new DaoPacienteImp();
                cli.setIdpac(daoPac.BuscarPacienteID(fila[1].toString().trim()));
                    DaoHorario daoHora= new DaoHorarioImp();
                cli.setIdHora(daoHora.buscarHorariosId(fila[2].toString().trim()));
                cli.setFechaReg(fila[3].toString().trim());
                cli.setEstado(fila[4].toString().trim());
                cli.setComentario(fila[5].toString().trim());              
              lis.add(cli);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public Cita buscarCitasId(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'CITAS', '"+id+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Cita cli=new Cita();
            cli.setCodigoCita(fila[0].toString().trim());
                DaoPaciente daoPac= new DaoPacienteImp();
            cli.setIdpac(daoPac.BuscarPacienteID(fila[1].toString().trim()));
                DaoHorario daoHora= new DaoHorarioImp();
            cli.setIdHora(daoHora.buscarHorariosId(fila[2].toString().trim()));
            cli.setFechaReg(fila[3].toString().trim());
            cli.setEstado(fila[4].toString().trim());
            cli.setComentario(fila[5].toString().trim());
            return cli;
        }
        return null; 
    }

    @Override
    public String MantenerCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario) {
         String sql="EXECUTE sp_citas_mantenimiento "+oper+",'"+CodigoCita+"','"+Idpac+"','"+idHora+"','"+FechaReg+"','"+Estado+"','"+Comentario+"'";  
        return Operacion.ejecutarConRespuesta(sql);
   }

    @Override
    public List ListarCitaIDPac(String idPac) {
      List lis=new ArrayList();
      String sql="EXECUTE SP_ListarCitaIDPac '"+idPac+"'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[5];
              fila=(Object[])lista.get(i);
              Cita cli= new Cita();
              cli.setCodigoCita(fila[0].toString().trim());
                    DaoPaciente daoPac= new DaoPacienteImp();
                cli.setIdpac(daoPac.BuscarPacienteID(fila[1].toString().trim()));
                    DaoHorario daoHora= new DaoHorarioImp();
                cli.setIdHora(daoHora.buscarHorariosId(fila[2].toString().trim()));
                cli.setFechaReg(fila[3].toString().trim());
                cli.setEstado(fila[4].toString().trim());
                cli.setComentario(fila[5].toString().trim());              
              lis.add(cli);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public Cita buscarCitasIdCit_IDPac(String idCita, String IdPac) {
        String sql="select * from  citas where CODIGOCITA='"+idCita+"' AND IDPAC='"+IdPac+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Cita cli=new Cita();
            cli.setCodigoCita(fila[0].toString().trim());
                DaoPaciente daoPac= new DaoPacienteImp();
            cli.setIdpac(daoPac.BuscarPacienteID(fila[1].toString().trim()));
                DaoHorario daoHora= new DaoHorarioImp();
            cli.setIdHora(daoHora.buscarHorariosId(fila[2].toString().trim()));
            cli.setFechaReg(fila[3].toString().trim());
            cli.setEstado(fila[4].toString().trim());
            cli.setComentario(fila[5].toString().trim());
            return cli;
        }
        return null; 
    }


 
}
