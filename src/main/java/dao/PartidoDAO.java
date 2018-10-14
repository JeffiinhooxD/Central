package dao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import modelo.CadPartido;
import conexao.Conexao;

public class PartidoDAO {
    
    private CadPartido partidos[] = new CadPartido[50];
	
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(CadPartido partidos) {

        for (int i = 0; i < this.partidos.length; i++) {			
            if (this.partidos[i] == null) {
                this.partidos[i] = partidos;
                return true;
            }
        }
        return false;
    }
    
    public String igualdadePartido(CadPartido p){
        
        for (int i = 0; i < partidos.length; i++) {
            
            /*Trata o null pointer exception*/
            if (partidos[i] != null){
                
                /*Verifica se o nome e igual*/
                if (partidos[i].getNome().equals(p.getNome())){
                    return "NOME";
                }
                
                /*Verifica se a sigla e igual*/
                if (partidos[i].getSigla().equals(p.getSigla())){
                    return "SIGLA";
                }
                
                /*Verifica se o numero e igual*/
                if (partidos[i].getNumero() == p.getNumero()){
                    return "NUMERO";
                }
            }
        }
        
        return "";
    }
    
    public boolean existeAlgumPartido(){
        
        for (int i = 0; i < partidos.length; i++) {
            
            /*Trata o null pointer exception*/
            if (partidos[i] != null){
                return true;
            }            
        }
        
        return false;
    }
    
    public boolean inserirJson(CadPartido partido){
        
        Gson gson = new Gson();
        
        FileWriter arq = null;
        try {
            arq = new FileWriter("./ArquivosJson/Partido.json", true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao salvar o partido no arquivo json", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        PrintWriter escreveArq = new PrintWriter(arq);
        escreveArq.printf("%s", gson.toJson(partido));
        
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
            
            String idArq = Conexao.existeArquivo("Partido.json");          

            if (idArq.equals("")){                
                idArq = Conexao.enviaArquivo(idPas, "Partido.json");
            }
            
            Conexao.removeArquivo(idArq);
            Conexao.enviaArquivo(idPas, "Partido.json");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve erro ao conectar com o drive para salvar o arquivo..", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public CadPartido[] getVetorPartido(){
        return this.partidos;
    }
    
    public CadPartido getPartidoBySigla(String sigla){
        
        for (CadPartido p: this.partidos){
            if (p != null){
                if (p.getSigla().toUpperCase().equals(sigla.toUpperCase())){
                    return p;
                }
            }            
        }

        return null;
    }
}