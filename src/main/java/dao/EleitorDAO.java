package dao;

import modelo.CadEleitor;

public class EleitorDAO {
    
    private CadEleitor eleitores[] = new CadEleitor[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(CadEleitor eleitores) {

        for (int i = 0; i < this.eleitores.length; i++) {			
            if (this.eleitores[i] == null) {
                this.eleitores[i] = eleitores;
                return true;
            }
        }
        return false;
    }
}