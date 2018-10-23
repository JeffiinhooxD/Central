package dao;

import com.google.gson.Gson;
import java.io.IOException;
import modelo.Voto;
import conexao.Conexao;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.data.general.DefaultPieDataset;

public class VotoDAO {
    
    private Voto votos [] = new Voto[50];
    
    /*Insere o eleitor na primeira posicao vazia que achar do vetor*/
    public boolean inserir(Voto votos) {

        for (int i = 0; i < this.votos.length; i++) {			
            if (this.votos[i] == null) {
                this.votos[i] = votos;
                return true;
            }
        }
        return false;
    }
    
    public Voto [] getVoto(){
        return this.votos;
    }
    
    public void baixarVotoJson() throws IOException{
        
        Gson gson = new Gson();
        
        /*Auxiliar para pegar o conteudo do arquivo*/
        String aux = null;        
        try {
            
            /*Verifica se a pasta existe*/
            String idPas = Conexao.existePasta("ArquivosJson"); 
            if (!(idPas.equals(""))){
                
                /*Verifica se o arquivo existe*/
                String idArq = Conexao.existeArquivo("Voto.json");
                if (!(idArq.equals(""))){
                    
                    /*Se existir o arquivo coloca nessa variavel o conteudo dele*/
                    aux = Conexao.printFile(idArq);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível baixar os dados dos votos, verifique sua conexão com a internet..", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        /*Caso esta variavel esteja nula e porque nao ha o arquivo para baixar ou ele esta vazio*/
        if (aux != null){
            
            /*Cria um vetor dinamico de votos*/
            List <Voto> voto = new ArrayList<>();

            /*Transforma cada linha do json em objeto do tipo voto e adiciona no vetor dinamico*/
            BufferedReader verifica = new BufferedReader(new StringReader(aux));        
            String linha;        
            while((linha = verifica.readLine()) != null){
                voto.add(gson.fromJson(linha, Voto.class)); 
            }

            /*Joga no vetor estatico cada posicao do vetor dinamico*/
            for (int i = 0; i < voto.size(); i++) {
                if(this.votos[i] == null){
                    this.votos[i] = voto.get(i);
                }
            }
        }
    }
    
    public DefaultPieDataset preencheGrafico(){
        
        DefaultPieDataset dataSet = new DefaultPieDataset();
        
        /*Populando o grafico com o nome dos candidatos, partido e a quantida de votos*/
        for (Voto v: votos){
            if (v != null){
                
                /*Verificacao utilizada pois caso o eleitor vote NULO ou BRANCO nao da erro quando chegar aqui*/
                if (v.getCandidato() != null){
                    dataSet.setValue(v.getCandidato().getNome() + " - " + v.getCandidato().getPartido().getSigla(), v.getCandidato().getQtdeVoto());
                }                
            }            
        }
        
        return dataSet;
    }
    
    public boolean verificaAlguemVotou(){
        
        for (Voto v: votos){
            
            if (v != null){

                /*Verificacao utilizada pois caso o eleitor vote NULO ou BRANCO nao da erro quando chegar aqui*/
                if (v.getCandidato() != null){
                    
                    /*Se pelo menos um eleitor ja votou naquele candidato entao retorna*/
                    if (v.getCandidato().getQtdeVoto() > 0){
                        return true;
                    }
                }
            }            
        }
        
        /*Nenhum eleitor votou*/
        return false;
    }
}