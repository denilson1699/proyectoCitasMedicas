
package negocio;

public class Medico {

    private String IDMedico;
    private Especialista IdEsp;
    private TipoEspecialidadMedico idTEMedico;
    private String DniMed,ApellidoPatMed,ApellidoMatMed,Nombre,Sexo, Telefono,Email,HoraIngreso,HoraSalida,Pass,Estado;

    public Medico() {
    }

    public Medico(String IDMedico, Especialista IdEsp, TipoEspecialidadMedico idTEMedico, String DniMed, String ApellidoPatMed, String ApellidoMatMed, String Nombre, String Sexo, String Telefono, String Email, String HoraIngreso, String HoraSalida, String Pass, String Estado) {
        this.IDMedico = IDMedico;
        this.IdEsp = IdEsp;
        this.idTEMedico = idTEMedico;
        this.DniMed = DniMed;
        this.ApellidoPatMed = ApellidoPatMed;
        this.ApellidoMatMed = ApellidoMatMed;
        this.Nombre = Nombre;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Email = Email;
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
        this.Pass = Pass;
        this.Estado = Estado;
    }

    public String getIDMedico() {
        return IDMedico;
    }

    public void setIDMedico(String IDMedico) {
        this.IDMedico = IDMedico;
    }

    public Especialista getIdEsp() {
        return IdEsp;
    }

    public void setIdEsp(Especialista IdEsp) {
        this.IdEsp = IdEsp;
    }

    public TipoEspecialidadMedico getIdTEMedico() {
        return idTEMedico;
    }

    public void setIdTEMedico(TipoEspecialidadMedico idTEMedico) {
        this.idTEMedico = idTEMedico;
    }

    public String getDniMed() {
        return DniMed;
    }

    public void setDniMed(String DniMed) {
        this.DniMed = DniMed;
    }

    public String getApellidoPatMed() {
        return ApellidoPatMed;
    }

    public void setApellidoPatMed(String ApellidoPatMed) {
        this.ApellidoPatMed = ApellidoPatMed;
    }

    public String getApellidoMatMed() {
        return ApellidoMatMed;
    }

    public void setApellidoMatMed(String ApellidoMatMed) {
        this.ApellidoMatMed = ApellidoMatMed;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHoraIngreso() {
        return HoraIngreso;
    }

    public void setHoraIngreso(String HoraIngreso) {
        this.HoraIngreso = HoraIngreso;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

 
    
}
