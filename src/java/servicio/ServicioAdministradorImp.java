
package servicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.*;
import persistencia.*;


public class ServicioAdministradorImp implements ServicioAdministrador{
    private DaoAdministrador daoAdm;  
    private DaoHorario daoHor; 
    private DaoMedico daoMedico;
    private DaoLocal daoLocal;
    private DaoCita daoCita;
    private DaoEspecialista daoEsp;
    private DaoTEMedico daoTEMedico;
    private DaoPaciente daoPac;
    
    public ServicioAdministradorImp() {
        daoAdm = new DaoAdministradorImp();
        daoHor= new DaoHorarioImp();
        daoMedico= new DaoMedicoImp();
        daoLocal= new DaoLocalImp();
        daoCita = new DaoCitaImp();
        daoEsp = new DaoEspecialistaImp();
        daoTEMedico = new DaoTEMedicoImp();
        daoPac = new DaoPacienteImp();        
    }
    

    
    
    //Logear
    @Override
    public Object[] Login(String dni, String pass) {
        return daoAdm.logearAdministrador(dni, pass);
    }
     // recuperar el codigo de una tabla
    public String getNumeroAuto(String NombreTabla){
      String num="";
      List tabla=new ArrayList();
        switch(NombreTabla){
            case "citas": tabla= daoCita.listarCitas(); 
                          Cita cit=null;
                          for(int i=0;i<tabla.size();i++){
                              cit=(Cita)tabla.get(i);
                          }
                          num=cit.getCodigoCita();                        
                break;
                
            case "especialista":tabla= daoEsp.listarEspecialista();
                                Especialista esp=null;
                                for(int i=0;i<tabla.size();i++){
                                    esp=(Especialista)tabla.get(i);
                                }
                                num=esp.getIDEspe();  
                break;
                
            case "horario": tabla= daoHor.listarHorarios();
                          Horarios hor=null;
                          for(int i=0;i<tabla.size();i++){
                              hor=(Horarios)tabla.get(i);
                          }
                          num=hor.getIDHorario();
                break;
                                                                
            case "local":tabla= daoLocal.listarLocales();
                          Local loc=null;
                          for(int i=0;i<tabla.size();i++){
                              loc=(Local)tabla.get(i);
                          }
                          num=loc.getIDLocal();  
                break;
                
            case "medico":tabla= daoMedico.listarMedicos();
                          Medico med=null;
                          for(int i=0;i<tabla.size();i++){
                              med=(Medico)tabla.get(i);
                          }
                          num=med.getIDMedico();  
                break;
                
            case "paciente":tabla= daoPac.listarPacientes();
                          Paciente pac=null;
                          for(int i=0;i<tabla.size();i++){
                              pac=(Paciente)tabla.get(i);
                          }
                          num=pac.getIDPac();  
                break;
                
            case "TipoEspMedico":tabla= daoTEMedico.listarTipoEspecialidadMedico();
                          TipoEspecialidadMedico TEMedico=null;
                          for(int i=0;i<tabla.size();i++){
                              TEMedico=(TipoEspecialidadMedico)tabla.get(i);
                          }
                          num=TEMedico.getIDTEMedico();  
                break;
        }
        String numStr= num.substring(0,3);// obtener la las letras
        String numInt=num.substring(3);// obtener los numeros
        String numGen= String.valueOf(Integer.parseInt(numInt)+1);
        while(numGen.length()<3){
             numGen='0'+numGen; // rellenar 
        }
        return numStr+numGen;
    }
    // recuperar la fecha del sistema
    public String getFecha(){
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
    

    //Recuperar el codigo auto generado citas - especialista - horario - local - medico - paciente - TipoEspMedico
    @Override
    public String GenerarCodigoAuto(String NombreTabla) {
        return getNumeroAuto(NombreTabla);
    }
    @Override
    public String GenerarFecActual() {
        return getFecha();
    }

    Paciente PACVacio= new Paciente("", "", "", "", "", "", "", "","", "", "");
    Especialista espVacio= new Especialista("", "", "", "", "", "", "", "", "", "", "");
    TipoEspecialidadMedico TEMVacio= new TipoEspecialidadMedico("", "");
    Medico medVacio= new Medico("", espVacio, TEMVacio, "", "", "", "", "", "", "", "", "", "", "");
    Local locVacio= new Local("", "", "", "", "");
    Horarios horVacio= new Horarios("", medVacio, locVacio, "", "","");
    Cita citVacio= new Cita("", PACVacio, horVacio, "", "", "");
            
    


    /*-------------
    HORARIOS
    ------------*/

     @Override
    public Horarios nuevoHorario() {
        return  horVacio;
    }
    
    //Listar todos los horarios

    @Override
    public List verAllHorarios() {
       List Lista =daoHor.listarHorarios();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }
    //Buscar Horario con ID
    @Override
    public Horarios buscarHorarioId(String id) {
      Horarios horario =daoHor.buscarHorariosId(id);
      if(horario!=null){
      return horario;
     }
     return null;
    }

    //Mantenimiento de horario
    @Override
    public String MantenerHorario(String operacion, String IDHorario, String IDMedico, String IDLoca, String fecha, String hora,String est) {
        return daoHor.MantenerHorario(operacion, IDHorario, IDMedico, IDLoca, fecha, hora, est);
    }


    /*-------------
    MEDICO
    ------------*/
    

    @Override
    public Medico nuevoMedico() {
        return medVacio;
    }

    @Override
    public List verAllMedicos() {
       List Lista =daoMedico.listarMedicos();
       if(Lista!=null){
      return Lista;
     }
     return null;
  }

    @Override
    public Medico buscarMedidoID(String id) {
      Medico med =daoMedico.BuscarMedicoID(id);
      if(med!=null){
      return med;
     }
     return null;
    }

    @Override
    public String MantenerMedico(String Oper, String IDMedico, String IdEsp, String idTEMedico, String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado) {
    return daoMedico.MantenerMedico(Oper, IDMedico, IdEsp, idTEMedico, DniMed, ApellidoPatMed, ApellidoMatMed, Nombre, Sexo, Telefono, Email, HoraIngreso, HoraSalida, Pass, Estado);
    }

    
    
    /*-------------
    PACIENTE
    ------------*/
    @Override
    public Paciente nuevoPaciente() {
        return  PACVacio;
    }

    @Override
    public List verAllPacientes() {
      List Lista =daoPac.listarPacientes();
      if(Lista!=null){
            return Lista;
        }
        return null;
    }

    @Override
    public Paciente buscarPacienteID(String id) {
      Paciente pac =daoPac.BuscarPacienteID(id);
      if(pac!=null){
      return pac;
     }
     return null;
    }

    @Override
    public String MantenerPaceinte(String oper, String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac) {
        return daoPac.MantenerPaceinte(oper, IDPac, DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac, FechaRegistroPac, EstadoPac, PassPac);
    }
    
    

    /*-------------
    ESPECIALISTA
    ------------*/
    @Override
    public Especialista nuevoEspecialista() {
        return  espVacio;
    }

    @Override
    public List verAllEspecialistas() {
           List Lista =daoEsp.listarEspecialista();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public Especialista buscarEspecialistaID(String id) {
      Especialista esp =daoEsp.BuscarEspecialistaID(id);
      if(esp!=null){
      return esp;
     }
     return null;
    }

    @Override
    public String MantenerEspecialista(String oper, String ID, String dni, String ApePar, String apelMat, String nomb, String sex, String telf,String mail, String fchIns, String pass,String est) {
    return daoEsp.MantenerEspecialista(oper, ID, dni, ApePar, apelMat, nomb, sex, telf, mail, fchIns, pass, est);
    }

    
    
    /*-------------
    LOCAL
    ------------*/
     @Override
    public Local nuevoLocal() {
       return  locVacio;
    }

    @Override
    public List verAllLocales() {
      List Lista =daoLocal.listarLocales();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public Local buscarLocalID(String id) {
      Local loc =daoLocal.BuscarLocal(id);
      if(loc!=null){
      return loc;
     }
     return null;
    }

    @Override
    public String MantenerLocal(String oper,String IDLocal, String DescripcionLocal, String Direccion, String Provincia, String Distrito) {
    return daoLocal.MantenerLocal(oper,IDLocal, DescripcionLocal, Direccion, Provincia, Distrito);
    }

    
    /*-------------
    TIPO ESPECIALIDAD MEDICO
    ------------*/
    @Override
    public TipoEspecialidadMedico nuevoTipoEspecialidadMedico() {
       return  TEMVacio;
    }

    @Override
    public List verAllTipoEspecialidadMedico() {
           List Lista =daoTEMedico.listarTipoEspecialidadMedico();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public TipoEspecialidadMedico buscarTipoEspecialidadMedicoID(String id) {
      TipoEspecialidadMedico TEM =daoTEMedico.buscarTipoEspecialidadMedicoID(id);
      if(TEM!=null){
      return TEM;
     }
     return null;
    }

    @Override
    public String MantenerTipoEspMedico(String oper, String IDLoc, String Descr) {
      return daoTEMedico.MantenerLocal(oper, IDLoc, Descr);
    }
    
    
    /*-------------
    CITAS
    ------------*/
    @Override
    public Cita NuevaCita() {
        return citVacio;
    }

    @Override
    public List verAllCitas() {
       List Lista =daoCita.listarCitas();
       if(Lista!=null){
      return Lista;
     }
     return null;
    }

    @Override
    public Cita buscarCitaID(String id) {
      Cita cit =daoCita.buscarCitasId(id);
      if(cit!=null){
      return cit;
     }
     return null;
    }

    @Override
    public String MantenerCitas(String oper,String CodigoCita, String Idpac, String idHora, String FechaReg, String Estado, String Comentario) {
        return daoCita.MantenerCitas(oper,CodigoCita, Idpac, idHora, FechaReg, Estado, Comentario);
    }

    @Override
    public Medico llenandoNuevoMedico(String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado) {
        Especialista espVacio= new Especialista("", "", "", "", "", "", "", "", "", "", "");
        TipoEspecialidadMedico TEMVacio= new TipoEspecialidadMedico("", "");
        Medico medLlenando= new Medico("", espVacio, TEMVacio, DniMed, ApellidoPatMed, ApellidoMatMed, Nombre, Sexo, Telefono, Email, HoraIngreso, HoraSalida, Pass, Estado);
        return  medLlenando;
    }




   

    
}
