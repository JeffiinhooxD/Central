package visao;

import conexao.Conexao;
import dao.CandidatoDAO;
import dao.PartidoDAO;
import excecoes.CpfException;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import modelo.Estado;
import modelo.Partido;
import excecoes.CampoObrigatorioException;
import excecoes.IgualdadeDeObjetosException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeputadoEstadual extends javax.swing.JFrame {

    CandidatoDAO candidatoDAO;
    PartidoDAO   partidoDAO;
    
    public DeputadoEstadual(CandidatoDAO candidatoDAO, PartidoDAO partidoDAO) {
        
        this.candidatoDAO = candidatoDAO;
        this.partidoDAO   = partidoDAO;
        
        initComponents();
        this.setTitle("Cadastro de Deputado Federal");
        this.setLocationRelativeTo(null);
        this.setExtendedState(HIDE_ON_CLOSE);
        
        /*Preenche os partidos*/
        preencheBoxPartido();
        
        /*Preenche os estados*/
        preencheBoxEstado();
        
        /*Seta o foco no nome*/
        texNomeDeputadoEstadual.requestFocus();
    }
    
    /**
     * Verifica se os campos com preenchimento obrigatórios estão sendo devidamente preenchidos.
     * @throws CampoObrigatorioException - Caso algum campo não esteje preenchido.
     */
    public void camposObrigatorios() throws CampoObrigatorioException {
        
        String campo = "";
        
        if (boxEstado.getSelectedIndex() == 0)                         campo = "ESTADO";
        if (boxPartido.getSelectedIndex() == 0)                        campo = "PARTIDO";
        if (texCpfDeputadoEstadual.getText().equals("   .   .   -  ")) campo = "CPF";
        if (texNumeroDeputadoEstadual.getText().equals("     "))       campo = "NUMERO";
        if (texNomeDeputadoEstadual.getText().equals(""))              campo = "NOME";
        
        if (!campo.equals("")){
            throw new CampoObrigatorioException("O campo " + campo + " esta vazio...");
        }
    }
    
    /**
     * Preenche o combo box do partido com as siglas dos partidos previamente cadastrados.
     */
    public void preencheBoxPartido(){
        
        ArrayList<Partido> partidos = partidoDAO.getVetorPartido();
        
        for (Partido p : partidos) {
            
            /*Evita o null pointer exception*/
            if (p != null){
                
                /*Adiciona no box as siglas*/
                boxPartido.addItem(p.getSigla());
            }            
        }
    }
    
    /**
     * Preenche o combo box do estado com as siglas dos estados.
     */
    public void preencheBoxEstado(){
        
        for (Estado e : Estado.values()) {
                
            /*Adiciona no box as siglas*/
            boxEstado.addItem(e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texNomeDeputadoEstadual = new javax.swing.JTextField();
        texNumeroDeputadoEstadual = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataNumero = new javax.swing.text.MaskFormatter("#####");
            texNumeroDeputadoEstadual = new javax.swing.JFormattedTextField(formataNumero);
        }catch(Exception e){
        }
        jLabel4 = new javax.swing.JLabel();
        texCpfDeputadoEstadual = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            texCpfDeputadoEstadual = new javax.swing.JFormattedTextField(formataCpf);
        }catch(Exception e){

        }
        jLabel5 = new javax.swing.JLabel();
        boxPartido = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        boxEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Deputado Estadual");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("NUMERO:");

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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCancelar.png"))); // NOI18N
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

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLimpar.png"))); // NOI18N
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

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        boxEstado.setToolTipText("Selecione de acordo com a sigla do partido");
        boxEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxEstadoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxEstadoMouseEntered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("ESTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(texNumeroDeputadoEstadual, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texNomeDeputadoEstadual)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texCpfDeputadoEstadual)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(222, 222, 222)
                                        .addComponent(btnLimpar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnConfirmar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boxPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(853, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(texNomeDeputadoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(texNumeroDeputadoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(texCpfDeputadoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(boxPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
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
        texNomeDeputadoEstadual.setText("");
        texNumeroDeputadoEstadual.setText("");
        
        /*O cpf nao limpa direito (olhar depois)*/
        texCpfDeputadoEstadual.setText(null);
        boxPartido.setSelectedIndex(0);
        boxEstado.setSelectedIndex(0);
        
        /*Passa o foco para o campo de nome*/
        texNomeDeputadoEstadual.requestFocus();
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
            modelo.DeputadoEstadual deputadoEstadual = 
                    new modelo.DeputadoEstadual(texNomeDeputadoEstadual.getText(),
                                                texCpfDeputadoEstadual.getText(),
                                                Integer.parseInt(texNumeroDeputadoEstadual.getText()),
                                                partidoDAO.getPartidoBySigla(boxPartido.getSelectedItem().toString()),
                                                Estado.valueOf(boxEstado.getSelectedItem().toString()));
            
            /*Conferindo se ja nao tem um deputado com essas informacoes*/
            candidatoDAO.igualdadeCandidato(deputadoEstadual);
            
            /*Se o deputado estadual pode ser cadastrado entao cadastra no dao, no arquivo e envia pro drive*/
            candidatoDAO.inserir(deputadoEstadual);
            
            try {
                candidatoDAO.inserirJson(deputadoEstadual);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve algum erro ao salvar o deputado estadual no arquivo json.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        } catch (CampoObrigatorioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
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

    private void boxPartidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxPartidoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_boxPartidoMouseEntered

    private void boxPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxPartidoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_boxPartidoMouseExited

    private void boxEstadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEstadoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_boxEstadoMouseExited

    private void boxEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEstadoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_boxEstadoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxPartido;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField texCpfDeputadoEstadual;
    private javax.swing.JTextField texNomeDeputadoEstadual;
    private javax.swing.JTextField texNumeroDeputadoEstadual;
    // End of variables declaration//GEN-END:variables
}