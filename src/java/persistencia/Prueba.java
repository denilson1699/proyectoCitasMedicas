// proyecto hotel
package persistencia;

import java.sql.*;
import java.util.List;
import negocio.*;
import java.util.ArrayList;
import java.util.List;

public class Prueba {
  
    public static void main(String[] args) {

        DaoPaciente daoPac= new DaoPacienteImp();
        DaoEspecialista daoESP= new DaoEspecialistaImp();
        DaoAdministrador daoAdm= new DaoAdministradorImp();
        DaoMedico daoEspMed= new DaoMedicoImp();
        DaoHorario daoHor= new DaoHorarioImp();
        DaoEspecialista daoEsp= new DaoEspecialistaImp();
        DaoCita daoCit= new DaoCitaImp();
        DaoMedico daoMed= new DaoMedicoImp();
   /*
    System.out.println("********** conexion con la bd **********");    
        // probar si hay conexion con la base de datos
    Connection cn= new Conexion().getConexionSQLserverLocal();
    if(cn!=null){
        System.out.println("si hay conexion con la BD citas medicas SQLSERVER");
    }else{
        System.out.println("no hay conexion con bd ");
    }
    */
    /*
        // grabar un nuevo paciente 
    Paciente pac= new Paciente("12345600", "APELLIDOPATPAC21", "APELLIDOMATPAC21", "NOMBREPAC21", "M","@jaramillo", "123123100", "10/5/21", "activo", "123");
    String msg=daoPac.grabar(pac);
    System.out.println("repuesta::"+msg);

    
    //logear un paciente
    Paciente pac= new Paciente();
    pac= daoPac.Login("12345621","PASSPAC1");
       if(pac!=null){
       System.out.println("-"+pac.getNombrePac()+" " +pac.getApellidoMatPac()+" " +pac.getApellidoPatPac());
       }else{
        System.out.println("no exite paciente");
       }
         
    
    // grabar un nuevo paciente 
    Especialista esp= new Especialista("76131020", "JARA10", "CAST10", "DENI10", "M","@jaramillo10", "123123110", "10/5/21", "1010","activo");
    String ESPmsg=daoESP.grabar(esp);
    System.out.println("repuesta::"+ESPmsg);
    
    
    
    

       Object[] adm= daoAdm.logearAdministrador("76131030", "de");
      if(adm!=null){
          System.out.println("-"+adm[1]+adm[2]+adm[3]);
      }else{
          System.out.println("no existe administrador");
      }
   
    
   Medico espmed= new Medico();
            espmed= daoEspMed.BuscarMedico("12345678");
      if(espmed!=null){
          System.out.println("-"+espmed.getApellidoMatMed());
      }else{
          System.out.println("no existe ESPECIALISTA MEDICO");
      }    
   
 List list= new ArrayList();
    list = daoHor.listarHorarios();
   
    if(list!=null){
           for(int i=0;i<list.size();i++){
               Horarios esp3= (Horarios)list.get(i);
            System.out.println(esp3.getFecha()+" "+esp3.getHoraCita()+" "
            +esp3.getLocal().getDescripcionLocal()+" "+esp3.getMedico().getIDMedico());
           }
       }else{
          System.out.println("no hay lista de horarios");   
       }         
   
    Horarios hr= daoHor.buscarHorariosId("HR0001");
        System.out.println("-"+hr.getLocal().getDescripcionLocal());

        
    
   String msgManHr= daoHor.MantenerHorario("3", "HR0007","MED001","LOC001","12/0/21","12:00AM");
   System.out.println(msgManHr);

    
    
    List list= new ArrayList();
    list = daoESP.listarEspecialista();
   
    if(list!=null){
        for(int i=0;i<list.size();i++){
        Especialista esp3= (Especialista)list.get(i);
           System.out.println(esp3.getApellidoMatEsp()+" "+esp3.getFechaInscripEsp()+" ");
       }
    }else{
          System.out.println("no hay lista de horarios");   
       }         
    
    String msgManHr= daoHor.MantenerHorario("3", "HOR001","MED001","LOC001","12/0/21","12:00AM","Disponible");
   System.out.println(msgManHr);

      */   
    
    
    Medico c= new Medico();
    c=daoMed.BuscarMedicoID("MED001");
    System.out.println(c.getNombre()+" "+c.getIdEsp().getNombreEsp());
    
  }
}
