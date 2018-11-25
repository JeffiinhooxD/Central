package visao;

import conexao.Conexao;
import dao.CandidatoDAO;
import dao.PartidoDAO;
import excecoes.CampoObrigatorioException;
import excecoes.CpfException;
import excecoes.IgualdadeDeObjetosException;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Partido;

public class Presidente extends javax.swing.JFrame {

    CandidatoDAO candidatoDAO;
    PartidoDAO   partidoDAO;
    
    /**
     * Construtor com parâmetros da classe.
     * @param candidatoDAO O objeto dao do candidato.
     * @param partidoDAO O objeto dao do partido.
     */
    public Presidente(CandidatoDAO candidatoDAO, PartidoDAO partidoDAO) {
        
        this.candidatoDAO = candidatoDAO;
        this.partidoDAO   = partidoDAO;
        
        initComponents();
        this.setTitle("Cadastro de Presidente");
        this.setLocationRelativeTo(null);
        this.setExtendedState(HIDE_ON_CLOSE);
        
        /*Preenche os partidos*/
        preencheBoxPartido();
        
        /*Seta o foco no nome*/
        texNomePresidente.requestFocus();
    }
    
    /**
     * Verifica se os campos com preenchimento obrigatórios estão sendo devidamente preenchidos.
     * @throws CampoObrigatorioException - Caso algum campo não esteje preenchido.
     */
    public void camposObrigatorios() throws CampoObrigatorioException {
        
        String campo = "";

        if (boxPartido.getSelectedIndex() == 0)                  campo = "PARTIDO";
        if (texCpfPresidente.getText().equals("   .   .   -  ")) campo = "CPF";
        if (texNomePresidente.getText().equals(""))              campo = "NOME";
        
        if (!campo.equals("")){
            throw new CampoObrigatorioException("O campo " + campo + " esta vazio...");
        }
    }

    /**
     * Preenche o combo box do partido com as siglas dos partidos previamente cadastrados.
     */
    public void preencheBoxPartido() {
        
        ArrayList<Partido> partidos = (ArrayList<Partido>) partidoDAO.getVetorPartido();
        
        for (Partido p : partidos) {
            
            /*Evita o null pointer exception*/
            if (p != null){
                
                /*Adiciona no box as siglas*/
                boxPartido.addItem(p.getSigla());
            }            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texNomePresidente = new javax.swing.JTextField();
        texNumeroPresidente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        texCpfPresidente = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            texCpfPresidente = new javax.swing.JFormattedTextField(formataCpf);
        }catch(Exception e){

        }
        jLabel5 = new javax.swing.JLabel();
        boxPartido = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Presidente");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("NUMERO:");

        texNumeroPresidente.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("PARTIDO:");

        boxPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        boxPartido.setToolTipText("Selecione de acordo com a sigla do partido");
        boxPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxPartidoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxPartidoMouseEntered(evt);
            }
        });
        boxPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPartidoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Ir para a tela Principal");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLimpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar os campos de textos");
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparMouseExited(evt);
            }
        });
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconConfirma.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirmar o Cadastro");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseExited(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel1)
                .addContainerGap(374, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texNumeroPresidente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texNomePresidente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texCpfPresidente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(227, 227, 227)
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirmar)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(texNomePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(texNumeroPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(texCpfPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(boxPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        /*Limpando todos os campos*/
        texNomePresidente.setText("");
        texNumeroPresidente.setText("");
        
        /*O cpf nao limpa direito (olhar depois)*/
        texCpfPresidente.setText(null);
        boxPartido.setSelectedIndex(0);
        
        /*Passa o foco para o campo de nome*/
        texNomePresidente.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        try {
            
            /*Muda o mouse*/
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            /*Verificando os campos obrigatorios*/
            camposObrigatorios();

            /*Inserindo numa variavel auxiliar*/
            modelo.Presidente presidente = 
                    new modelo.Presidente(texNomePresidente.getText(),
                                          texCpfPresidente.getText(),
                                          Integer.parseInt(texNumeroPresidente.getText()),
                                          partidoDAO.getPartidoBySigla(boxPartido.getSelectedItem().toString()));
            
            /*Conferindo se ja nao tem um presidente com essas informacoes*/
            candidatoDAO.igualdadeCandidato(presidente);

            /*Se o presidente pode ser cadastrado entao cadastra no dao, no arquivo e envia pro drive*/
            candidatoDAO.inserir(presidente);
            
            try {
                candidatoDAO.inserirJson(presidente);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve algum erro ao salvar o presidente no arquivo json.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            /*Antes de fazer algo usando a conexao verifica primeiro se tem internet*/
            if (!Conexao.getInternet()){
                JOptionPane.showMessageDialog(this, "Sem acesso a internet.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            try {
                candidatoDAO.enviaDrive();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve erro ao enviar o arquivo para o drive.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            /*Se chegou aqui o cadastro foi efetuado com sucesso*/
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

            /*Depois de cadastrar, limpa os campos*/
            btnLimparActionPerformed(evt);
            
        } catch (IgualdadeDeObjetosException | CpfException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoObrigatorioException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally{
            /*Volta o cursor para seu estado normal*/
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLimparMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnLimparMouseExited

    private void btnConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseEntered

    private void btnConfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseExited

    private void boxPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPartidoActionPerformed
        
        /*O numero do presidente tem que ser o mesmo numero do seu partido*/
        Partido p = partidoDAO.getPartidoBySigla(boxPartido.getSelectedItem().toString());
        if (p != null){
              texNumeroPresidente.setText(Integer.toString(p.getNumero()));
        }else{texNumeroPresidente.setText("");}
    }//GEN-LAST:event_boxPartidoActionPerformed

    private void boxPartidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxPartidoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_boxPartidoMouseEntered

    private void boxPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxPartidoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_boxPartidoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxPartido;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField texCpfPresidente;
    private javax.swing.JTextField texNomePresidente;
    private javax.swing.JTextField texNumeroPresidente;
    // End of variables declaration//GEN-END:variables
}