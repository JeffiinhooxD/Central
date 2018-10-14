package dao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import modelo.CadEleitor;
import conexao.Conexao;

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
    
    public String igualdadeEleitor(CadEleitor e){
        
        for (int i = 0; i < eleitores.length; i++) {
            
            /*Trata o null pointer exception*/
            if (eleitores[i] != null){
                
                /*Verifica se o cpf e igual*/
                if (eleitores[i].getCpf().equals(e.getCpf())){
                    return "CPF";
                }
                
                /*Verifica se o titulo e igual*/
                if (eleitores[i].getNumeroTitulo().equals(e.getNumeroTitulo())){
                    return "TITULO";
                }
            }
        }
        
        return "";
    }
    
    public boolean inserirJson(CadEleitor eleitor){
        
        Gson gson = new Gson();
        
        FileWriter arq = null;
        try {
            arq = new FileWriter("./ArquivosJson/Eleitor.json", true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao salvar o eleitor no arquivo json", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        PrintWriter escreveArq = new PrintWriter(arq);
        escreveArq.printf("%s", gson.toJson(eleitor));
        
        try {
            arq.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao fechar o arquivo json", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public boolean enviaDrive(){
        
        try {
            
            String idPas = Conexao.existePasta("ArquivosJson");            
            if (idPas.equals("")){
                idPas = Conexao.criaPasta(Conexao.service(), "ArquivosJson");    
            }
            
            String idArq = Conexao.existeArquivo("Eleitor.json");          

            if (idArq.equals("")){                
                idArq = Conexao.enviaArquivo(idPas, "Eleitor.json");
            }
            
            Conexao.removeArquivo(idArq);
            Conexao.enviaArquivo(idPas, "Eleitor.json");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve erro ao conectar com o drive para salvar o arquivo..", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}