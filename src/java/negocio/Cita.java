// proyecto hotel
package negocio;

public class Cita {
  private String CodigoCita;
  private Paciente Idpac;
  private Horarios idHora;
  private String FechaReg,Estado,Comentario;

    public Cita() {
    }

    public Cita(String CodigoCita, Paciente Idpac, Horarios idHora, String FechaReg, String Estado, String Comentario) {
        this.CodigoCita = CodigoCita;
        this.Idpac = Idpac;
        this.idHora = idHora;
        this.FechaReg = FechaReg;
        this.Estado = Estado;
        this.Comentario = Comentario;
    }

    public String getCodigoCita() {
        return CodigoCita;
    }

    public void setCodigoCita(String CodigoCita) {
        this.CodigoCita = CodigoCita;
    }

    public Paciente getIdpac() {
        return Idpac;
    }

    public void setIdpac(Paciente Idpac) {
        this.Idpac = Idpac;
    }

    public Horarios getIdHora() {
        return idHora;
    }

    public void setIdHora(Horarios idHora) {
        this.idHora = idHora;
    }

    public String getFechaReg() {
        return FechaReg;
    }

    public void setFechaReg(String FechaReg) {
        this.FechaReg = FechaReg;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

   
  

}
