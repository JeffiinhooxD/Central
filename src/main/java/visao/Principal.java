package visao;

import modelo.Urna;
import dao.*;
import modelo.*;
import conexao.Conexao;
import excecoes.PartidoException;
import java.awt.Color;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.data.general.PieDataset;

public class Principal extends javax.swing.JFrame {

    CandidatoDAO candidatoDAO = new CandidatoDAO();
    EleitorDAO   eleitorDAO   = new EleitorDAO();
    PartidoDAO   partidoDAO   = new PartidoDAO();
    VotoDAO      votoDAO      = new VotoDAO();
    Urna         urna         = new Urna();
    
    Runtime r = Runtime.getRuntime();
    
    /**
     * Construtor da classe sem parâmetros.
     * @throws IOException 
     */
    public Principal() throws IOException {
        
        initComponents();
        
        this.setTitle("Central");
        this.getContentPane().setBackground(Color.WHITE);       
        this.setExtendedState(MAXIMIZED_BOTH);
        
        /*Verifica se a pasta local esta criada*/
        File dir = new File("ArquivosJson");
        
        /*Caso nao estiver entao cria*/
        dir.mkdirs();
        
        /*Iniciando servico e baixa do drive caso o banco de dados esteja preenchida*/
        Conexao.service();
        
        /*Baixa os arquivos .json do drive e coloca na pasta ArquivosJson, sao usadas Threads para ficar mais rapido o processo*/
        Thread p = new Thread(){
            @Override
            public void run() {
                try {
                    partidoDAO.baixarPartidoJson();
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }            
        };

        Thread e = new Thread(){
            @Override
            public void run() {
                try {
                    eleitorDAO.baixarEleitorJson();
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }            
        };

        Thread c = new Thread(){
            @Override
            public void run() {
                try {
                    candidatoDAO.baixarCandidatoJson();
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }            
        };
            
        p.start();
        e.start();
        c.start();
        
        try {
            
            /*Espera cada Thread ser finalizada para prosseguir*/
            p.join();
            p.interrupt();
            e.join();
            e.interrupt();
            c.join();
            c.interrupt();

        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void teste(){
            
        Thread t2 = new Thread() {
            
            @Override
            public void run() {

                try {

                    String myScript = "xcowsay Easter egg encontrado com sucesso!";
                    String[] cmdArray = {"xterm", "-e", myScript};
                    r.exec(cmdArray).waitFor();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        };

        t2.start();

        try {

            t2.join();
            t2.interrupt();

        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBarraPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroCandidato = new javax.swing.JMenu();
        menuCadastroCandidatoPresidente = new javax.swing.JMenuItem();
        menuCadastroCandidatoDeputadoEstadual = new javax.swing.JMenuItem();
        menuCadastroEleitor = new javax.swing.JMenuItem();
        menuCadastroPartido = new javax.swing.JMenuItem();
        menuUtilitarios = new javax.swing.JMenu();
        computarVotos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");
        setBackground(new java.awt.Color(216, 43, 48));
        setForeground(java.awt.Color.red);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo - Copia.png"))); // NOI18N

        menuBarraPrincipal.setBackground(new java.awt.Color(1, 1, 1));
        menuBarraPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        menuBarraPrincipal.setForeground(new java.awt.Color(245, 175, 19));

        menuCadastro.setForeground(new java.awt.Color(234, 168, 19));
        menuCadastro.setText("Cadastro");
        menuCadastro.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        menuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroMouseEntered(evt);
            }
        });

        menuCadastroCandidato.setText("Candidato");
        menuCadastroCandidato.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoMouseEntered(evt);
            }
        });

        menuCadastroCandidatoPresidente.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        menuCadastroCandidatoPresidente.setText("Presidente");
        menuCadastroCandidatoPresidente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoPresidenteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoPresidenteMouseEntered(evt);
            }
        });
        menuCadastroCandidatoPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCandidatoPresidenteActionPerformed(evt);
            }
        });
        menuCadastroCandidato.add(menuCadastroCandidatoPresidente);

        menuCadastroCandidatoDeputadoEstadual.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        menuCadastroCandidatoDeputadoEstadual.setText("Deputado Estadual");
        menuCadastroCandidatoDeputadoEstadual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoDeputadoEstadualMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoDeputadoEstadualMouseEntered(evt);
            }
        });
        menuCadastroCandidatoDeputadoEstadual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCandidatoDeputadoEstadualActionPerformed(evt);
            }
        });
        menuCadastroCandidato.add(menuCadastroCandidatoDeputadoEstadual);

        menuCadastro.add(menuCadastroCandidato);

        menuCadastroEleitor.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroEleitor.setText("Eleitor");
        menuCadastroEleitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseEntered(evt);
            }
        });
        menuCadastroEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEleitorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroEleitor);

        menuCadastroPartido.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroPartido.setText("Partido");
        menuCadastroPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseEntered(evt);
            }
        });
        menuCadastroPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroPartidoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroPartido);

        menuBarraPrincipal.add(menuCadastro);

        menuUtilitarios.setForeground(new java.awt.Color(240, 174, 24));
        menuUtilitarios.setText("Utilitários");
        menuUtilitarios.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        menuUtilitarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuUtilitariosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuUtilitariosMouseEntered(evt);
            }
        });

        computarVotos.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        computarVotos.setText("Computar Votos");
        computarVotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                computarVotosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                computarVotosMouseEntered(evt);
            }
        });
        computarVotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computarVotosActionPerformed(evt);
            }
        });
        menuUtilitarios.add(computarVotos);

        menuBarraPrincipal.add(menuUtilitarios);

        setJMenuBar(menuBarraPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEleitorActionPerformed
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        new Eleitor(eleitorDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroEleitorActionPerformed

    private void menuCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroMouseEntered

    private void menuCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroMouseExited

    private void menuCadastroEleitorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroEleitorMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroEleitorMouseEntered

    private void menuCadastroEleitorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroEleitorMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroEleitorMouseExited

    private void menuUtilitariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUtilitariosMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuUtilitariosMouseExited

    private void computarVotosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computarVotosMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_computarVotosMouseExited

    private void menuUtilitariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUtilitariosMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuUtilitariosMouseEntered

    private void computarVotosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computarVotosMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_computarVotosMouseEntered

    private void menuCadastroPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroPartidoActionPerformed
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        new Partido(partidoDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroPartidoActionPerformed

    private void menuCadastroPartidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseEntered

    private void menuCadastroPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseExited

    private void computarVotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computarVotosActionPerformed
        criaGrafico();
    }//GEN-LAST:event_computarVotosActionPerformed

    private void menuCadastroCandidatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseEntered

    private void menuCadastroCandidatoPresidenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteMouseEntered

    private void menuCadastroCandidatoDeputadoEstadualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoEstadualMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoEstadualMouseEntered

    private void menuCadastroCandidatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseExited

    private void menuCadastroCandidatoPresidenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteMouseExited

    private void menuCadastroCandidatoDeputadoEstadualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoEstadualMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoEstadualMouseExited

    private void menuCadastroCandidatoPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteActionPerformed
        
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        /*Verifica se tem partido cadastrado*/
        try {            
            partidoDAO.existeAlgumPartido();
        } catch (PartidoException e) {            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);            
            return ;
        }
        
        new Presidente(candidatoDAO, partidoDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteActionPerformed

    private void menuCadastroCandidatoDeputadoEstadualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoEstadualActionPerformed
        
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        /*Verifica se tem partido cadastrado*/
        try {            
            partidoDAO.existeAlgumPartido();
        } catch (PartidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        new DeputadoEstadual(candidatoDAO, partidoDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoEstadualActionPerformed
    
    /**
     * Cria uma tela que mostrará o gráfico da relação de quantidade de votos que os candidatos já obtiveram.
     */
    public void criaGrafico(){
    
        /*Baixa do drive a relacao dos votos ate o momento*/
        try {
            votoDAO.baixarVotoJson();  
            urna.setVotoDAO(votoDAO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro na hora de computador os votos...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }        
        
        /*Se ninguem votou ainda e porque nao tem nada para mostrar aqui*/
        if (urna.getVotoDAO().verificaAlguemVotou()){
            
            /*Preenche o grafico com os dados dos candidatos*/
            PieDataset pizzaDataSet = urna.getVotoDAO().preencheGrafico();
            
            GraficoPizza3D grafico = new GraficoPizza3D(
                    "Apuração dos votos",
                    "Relação de candidatos",
                    pizzaDataSet
            );

            grafico.pack();
            grafico.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Ainda não ocorreu nenhum voto...", "Resultados inexistentes", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Função que inicializa o programa.
     * @param args Argumentos de linha de comando.
     */
    public static void main(String args[]) {        
        
        /*Cria o form*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem computarVotos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBarraPrincipal;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCadastroCandidato;
    private javax.swing.JMenuItem menuCadastroCandidatoDeputadoEstadual;
    private javax.swing.JMenuItem menuCadastroCandidatoPresidente;
    private javax.swing.JMenuItem menuCadastroEleitor;
    private javax.swing.JMenuItem menuCadastroPartido;
    private javax.swing.JMenu menuUtilitarios;
    // End of variables declaration//GEN-END:variables
}