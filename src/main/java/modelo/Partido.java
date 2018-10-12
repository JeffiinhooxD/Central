package modelo;

/**
 *
 * @author jeffi
 */
public class Partido {

    private String nome;
    private short numero;
    
    public String getNome(){
        return(this.nome);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public short getNumero(){
        return(this.numero);
    }
    
    public void setNumero(short numero){
        this.numero = numero;
    }

    @Override
    public String toString() {
        return ("Nome: "   + this.nome   + "\n" +
                "Numero: " + this.numero + "\n");
    }
}