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
import java.security.GeneralSecurityException;
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
    String       mensagem     = "";
    
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

        /*Antes de fazer algo usando a conexao verifica primeiro se tem internet*/
        if (!Conexao.getInternet()){
            JOptionPane.showMessageDialog(this, "Sem acesso a internet.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        /*Iniciando o servico do drive*/
        try {
            Conexao.service();
        } catch (GeneralSecurityException ex) {
            JOptionPane.showMessageDialog(this, "Houve algum erro de segurança ao tentar conectar no drive.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Houve algum erro de entrada e saída.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Credenciais não encontradas.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        /*Baixa os arquivos .json do drive e coloca na pasta ArquivosJson, sao usadas Threads para ficar mais rapido o processo*/
        Thread p = new Thread(){
            @Override
            public void run() {
                try {
                    partidoDAO.baixarPartidoJson();
                }catch(Exception e) {
                    mensagem = "Houve um erro ao baixar os partidos do drive.";
                }
            }            
        };

        Thread e = new Thread(){
            @Override
            public void run() {
                try {
                    eleitorDAO.baixarEleitorJson();
                }catch(Exception e) {
                    mensagem = "Houve um erro ao baixar os eleitores do drive.";
                }
            }            
        };

        Thread c = new Thread(){
            @Override
            public void run() {
                try {
                    candidatoDAO.baixarCandidatoJson();
                }catch(Exception e) {
                    mensagem = "Houve um erro ao baixar os candidatos do drive.";
                }
            }            
        };
        
        /*Inicia a execucao das threads*/
        p.start();
        e.start();
        c.start();
        
        /*Espera cada Thread ser finalizada para prosseguir*/
        try {
            
            p.join();
            p.interrupt();
            e.join();
            e.interrupt();
            c.join();
            c.interrupt();
            
            if (!mensagem.equals("")){
                JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "Houve algum erro ao baixar os arquivos .json do drive.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
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
        menuCadastroCandidatoDeputadoFederal = new javax.swing.JMenuItem();
        menuCadastroEleitor = new javax.swing.JMenuItem();
        menuCadastroPartido = new javax.swing.JMenuItem();
        menuUtilitarios = new javax.swing.JMenu();
        menuComputarVoto = new javax.swing.JMenu();
        menuComputarVotoPresidente = new javax.swing.JMenuItem();
        menuComputarVotoDeputadoFederal = new javax.swing.JMenuItem();

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
        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCadastro.png"))); // NOI18N
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

        menuCadastroCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCandidato.png"))); // NOI18N
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
        menuCadastroCandidatoPresidente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconPresidente.png"))); // NOI18N
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

        menuCadastroCandidatoDeputadoFederal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        menuCadastroCandidatoDeputadoFederal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconDeputado.png"))); // NOI18N
        menuCadastroCandidatoDeputadoFederal.setText("Deputado Federal");
        menuCadastroCandidatoDeputadoFederal.setActionCommand("Deputado Federal");
        menuCadastroCandidatoDeputadoFederal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoDeputadoFederalMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoDeputadoFederalMouseEntered(evt);
            }
        });
        menuCadastroCandidatoDeputadoFederal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCandidatoDeputadoFederalActionPerformed(evt);
            }
        });
        menuCadastroCandidato.add(menuCadastroCandidatoDeputadoFederal);

        menuCadastro.add(menuCadastroCandidato);

        menuCadastroEleitor.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroEleitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconEleitor.png"))); // NOI18N
        menuCadastroEleitor.setText("Eleitor");
        menuCadastroEleitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseExited(evt);
            }
        });
        menuCadastroEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEleitorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroEleitor);

        menuCadastroPartido.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconPartido.png"))); // NOI18N
        menuCadastroPartido.setText("Partido");
        menuCadastroPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseExited(evt);
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
        menuUtilitarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconUtil.png"))); // NOI18N
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

        menuComputarVoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconGrafico.png"))); // NOI18N
        menuComputarVoto.setText("Computar Votos");
        menuComputarVoto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuComputarVoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuComputarVotoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuComputarVotoMouseEntered(evt);
            }
        });

        menuComputarVotoPresidente.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        menuComputarVotoPresidente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconPresidente.png"))); // NOI18N
        menuComputarVotoPresidente.setText("Presidente");
        menuComputarVotoPresidente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuComputarVotoPresidenteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuComputarVotoPresidenteMouseEntered(evt);
            }
        });
        menuComputarVotoPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComputarVotoPresidenteActionPerformed(evt);
            }
        });
        menuComputarVoto.add(menuComputarVotoPresidente);

        menuComputarVotoDeputadoFederal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        menuComputarVotoDeputadoFederal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconDeputado.png"))); // NOI18N
        menuComputarVotoDeputadoFederal.setText("Deputado Federal");
        menuComputarVotoDeputadoFederal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuComputarVotoDeputadoFederalMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuComputarVotoDeputadoFederalMouseEntered(evt);
            }
        });
        menuComputarVotoDeputadoFederal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComputarVotoDeputadoFederalActionPerformed(evt);
            }
        });
        menuComputarVoto.add(menuComputarVotoDeputadoFederal);

        menuUtilitarios.add(menuComputarVoto);

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEleitorActionPerformed
        
        /*Abre a tela de cadastro do eleitor*/
        try {
            new Eleitor(eleitorDAO).setVisible(true);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
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

    private void menuUtilitariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUtilitariosMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuUtilitariosMouseEntered

    private void menuCadastroPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroPartidoActionPerformed
        
        /*Abre a tela de cadastro do partido*/
        try {
            new Partido(partidoDAO).setVisible(true);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_menuCadastroPartidoActionPerformed

    private void menuCadastroPartidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseEntered

    private void menuCadastroPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseExited

    private void menuCadastroCandidatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseEntered

    private void menuCadastroCandidatoPresidenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteMouseEntered

    private void menuCadastroCandidatoDeputadoFederalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoFederalMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoFederalMouseEntered

    private void menuCadastroCandidatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseExited

    private void menuCadastroCandidatoPresidenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteMouseExited

    private void menuCadastroCandidatoDeputadoFederalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoFederalMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoFederalMouseExited

    private void menuCadastroCandidatoPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoPresidenteActionPerformed
        
        /*Abre a tela de cadastro do presidente*/
        try {
        
            /*Verifica se tem partido cadastrado*/
            try {            
                partidoDAO.existeAlgumPartido();
            } catch (PartidoException e) {            
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);            
                return ;
            }

            new Presidente(candidatoDAO, partidoDAO).setVisible(true);
            
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_menuCadastroCandidatoPresidenteActionPerformed

    private void menuCadastroCandidatoDeputadoFederalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoDeputadoFederalActionPerformed
        
        /*Abre a tela de cadastro do deputado federal*/
        try {
        
            /*Verifica se tem partido cadastrado*/
            try {            
                partidoDAO.existeAlgumPartido();
            } catch (PartidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            new DeputadoFederal(candidatoDAO, partidoDAO).setVisible(true);
        
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_menuCadastroCandidatoDeputadoFederalActionPerformed

    private void menuComputarVotoPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComputarVotoPresidenteActionPerformed
        criaGraficoPresidente();
    }//GEN-LAST:event_menuComputarVotoPresidenteActionPerformed

    private void menuComputarVotoDeputadoFederalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComputarVotoDeputadoFederalActionPerformed

        boolean entrou = false;
        String aux = null;
        
        try {
                        
            aux = JOptionPane.showInputDialog("Informe a uf do estado válida (Ex: Minas Gerais -> MG): ");
            
            /*Se estiver nulo o usuario nao inseriu nenhuma informacao*/
            if (aux != null) {
                
                /*A sigla tem no minimo e maximo 2 caracteres*/
                if (aux.length() == 2) {

                    Estado estados[] = Estado.values();                    
                    for (Estado e : estados) {
                        
                        /*Verifica em todos o uf se o uf inserido existe*/
                        if (e.equals(Estado.valueOf(aux.toUpperCase()))) {
                            entrou = true;
                            
                            /*Se o uf existe entao entra na funcao para criar o grafico*/
                            criaGraficoDeputadoFederal(Estado.valueOf(aux.toUpperCase()));
                            return;
                        }
                    }
                }
            }else{return;}

        /*Se o uf inserido nao existir ira dar esse runtime exception que nao precisa ser tratado*/
        } catch (IllegalArgumentException ex) {return ;}
        
        /*Se esta variavel estiver nula quer dizer que o uf inserido nao existe*/
        if (!entrou)
            JOptionPane.showMessageDialog(this, "Não existe este estado..", "Atenção", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_menuComputarVotoDeputadoFederalActionPerformed

    private void menuComputarVotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuComputarVotoMouseEntered

    private void menuComputarVotoPresidenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoPresidenteMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuComputarVotoPresidenteMouseEntered

    private void menuComputarVotoDeputadoFederalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoDeputadoFederalMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuComputarVotoDeputadoFederalMouseEntered

    private void menuComputarVotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuComputarVotoMouseExited

    private void menuComputarVotoPresidenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoPresidenteMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuComputarVotoPresidenteMouseExited

    private void menuComputarVotoDeputadoFederalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuComputarVotoDeputadoFederalMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuComputarVotoDeputadoFederalMouseExited
    
    /**
     * Cria uma tela que mostrará o gráfico da relação de quantidade de votos que os presidentes já obtiveram.
     */
    public void criaGraficoPresidente() {

        /*Antes de fazer algo usando a conexao verifica primeiro se tem internet*/
        if (!Conexao.getInternet()){
            JOptionPane.showMessageDialog(this, "Sem acesso a internet.", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        /*Baixa do drive a relacao dos votos ate o momento*/
        try {
            votoDAO.baixarVotoJson();  
            urna.setVotoDAO(votoDAO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Houve um erro na hora de computador os votos...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }        

        /*Se ninguem votou ainda e porque nao tem nada para mostrar aqui*/
        if (urna.getVotoDAO().verificaAlguemVotouPresidente()) {

            /*Preenche o grafico com os dados dos candidatos*/
            PieDataset pizzaDataSet = urna.getVotoDAO().preencheGraficoPresidente();

            GraficoPizza3D grafico = new GraficoPizza3D(
                    "Apuração dos votos",
                    "Relação de candidatos a presidência",
                    pizzaDataSet
            );

            grafico.pack();
            grafico.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(this, "Ainda não ocorreu nenhum voto a presidência...", "Resultados inexistentes", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Cria uma tela que mostrará o gráfico da relação de quantidade de votos que os deputados federais já obtiveram.
     */
    public void criaGraficoDeputadoFederal(Estado estado) {

        /*Antes de fazer algo usando a conexao verifica primeiro se tem internet*/
        if (!Conexao.getInternet()){
            JOptionPane.showMessageDialog(this, "Sem acesso a internet.", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        /*Baixa do drive a relacao dos votos ate o momento*/
        try {
            votoDAO.baixarVotoJson();  
            urna.setVotoDAO(votoDAO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Houve um erro na hora de computador os votos...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        /*Se ninguem votou ainda e porque nao tem nada para mostrar aqui*/
        if (urna.getVotoDAO().verificaAlguemVotouDeputadoFederal(estado)) {

            /*Preenche o grafico com os dados dos candidatos*/
            PieDataset pizzaDataSet = urna.getVotoDAO().preencheGraficoDeputadoFederal();

            GraficoPizza3D grafico = new GraficoPizza3D(
                    "Apuração dos votos",
                    "Relação de deputados federais votados em [" + estado + "]",
                    pizzaDataSet
            );

            grafico.pack();
            grafico.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(this, "Não houve votos em deputados federais do estado de [" + estado + "].", "Resultados inexistentes", JOptionPane.WARNING_MESSAGE);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBarraPrincipal;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCadastroCandidato;
    private javax.swing.JMenuItem menuCadastroCandidatoDeputadoFederal;
    private javax.swing.JMenuItem menuCadastroCandidatoPresidente;
    private javax.swing.JMenuItem menuCadastroEleitor;
    private javax.swing.JMenuItem menuCadastroPartido;
    private javax.swing.JMenu menuComputarVoto;
    private javax.swing.JMenuItem menuComputarVotoDeputadoFederal;
    private javax.swing.JMenuItem menuComputarVotoPresidente;
    private javax.swing.JMenu menuUtilitarios;
    // End of variables declaration//GEN-END:variables
}