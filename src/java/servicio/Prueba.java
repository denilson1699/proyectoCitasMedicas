package servicio;
import java.util.ArrayList;
import java.util.List;
import negocio.*;
import persistencia.DaoEspecialista;
import persistencia.DaoEspecialistaImp;
import persistencia.Operacion;

public class Prueba {

public static void main(String[] args) {
    ServicioPaciente serPac= new ServicioPacienteImp();
    ServicioEspecialista serEsp= new ServicioEspecialistaImp();
    ServicioAdministrador serAdm= new ServicioAdministradorImp();
    
  
/*
  String msg=serPac.GrabarNuevoPaciente("00345600", "00APELLIDOPATPAC21", "00APELLIDOMATPAC21", "00NOMBREPAC21", "M","00@jaramillo", "003123100", "activo", "000");
  System.out.println("repuesta::"+msg);
   
      
  Object[] pac= serEsp.Login("76131029", "123");
  if(pac!=null){
      System.out.println("-"+pac[1]+pac[2]+pac[3]);
  }else{
      System.out.println("no existe paciente");
  }

  Object[] adm= serAdm.Login("76131030", "de");
  if(adm!=null){
      System.out.println("-"+adm[1]+adm[2]+adm[3]);
  }else{
      System.out.println("no existe administrador");
  
  }
 
    
   List list= serAdm.verAllHorarios();
   if(list!=null){
           for(int i=0;i<list.size();i++){
               Horarios esp3= (Horarios)list.get(i);
            System.out.println(esp3.getFecha()+" "+esp3.getHoraCita()+" "
            +esp3.getLocal().getDescripcionLocal()+" "+esp3.getMedico().getIDMedico());
           }
       }else{
          System.out.println("no hay lista de horarios");   
       }    

      
    List lis=new ArrayList();
   lis=(List) serAdm.buscarHorarioId("HR0001");
   for(int i=0;i<lis.size();i++){
      Horarios esp3= (Horarios)lis.get(i);
      System.out.println(esp3.getFecha()+" "+esp3.getHoraCita()+" "
      +esp3.getLocal().getDescripcionLocal()+" "+esp3.getMedico().getIDMedico());
      lis.add(lis);
    }    
    // comprobamos el codigo autogenerado
    System.out.println(serAdm.GenerarCodigoAuto("citas"));
//citas - especialista - horario - local - medico - paciente - TipoEspMedico
    System.out.println(serAdm.GenerarFecActual());

    

        Paciente pac=serPac.BuscarPacientId("PAC001");
        System.out.println(pac.getApellidoPatPac());
        
        
     */  
    List lis=new ArrayList();
   lis=(List) serPac.ListarCitaIDPac("PAC001");
   for(int i=0;i<lis.size();i++){
      Cita esp3= (Cita)lis.get(i);
      System.out.println(esp3.getFechaReg()+" "+esp3.getIdpac().getNombrePac());
      lis.add(lis);
        
   }
        
 }


}
