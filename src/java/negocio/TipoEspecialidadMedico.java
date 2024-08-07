
package negocio;


public class TipoEspecialidadMedico {
   private  String IDTEMedico;
   private  String Descripcion;

    public TipoEspecialidadMedico() {
    }

    public TipoEspecialidadMedico(String IDTEMedico, String Descripcion) {
        this.IDTEMedico = IDTEMedico;
        this.Descripcion = Descripcion;
    }

    public String getIDTEMedico() {
        return IDTEMedico;
    }

    public void setIDTEMedico(String IDTEMedico) {
        this.IDTEMedico = IDTEMedico;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
   
   
}
