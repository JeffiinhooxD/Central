package dao;

public class PartidoDAO {
    
    private PartidoDAO partidoDAO[] = new PartidoDAO[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(PartidoDAO partidoDAO) {

        for (int i = 0; i < this.partidoDAO.length; i++) {			
            if (this.partidoDAO[i] == null) {
                this.partidoDAO[i] = partidoDAO;
                return true;
            }
        }
        return false;
    }
}