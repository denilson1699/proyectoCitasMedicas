

package negocio;

public class Horarios {

private String IDHorario;
private Medico Medico;
private  Local local;
private String fecha,Hora, Estado;

    public Horarios() {
    }

    public Horarios(String IDHorario, Medico Medico, Local local, String fecha, String Hora, String Estado) {
        this.IDHorario = IDHorario;
        this.Medico = Medico;
        this.local = local;
        this.fecha = fecha;
        this.Hora = Hora;
        this.Estado = Estado;
    }

    public String getIDHorario() {
        return IDHorario;
    }

    public void setIDHorario(String IDHorario) {
        this.IDHorario = IDHorario;
    }

    public Medico getMedico() {
        return Medico;
    }

    public void setMedico(Medico Medico) {
        this.Medico = Medico;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
