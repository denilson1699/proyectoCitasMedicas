// proyecto Hotel
package negocio;


public class Especialista {
    private String IDEspe,DNIEsp,ApellidoPatEsp,ApellidoMatEsp,NombreEsp,sexoEsp,EmailEsp,TelefEsp,FechaInscripEsp,EstadoEsp,PassEsp;

    public Especialista() {
    }

    public Especialista(String IDEsp,String DNIEsp, String ApellidoPatEsp, String ApellidoMatEsp, String NombreEsp, String sexoEsp, String EmailEsp,  String TelefEsp, String FechaInscripEsp, String EstadoEsp, String PassEsp) {
        this.IDEspe=IDEsp;
        this.DNIEsp = DNIEsp;
        this.ApellidoPatEsp = ApellidoPatEsp;
        this.ApellidoMatEsp = ApellidoMatEsp;
        this.NombreEsp = NombreEsp;
        this.sexoEsp = sexoEsp;
        this.EmailEsp = EmailEsp;
        this.TelefEsp = TelefEsp;
        this.FechaInscripEsp = FechaInscripEsp;
        this.EstadoEsp = EstadoEsp;
        this.PassEsp = PassEsp;
    }

    public String getIDEspe() {
        return IDEspe;
    }

    public void setIDEspe(String IDEspe) {
        this.IDEspe = IDEspe;
    }

   

    public String getDNIEsp() {
        return DNIEsp;
    }

    public void setDNIEsp(String DNIEsp) {
        this.DNIEsp = DNIEsp;
    }

    public String getApellidoPatEsp() {
        return ApellidoPatEsp;
    }

    public void setApellidoPatEsp(String ApellidoPatEsp) {
        this.ApellidoPatEsp = ApellidoPatEsp;
    }

    public String getApellidoMatEsp() {
        return ApellidoMatEsp;
    }

    public void setApellidoMatEsp(String ApellidoMatEsp) {
        this.ApellidoMatEsp = ApellidoMatEsp;
    }

    public String getNombreEsp() {
        return NombreEsp;
    }

    public void setNombreEsp(String NombreEsp) {
        this.NombreEsp = NombreEsp;
    }

    public String getSexoEsp() {
        return sexoEsp;
    }

    public void setSexoEsp(String sexoEsp) {
        this.sexoEsp = sexoEsp;
    }

    public String getEmailEsp() {
        return EmailEsp;
    }

    public void setEmailEsp(String EmailEsp) {
        this.EmailEsp = EmailEsp;
    }

    public String getTelefEsp() {
        return TelefEsp;
    }

    public void setTelefEsp(String TelefEsp) {
        this.TelefEsp = TelefEsp;
    }

    public String getFechaInscripEsp() {
        return FechaInscripEsp;
    }

    public void setFechaInscripEsp(String FechaInscripEsp) {
        this.FechaInscripEsp = FechaInscripEsp;
    }

    public String getEstadoEsp() {
        return EstadoEsp;
    }

    public void setEstadoEsp(String EstadoEsp) {
        this.EstadoEsp = EstadoEsp;
    }

    public String getPassEsp() {
        return PassEsp;
    }

    public void setPassEsp(String PassEsp) {
        this.PassEsp = PassEsp;
    }
    
   
}
