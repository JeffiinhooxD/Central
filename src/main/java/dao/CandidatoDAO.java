package dao;

import modelo.CadCandidato;

public class CandidatoDAO {

    private CadCandidato candidatos[] = new CadCandidato[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(CadCandidato candidatos) {

        for (int i = 0; i < this.candidatos.length; i++) {			
            if (this.candidatos[i] == null) {
                this.candidatos[i] = candidatos;
                return true;
            }
        }
        return false;
    }
}