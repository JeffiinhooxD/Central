package excecoes;

/**
 * 
 */
public class CampoObrigatorioException extends Exception {
    
    /**
     * Construtor sem parâmetros da classe.
     */
    public CampoObrigatorioException() {
        super ();
    }
    
    /**
     * Construtor com parâmetros da classe.
     * @param s A mensagem de erro.
     */
    public CampoObrigatorioException(String s) {
        super(s);
    }
}