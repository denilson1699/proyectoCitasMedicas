// proyecto Hotel
package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.ParseConversionEvent;
import negocio.*;
public class DaoPacienteImp implements DaoPaciente{

    
// logear un paciente
    @Override
    public Paciente Login(String dni, String pass) {
        String sql="EXECUTE LOGIN_PACIENTE '"+dni+"','"+pass+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Paciente cli=new Paciente();
            cli.setIDPac(fila[0].toString().trim());
            cli.setDNIPac(fila[1].toString().trim());
            cli.setApellidoPatPac(fila[2].toString().trim());
            cli.setApellidoMatPac(fila[3].toString().trim());
            cli.setNombrePac(fila[4].toString().trim());
            cli.setEmailPac(fila[5].toString().trim());
            cli.setGeneroPac(fila[6].toString().trim());
            cli.setTelefPac(fila[7].toString().trim());
            cli.setFechaRegistroPac(fila[8].toString().trim());
            cli.setEstadoPac(fila[9].toString().trim());
            cli.setPassPac(fila[10].toString().trim());
            return cli;
        }
        return null;
    }


    @Override
    public Paciente BuscarPacienteID(String id) {
        String sql="EXECUTE BUSCAR_ID_TABLAS 'PACIENTE','"+id+"'"; 
        Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Paciente cli=new Paciente();
            cli.setIDPac(fila[0].toString().trim());            
            cli.setDNIPac(fila[1].toString().trim());
            cli.setApellidoPatPac(fila[2].toString().trim());
            cli.setApellidoMatPac(fila[3].toString().trim());
            cli.setNombrePac(fila[4].toString().trim());
            cli.setEmailPac(fila[5].toString().trim());
            cli.setGeneroPac(fila[6].toString().trim());
            cli.setTelefPac(fila[7].toString().trim());
            cli.setFechaRegistroPac(fila[8].toString().trim());
            cli.setEstadoPac(fila[9].toString().trim());
            cli.setPassPac(fila[10].toString().trim());
            return cli;
        }
        return null; 
    }

    @Override
    public List listarPacientes() {
      List lis=new ArrayList();
      String sql="EXECUTE SP_LISTAR_TABLAS_ALL 'PACIENTE'";
      List lista=Operacion.listar(sql);
      if(lista!=null){
          for(int i=1;i<lista.size();i++){
              Object[] fila= new Object[11];
              fila=(Object[])lista.get(i);
              Paciente cli= new Paciente();
                cli.setIDPac(fila[0].toString().trim());            
                cli.setDNIPac(fila[1].toString().trim());
                cli.setApellidoPatPac(fila[2].toString().trim());
                cli.setApellidoMatPac(fila[3].toString().trim());
                cli.setNombrePac(fila[4].toString().trim());
                cli.setEmailPac(fila[5].toString().trim());
                cli.setGeneroPac(fila[6].toString().trim());
                cli.setTelefPac(fila[7].toString().trim());
                cli.setFechaRegistroPac(fila[8].toString().trim());
                cli.setEstadoPac(fila[9].toString().trim());
                cli.setPassPac(fila[10].toString().trim());
                lis.add(cli);
          }
          return lis;
      }
    return lis;
    }

    @Override
    public String MantenerPaceinte(String oper,String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac) {
        String sql="EXECUTE sp_paciente_mantenimiento "+oper+",'"+IDPac+"','"+DNIPac+"','"+ApellidoPatPac+"','"+ApellidoMatPac+"','"+NombrePac+"','"+EmailPac+"','"+GeneroPac+"','"+TelefPac+"','"+FechaRegistroPac+"','"+EstadoPac+"','"+PassPac+"'";
        return Operacion.ejecutarConRespuesta(sql);
    }

  
    
    
}
