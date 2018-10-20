package modelo;

import java.util.Date;

public class Voto {

    private String cpfEleitor;
    private CadCandidato candidato = new CadCandidato();
    private int urna;
    private Date data;
    
    public Voto (Urna urna){
        this.urna = urna.getCodigo();
        this.data = new Date(); 
    }

    public String getCpfEleitor() {
        return cpfEleitor;
    }

    public void setCpfEleitor(String cpfEleitor) {
        this.cpfEleitor = cpfEleitor;
    }

    public CadCandidato getCandidato() {
        return candidato;
    }

    public void setCandidato(CadCandidato candidato) {
        this.candidato = candidato;
    }

    public Date getData() {
        return data;
    }
    
    public int getUrna(){
        return this.urna;
    }
}