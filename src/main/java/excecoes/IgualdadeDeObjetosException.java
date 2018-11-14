package excecoes;

/**
 * 
 */
public class IgualdadeDeObjetosException extends Exception {
    
    /**
     * Construtor sem parâmetros da classe.
     */
    public IgualdadeDeObjetosException() {
        super ();
    }
    
    /**
     * Construtor com parâmetros da classe.
     * @param s A mensagem de erro.
     */
    public IgualdadeDeObjetosException(String s) {
        super(s);
    }
}