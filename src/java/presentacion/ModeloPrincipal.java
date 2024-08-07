
package presentacion;

import java.util.ArrayList;
import java.util.List;
import negocio.*;

public class ModeloPrincipal {
    
    private String msg="";
    private Object[] fil={"","","","","","","","","","","","","","",""};
    
    
    public List lisHorarios = new ArrayList();
    public Object[]filhorarios={"","","","","","",""};
    
    public List lisDet = new ArrayList();
    public Object[]filDet={"","","","","","","","",};
    
    public Horarios horario;
    public Especialista espesc;
    public Paciente paciente;
    public Medico medico;
    public Local local;
    public Cita cita;

    public List lis1 = new ArrayList();
    public Object[]fil1={"","","","","","","",};
    
    public List lis2 = new ArrayList();
    public Object[]fil2={"","","","","","","","",};

    public ModeloPrincipal() {
        lisHorarios.add(filhorarios);
        lisDet.add(filDet);
        lis1.add(fil1);
        lis2.add(fil2);
    }

    public List getLis1() {
        return lis1;
    }

    public void setLis1(List lis1) {
        this.lis1 = lis1;
    }

    public Object[] getFil1() {
        return fil1;
    }

    public void setFil1(Object[] fil1) {
        this.fil1 = fil1;
    }

    public List getLis2() {
        return lis2;
    }

    public void setLis2(List lis2) {
        this.lis2 = lis2;
    }

    public Object[] getFil2() {
        return fil2;
    }

    public void setFil2(Object[] fil2) {
        this.fil2 = fil2;
    }
    
    
    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public Especialista getEspesc() {
        return espesc;
    }

    public void setEspesc(Especialista espesc) {
        this.espesc = espesc;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    
    public List getLisDet() {
        return lisDet;
    }

    public void setLisDet(List lisDet) {
        this.lisDet = lisDet;
    }

    public Object[] getFilDet() {
        return filDet;
    }

    public void setFilDet(Object[] filDet) {
        this.filDet = filDet;
    }

    public List getLisHorario() {
        return lisHorarios;
    }

    public void setLisHorario(List lisHorarios) {
        this.lisHorarios = lisHorarios;
    }

    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object[] getFil() {
        return fil;
    }

    public void setFil(Object[] fil) {
        this.fil = fil;
    }

    void getFil(Object[] pac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
