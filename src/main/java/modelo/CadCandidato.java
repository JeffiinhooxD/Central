package modelo;

import util.Verifica;

public class CadCandidato {
    
    private String nome;
    private int numero;
    private String cpf;
    private CadPartido partido;
    private int qtdeVoto;

    /**
     * Construtor da classe, seta a quantidade de votos do candidato para 0.
     */
    public CadCandidato(){
        this.qtdeVoto = 0;
    }
    
    /**
     * Pega a quantidade de votos daquele candidato.
     * @return int - A quantidade de votos.
     */
    public int getQtdeVoto() {
        return qtdeVoto;
    }

    /**
     * Seta a quantidade de votos.
     * @param qtdeVoto Quantidade de votos a ser setada.
     */
    public void setQtdeVoto(int qtdeVoto) {
        this.qtdeVoto += qtdeVoto;
    }
    
    /**
     * Pega o nome do candidato.
     * @return String - O nome.
     */
    public String getNome(){
        return(this.nome);
    }
    
    /**
     * Seta o nome do candidato.
     * @param nome O nome a ser setado.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Pega o número do candidato.
     * @return int - O número.
     */
    public int getNumero(){
        return(this.numero);
    }
    
    /**
     * Seta o número do candidato.
     * @param numero O número a ser setado.
     */
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    /**
     * Pega o cpf do candidato.
     * @return String - O cpf.
     */
    public String getCpf(){
        return(this.cpf);
    }
    
    /**
     * Seta o cpf do candidato e verifica se ele é válido ou não.
     * @param cpf O cpf a ser setado.
     * @return boolean - Retorna true se o cpf for válido, caso contrário retorna false.
     */
    public boolean setCpf(String cpf){
        
        /*Verifica se o cpf esta valido*/
        if (new Verifica().Cpf(cpf)){
              this.cpf = cpf;
              return true;
        }else{return false;}
    }
    
    /**
     * Pega o partido do candidato.
     * @return CadPartido - O partido.
     */
    public CadPartido getPartido(){
        return(this.partido);
    }
    
    /**
     * Seta o partido do candidato.
     * @param partido O partido a ser setado.
     */
    public void setPartido(CadPartido partido){
        this.partido = partido;
    }

    /**
     * Utilizada pegar os dados do objeto.
     * @return String - Retorna os dados do objeto em forma de String.
     */
    @Override
    public String toString() {        
        return ("Nome:    " + this.nome                 + "\n" +
                "Numero:  " + this.numero               + "\n" +
                "Cpf:     " + this.cpf                  + "\n" +                
                "Partido: \n"                           +
                "\tNome:   " + this.partido.getNome()   + "\n" +
                "\tNumero: " + this.partido.getNumero() + "\n");
    }
}