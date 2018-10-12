package dao;

public class EleitorDAO {
    
    private EleitorDAO eleitorDAO[] = new EleitorDAO[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(EleitorDAO eleitorDAO) {

        for (int i = 0; i < this.eleitorDAO.length; i++) {			
            if (this.eleitorDAO[i] == null) {
                this.eleitorDAO[i] = eleitorDAO;
                return true;
            }
        }
        return false;
    }
}