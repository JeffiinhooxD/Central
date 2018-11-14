package visao;

import dao.EleitorDAO;
import excecoes.CpfException;
import java.awt.Cursor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import util.PPMFileReader;
import excecoes.CampoObrigatorioException;
import excecoes.IgualdadeDeObjetosException;
import modelo.Estado;

public class Eleitor extends javax.swing.JFrame {

    EleitorDAO eleitorDAO;    
    
    /**
     * Construtor com parâmetros da classe.
     * @param eleitorDAO O objeto dao do eleitor.
     */
    public Eleitor(EleitorDAO eleitorDAO) {
        
        this.eleitorDAO = eleitorDAO;
        
        initComponents();
        
        this.setTitle("Cadastro de Eleitor");
        this.setLocationRelativeTo(null);
        this.setExtendedState(HIDE_ON_CLOSE);
        
        /*Preenche os estados*/
        preencheBoxEstado();
        
        /*Seta o foco no nome*/
        texNomeEleitor.requestFocus();
    }
    
    /**
     * Verifica se os campos com preenchimento obrigatórios estão sendo devidamente preenchidos.
     * @throws CampoObrigatorioException - Caso algum campo não esteje preenchido.
     */
    public void camposObrigatorios() throws CampoObrigatorioException {
        
        String campo = "";
        
        if (texImagemEleitor.getText().equals(""))            campo = "IMAGEM";
        if (texTituloEleitor.getText().equals(""))            campo = "TITULO";
        if (texCpfEleitor.getText().equals("   .   .   -  ")) campo = "CPF";
        if (texNomeEleitor.getText().equals(""))              campo = "NOME";
        
        if (!campo.equals("")){
            throw new CampoObrigatorioException("O campo " + campo + " esta vazio...");
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

        btnConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        texSecaoEleitor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texNomeEleitor = new javax.swing.JTextField();
        texTituloEleitor = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        texCpfEleitor = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            texCpfEleitor = new javax.swing.JFormattedTextField(formataCpf);
        }catch(Exception e){

        }
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLocalizarImagem = new javax.swing.JButton();
        texImagemEleitor = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataCpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            texCpfEleitor = new javax.swing.JFormattedTextField(formataCpf);
        }catch(Exception e){

        }
        boxEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirmar o Cadastro");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
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

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("CPF:");

        texSecaoEleitor.setText("1");
        texSecaoEleitor.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("NOME:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("N° SEÇÃO:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel3.setText("ELEITOR");

        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Ir para a tela Principal");
        btnCancelar.setIconTextGap(3);
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

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("TíTULO ELEITOR:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("IMAGEM:");

        btnLocalizarImagem.setText("...");
        btnLocalizarImagem.setToolTipText("Clique para selecionar uma imagem");
        btnLocalizarImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLocalizarImagemMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLocalizarImagemMouseEntered(evt);
            }
        });
        btnLocalizarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarImagemActionPerformed(evt);
            }
        });

        texImagemEleitor.setEnabled(false);

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

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("ESTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 369, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(388, 388, 388))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLocalizarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texImagemEleitor))
                            .addComponent(texTituloEleitor)
                            .addComponent(texSecaoEleitor)
                            .addComponent(texNomeEleitor)
                            .addComponent(texCpfEleitor, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(texNomeEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(texCpfEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texTituloEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texSecaoEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(texImagemEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso.");
        this.dispose();
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnConfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseExited

    private void btnConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseEntered

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        try {
            
            /*Muda o mouse*/
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            /*Verificando os campos obrigatorios*/
            camposObrigatorios();

            /*Inserindo numa variavel auxiliar*/
            modelo.Eleitor eleitor = 
                    new modelo.Eleitor(texNomeEleitor.getText(),
                                       texCpfEleitor.getText(),
                                       Integer.parseInt(texSecaoEleitor.getText()),
                                       texTituloEleitor.getText(),
                                       PPMFileReader.readImage(texImagemEleitor.getText()),
                                       Estado.valueOf(boxEstado.getSelectedItem().toString()));
            
            /*Conferindo se ja nao tem um eleitor com essas informacoes*/
            eleitorDAO.igualdadeEleitor(eleitor);

            /*Se o eleitor pode ser cadastrado entao cadastra no dao, no arquivo e envia pro drive*/
            eleitorDAO.inserir(eleitor);
            if ((eleitorDAO.inserirJson(eleitor) == false) ||
                (eleitorDAO.enviaDrive()         == false)) {

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
    
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnLimparMouseExited

    private void btnLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLimparMouseEntered

    private void btnLocalizarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarImagemActionPerformed
        
        /* Criando um seletor de arquivos*/
        JFileChooser seleciona = new JFileChooser();
        
        /*Verifica se o usuario clicou no Abrir*/
        if (seleciona.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

            /* Colocando dentro da variavel arq do tipo FILE, a imagem selecionada*/
            if (seleciona.getSelectedFile().getAbsolutePath().matches(".+\\.ppm")){
             
                /*Pega o caminho do arquivo*/
                String caminho = seleciona.getSelectedFile().getAbsolutePath();
            
                /*Verifica se o caminho nao esta vindo vazio*/
                if (!caminho.equals("")){

                    /* Colocando no text o endereco da imagem selecionada*/
                    texImagemEleitor.setText(caminho);
                }
                
            }else{
                /*Selecionou um arquivo que nao tem extensao .ppm*/
                JOptionPane.showMessageDialog(this, "Você só pode selecionar arquivos .ppm", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLocalizarImagemActionPerformed

    private void btnLocalizarImagemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocalizarImagemMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLocalizarImagemMouseEntered

    private void btnLocalizarImagemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocalizarImagemMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnLocalizarImagemMouseExited

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        /*Limpando todos os campos*/
        texNomeEleitor.setText("");
        
        /*O cpf nao limpa direito (nao sabemos o porque)*/
        texCpfEleitor.setText(null);
                   
        texTituloEleitor.setText("");
        texImagemEleitor.setText("");
        boxEstado.setSelectedIndex(0);
        
        /*Passa o foco para o campo de nome*/
        texNomeEleitor.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void boxEstadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEstadoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_boxEstadoMouseExited

    private void boxEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEstadoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_boxEstadoMouseEntered



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField texCpfEleitor;
    private javax.swing.JTextField texImagemEleitor;
    private javax.swing.JTextField texNomeEleitor;
    private javax.swing.JTextField texSecaoEleitor;
    private javax.swing.JTextField texTituloEleitor;
    // End of variables declaration//GEN-END:variables
}