
package negocio;

public class Local {
    
    private String IDLocal;
    private String DescripcionLocal,Direccion,Provincia,Distrito;

    public Local() {
    }

    public Local(String IDLocal, String DescripcionLocal, String Direccion, String Provincia, String Distrito) {
        this.IDLocal = IDLocal;
        this.DescripcionLocal = DescripcionLocal;
        this.Direccion = Direccion;
        this.Provincia = Provincia;
        this.Distrito = Distrito;
    }

    public String getIDLocal() {
        return IDLocal;
    }

    public void setIDLocal(String IDLocal) {
        this.IDLocal = IDLocal;
    }

    public String getDescripcionLocal() {
        return DescripcionLocal;
    }

    public void setDescripcionLocal(String DescripcionLocal) {
        this.DescripcionLocal = DescripcionLocal;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }
    
    
}
