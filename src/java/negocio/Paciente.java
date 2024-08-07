// proyecto hotel
package negocio;

public class Paciente {
    private String IDPac, DNIPac, ApellidoPatPac, ApellidoMatPac, NombrePac, GeneroPac, EmailPac, TelefPac, FechaRegistroPac,  EstadoPac,  PassPac;
 
  
   public Paciente() {
   
   }

    public Paciente(String IDPac, String DNIPac, String ApellidoPatPac, String ApellidoMatPac, String NombrePac, String GeneroPac, String EmailPac, String TelefPac, String FechaRegistroPac, String EstadoPac, String PassPac) {
        this.IDPac = IDPac;
        this.DNIPac = DNIPac;
        this.ApellidoPatPac = ApellidoPatPac;
        this.ApellidoMatPac = ApellidoMatPac;
        this.NombrePac = NombrePac;
        this.GeneroPac = GeneroPac;
        this.EmailPac = EmailPac;
        this.TelefPac = TelefPac;
        this.FechaRegistroPac = FechaRegistroPac;
        this.EstadoPac = EstadoPac;
        this.PassPac = PassPac;
    }

    public String getIDPac() {
        return IDPac;
    }

    public void setIDPac(String IDPac) {
        this.IDPac = IDPac;
    }

    public String getDNIPac() {
        return DNIPac;
    }

    public void setDNIPac(String DNIPac) {
        this.DNIPac = DNIPac;
    }

    public String getApellidoPatPac() {
        return ApellidoPatPac;
    }

    public void setApellidoPatPac(String ApellidoPatPac) {
        this.ApellidoPatPac = ApellidoPatPac;
    }

    public String getApellidoMatPac() {
        return ApellidoMatPac;
    }

    public void setApellidoMatPac(String ApellidoMatPac) {
        this.ApellidoMatPac = ApellidoMatPac;
    }

    public String getNombrePac() {
        return NombrePac;
    }

    public void setNombrePac(String NombrePac) {
        this.NombrePac = NombrePac;
    }

    public String getGeneroPac() {
        return GeneroPac;
    }

    public void setGeneroPac(String GeneroPac) {
        this.GeneroPac = GeneroPac;
    }

    public String getEmailPac() {
        return EmailPac;
    }

    public void setEmailPac(String EmailPac) {
        this.EmailPac = EmailPac;
    }

    public String getTelefPac() {
        return TelefPac;
    }

    public void setTelefPac(String TelefPac) {
        this.TelefPac = TelefPac;
    }

    public String getFechaRegistroPac() {
        return FechaRegistroPac;
    }

    public void setFechaRegistroPac(String FechaRegistroPac) {
        this.FechaRegistroPac = FechaRegistroPac;
    }

    public String getEstadoPac() {
        return EstadoPac;
    }

    public void setEstadoPac(String EstadoPac) {
        this.EstadoPac = EstadoPac;
    }

    public String getPassPac() {
        return PassPac;
    }

    public void setPassPac(String PassPac) {
        this.PassPac = PassPac;
    }
   

}
