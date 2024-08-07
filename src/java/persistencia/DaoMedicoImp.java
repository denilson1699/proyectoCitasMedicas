
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.Especialista;
import negocio.Horarios;
import negocio.Medico;
import negocio.TipoEspecialidadMedico;

public class DaoMedicoImp implements DaoMedico{

    @Override
    public Medico BuscarMedicoID(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'MEDICO','"+id+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Medico cli=new Medico();
            cli.setIDMedico(fila[0].toString().trim());
                DaoEspecialista daoEsp= new DaoEspecialistaImp();
            cli.setIdEsp(daoEsp.BuscarEspecialistaID(fila[1].toString().trim()));
                DaoTEMedico DaoTEMedico= new DaoTEMedicoImp();
            cli.setIdTEMedico(DaoTEMedico.buscarTipoEspecialidadMedicoID(fila[2].toString().trim()));
            cli.setDniMed(fila[3].toString().trim());
            cli.setApellidoPatMed(fila[4].toString().trim());
            cli.setApellidoMatMed(fila[5].toString().trim());
            cli.setNombre(fila[6].toString().trim());
            cli.setSexo(fila[7].toString().trim());
            cli.setTelefono(fila[8].toString().trim());
            cli.setEmail(fila[9].toString().trim());
            cli.setHoraIngreso(fila[10].toString().trim());
            cli.setHoraSalida(fila[11].toString().trim());
            cli.setPass(fila[12].toString().trim());
            cli.setEstado(fila[13].toString().trim());
            return cli;
        }
        return null; 
    }

    @Override
    public List listarMedicos() {
      List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'MEDICO'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[14];
              fila=(Object[])lista.get(i);
              Medico hc= new Medico();
              hc.setIDMedico(fila[0].toString().trim());
                 DaoEspecialista daoEsp= new DaoEspecialistaImp();
              hc.setIdEsp(daoEsp.BuscarEspecialistaID(fila[1].toString().trim()));
                 DaoTEMedico DaoTEMedico= new DaoTEMedicoImp();
              hc.setIdTEMedico(DaoTEMedico.buscarTipoEspecialidadMedicoID(fila[2].toString().trim()));
              hc.setDniMed(fila[3].toString().trim());
              hc.setApellidoPatMed(fila[4].toString().trim());
              hc.setApellidoMatMed(fila[5].toString().trim());
              hc.setNombre(fila[6].toString().trim());
              hc.setSexo(fila[7].toString().trim());
              hc.setTelefono(fila[8].toString().trim());
              hc.setEmail(fila[9].toString().trim());
              hc.setHoraIngreso(fila[10].toString().trim());
              hc.setHoraSalida(fila[11].toString().trim());
              hc.setPass(fila[12].toString().trim());
              hc.setEstado(fila[13].toString().trim());
              
              lis.add(hc);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public String MantenerMedico(String oper, String IDMedico, String IdEsp, String idTEMedico, String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado) {
        String sql="EXECUTE sp_medico_mantenimiento "+oper+",'"+IDMedico+"','"+IdEsp+"','"+idTEMedico+"','"+DniMed+"','"+ApellidoPatMed+"','"+ApellidoMatMed+"','"+Nombre+"','"+Sexo+"','"+Telefono+"','"+Email+"','"+HoraIngreso+"','"+HoraSalida+"','"+Pass+"','"+Estado+"'";
        return Operacion.ejecutarConRespuesta(sql);
    }
    

}
