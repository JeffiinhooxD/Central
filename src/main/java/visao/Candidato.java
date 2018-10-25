package visao;

import dao.CandidatoDAO;
import dao.PartidoDAO;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import modelo.CadCandidato;
import modelo.CadPartido;

public class Candidato extends javax.swing.JFrame {

    CandidatoDAO candidatoDAO;
    PartidoDAO   partidoDAO;
    
    /**
     * Construtor com parâmetros da classe.
     * @param candidatoDAO O objeto dao do candidato.
     * @param partidoDAO  O objeto dao do partido.
     */
    public Candidato(CandidatoDAO candidatoDAO, PartidoDAO partidoDAO) {
        
        this.candidatoDAO = candidatoDAO;
        this.partidoDAO   = partidoDAO;
        
        /*Verifica se tem partido cadastrado*/
        if (!(partidoDAO.existeAlgumPartido())){
            JOptionPane.showMessageDialog(null, "Você não pode cadastrar um candidato sem antes ter cadastrado um partido", "Erro", JOptionPane.ERROR_MESSAGE);            
            this.setVisible(false);
            this.dispose();
            return ;
        }
        
        initComponents();
        this.setTitle("Cadastro de Candidato");
        this.setLocationRelativeTo(null);
        this.setExtendedState(HIDE_ON_CLOSE);
        
        /*Preenche os partidos*/
        preencheBoxPartido();
        
        /*Seta o foco no nome*/
        texNomeCandidato.requestFocus();                
    }
    
    /**
     * Verifica se os campos com preenchimento obrigatórios estão sendo devidamente preenchidos.
     * @return String - O nome do campo que ainda não está preenchido.
     */
    public String camposObrigatorios(){
        
        if (texNomeCandidato.getText().equals(""))              return "NOME";
        if (texCpfCandidato.getText().equals("   .   .   -  ")) return "CPF";
        if (boxPartido.getSelectedIndex() == 0)                 return "PARTIDO";
        
        return "";
    }

    /**
     * Preenche o combo box do partido com as siglas dos partidos previamente cadastrados.
     */
    public void preencheBoxPartido(){
        
        CadPartido partidos[] = partidoDAO.getVetorPartido();
        
        for (int i = 0; i < partidos.length; i++) {
            
            /*Evita o null pointer exception*/
            if (partidos[i] != null){
                
                /*Adiciona no box as siglas*/
                boxPartido.addItem(partidos[i].getSigla());
            }            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texNomeCandidato = new javax.swing.JTextField();
        texNumeroCandidato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        texCpfCandidato = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            texCpfCandidato = new javax.swing.JFormattedTextField(formataCpf);
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
        setPreferredSize(new java.awt.Dimension(930, 540));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Candidato");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("NUMERO:");

        texNumeroCandidato.setEnabled(false);

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

        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Ir para a tela Principal");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar os campos de textos");
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparMouseEntered(evt);
            }
        });
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirmar o Cadastro");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseEntered(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texNumeroCandidato, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texNomeCandidato)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texCpfCandidato)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(256, 256, 256)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))))
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
                    .addComponent(texNomeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(texNumeroCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(texCpfCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        texNomeCandidato.setText("");
        texNumeroCandidato.setText("");
        
        /*O cpf nao limpa direito (olhar depois)*/
        texCpfCandidato.setText(null);
        boxPartido.setSelectedIndex(0);
        
        /*Passa o foco para o campo de nome*/
        texNomeCandidato.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        /*Muda o mouse*/
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        /*Verificando os campos obrigatorios*/
        String campo = camposObrigatorios();
        if (!(campo.equals(""))){
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "O campo " + campo + " esta vazio...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        /*Inserindo numa variavel auxiliar*/
        CadCandidato candidato = new CadCandidato();
        candidato.setNome(texNomeCandidato.getText());
        
        if (!(candidato.setCpf(texCpfCandidato.getText()))){
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "Cpf inválido...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        candidato.setNumero(Integer.parseInt(texNumeroCandidato.getText()));
        candidato.setPartido(partidoDAO.getPartidoBySigla(boxPartido.getSelectedItem().toString()));
        
        /*Conferindo se ja nao tem partido com essas informacoes*/
        campo = candidatoDAO.igualdadeCandidato(candidato);
        
        if (!(campo.equals(""))){
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "Há um candidato com o mesmo item do campo " + campo + "...", "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        /*Se o partido poder ser cadastrado entao cadastra no dao e no arquivo e envia pro drive*/
        if ((candidatoDAO.inserir(candidato)     == false) || 
            (candidatoDAO.inserirJson(candidato) == false) ||
            (candidatoDAO.enviaDrive()           == false)){
            
            return ;
        }
        
        /*Volta o cursor para padrao*/
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        
        /*Depois de cadastrar, limpa os campos*/
        btnLimparActionPerformed(evt);
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
        
        CadPartido p = partidoDAO.getPartidoBySigla(boxPartido.getSelectedItem().toString());
        if (p != null){
              texNumeroCandidato.setText(Integer.toString(p.getNumero()));
        }else{texNumeroCandidato.setText("");}
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
    private javax.swing.JTextField texCpfCandidato;
    private javax.swing.JTextField texNomeCandidato;
    private javax.swing.JTextField texNumeroCandidato;
    // End of variables declaration//GEN-END:variables
}