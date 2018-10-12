package modelo;

import validacoes.Verifica;

/**
 *
 * @author paulo
 */
public class Eleitor {    
    
    private String numeroTitulo;
    private String nome;
    private String cpf;
    private String secao;
    
    public String getNome(){
        return(this.nome);
    }

    public void setNome(String nome){
        this.nome = nome;
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
    
    public String getSecao(){
        return(this.secao);
    }
    
    public void setSecao(String secao){
        this.secao = secao;
    }
    
    public String getNumeroTitulo(){
        return(this.numeroTitulo);
    }
    
    public void setNumeroTitulo(String numeroTitulo){
        this.numeroTitulo = numeroTitulo;
    }
}