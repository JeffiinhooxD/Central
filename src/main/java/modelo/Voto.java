package modelo;

import java.util.Date;

public class Voto {

    private String cpfEleitor;
    private Presidente presidente;
    private DeputadoFederal deputadoFederal;
    private int urna;
    private Date data;
    
    /**
     * Construtor da classe.
     * @param urna A urna em que aquele voto está sendo realizado.
     */
    public Voto (Urna urna){
        this.urna = urna.getCodigo();
        this.data = new Date(); /*Pega a data no momento que foi efetuado o voto*/
    }

    /**
     * Pega o cpf do eleitor.
     * @return String - O cpf.
     */
    public String getCpfEleitor() {
        return cpfEleitor;
    }

    /**
     * Seta o cpf do eleitor.
     * @param cpfEleitor O cpf a ser setado.
     */
    public void setCpfEleitor(String cpfEleitor) {
        this.cpfEleitor = cpfEleitor;
    }
    
    /**
     * Pega o presidente em que o eleitor votou.
     * @return Presidente - O objeto inteiro.
     */
    public Presidente getPresidente() {
        return presidente;
    }

    /**
     * Seta o presidente em que o eleitor votou.
     * @param presidente O Presidente a ser setado.
     */
    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }

    /**
     * Pega o deputado federal em que o eleitor votou.
     * @return DeputadoFederal - O objeto inteiro.
     */
    public DeputadoFederal getDeputadoFederal() {
        return deputadoFederal;
    }

    /**
     * Seta o deputado federal em que o eleitor votou.
     * @param deputadoFederal O Deputado federal a ser setado.
     */
    public void setDeputadoFederal(DeputadoFederal deputadoFederal) {
        this.deputadoFederal = deputadoFederal;
    }

    /**
     * Pega a data da realização do voto.
     * @return Date - A data.
     */
    public Date getData() {
        return data;
    }
    
    /**
     * Pega o código da urna.
     * @return int - O código.
     */
    public int getUrna(){
        return this.urna;
    }
}