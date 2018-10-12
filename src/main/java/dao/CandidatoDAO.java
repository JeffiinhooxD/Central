package dao;

public class CandidatoDAO {

    private CandidatoDAO candidatoDAO[] = new CandidatoDAO[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(CandidatoDAO candidatoDAO) {

        for (int i = 0; i < this.candidatoDAO.length; i++) {			
            if (this.candidatoDAO[i] == null) {
                this.candidatoDAO[i] = candidatoDAO;
                return true;
            }
        }
        return false;
    }
}