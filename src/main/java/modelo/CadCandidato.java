package modelo;

import util.Verifica;

/**
 *
 * @author jeffi
 */
public class CadCandidato {
    
    private String nome;
    private int numero;
    private String cpf;
    private CadPartido partido;
    
    public String getNome(){
        return(this.nome);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getNumero(){
        return(this.numero);
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getCpf(){
        return(this.cpf);
    }
    
    public boolean setCpf(String cpf){
        
        /*Verifica se o cpf esta valido*/
        if (new Verifica().Cpf(cpf)){
              this.cpf = cpf;
              return true;
        }else{return false;}
    }
    
    public CadPartido getPartido(){
        return(this.partido);
    }
    
    public void setPartido(CadPartido partido){
        this.partido = partido;
    }

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