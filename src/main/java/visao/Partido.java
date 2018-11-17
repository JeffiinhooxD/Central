package visao;

import conexao.Conexao;
import dao.PartidoDAO;
import excecoes.CampoObrigatorioException;
import excecoes.IgualdadeDeObjetosException;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class Partido extends javax.swing.JFrame {

    PartidoDAO partidoDAO;
    
    /**
     * Construtor com parâmetros da classe.
     * @param partidoDAO O objeto dao do partido.
     */
    public Partido(PartidoDAO partidoDAO) {
        
        this.partidoDAO = partidoDAO;
        
        initComponents();
                
        this.setTitle("Cadastro de Partido");
        this.setLocationRelativeTo(null);
        this.setExtendedState(HIDE_ON_CLOSE);
        
        /*Seta o foco no nome*/
        texNomePartido.requestFocus();
    }
    
    /**
     * Verifica se os campos com preenchimento obrigatórios estão sendo devidamente preenchidos.
     * @throws CampoObrigatorioException - Caso algum campo não esteje preenchido.
     */
    public void camposObrigatorios() throws CampoObrigatorioException {
        
        String campo = "";

        if (texNumeroPartido.getText().equals("")) campo = "NUMERO";
        if (texSiglaPartido.getText().equals(""))  campo = "SIGLA";
        if (texNomePartido.getText().equals(""))   campo = "NOME";
        
        if (!campo.equals("")){
            throw new CampoObrigatorioException("O campo " + campo + " esta vazio...");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texNomePartido = new javax.swing.JTextField();
        texNumeroPartido = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter formataNumero = new javax.swing.text.MaskFormatter("##");
            texNumeroPartido = new javax.swing.JFormattedTextField(formataNumero);
        }catch(Exception e){
        }
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        texSiglaPartido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(930, 540));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("NOME:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("NUMERO:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel3.setText("PARTIDO");

        texNumeroPartido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texNumeroPartidoKeyReleased(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Ir para a tela Principal");
        btnCancelar.setIconTextGap(3);
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

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("SIGLA:");

        texSiglaPartido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texSiglaPartidoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(409, 409, 409))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(227, 227, 227)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addComponent(texNumeroPartido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texSiglaPartido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texNomePartido, javax.swing.GroupLayout.Alignment.LEADING))
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
                    .addComponent(texNomePartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(texSiglaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(texNumeroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        try {
            
            /*Muda o mouse*/
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            /*Verificando os campos obrigatorios*/
            camposObrigatorios();

            /*Inserindo numa variavel auxiliar*/
            modelo.Partido partido = 
                    new modelo.Partido(texNomePartido.getText(),
                                       texSiglaPartido.getText(),
                                       Integer.parseInt(texNumeroPartido.getText()));
            
            /*Conferindo se ja nao tem um partido com essas informacoes*/
            partidoDAO.igualdadePartido(partido);
            
            /*Se o partido pode ser cadastrado entao cadastra no dao, no arquivo e envia pro drive*/
            partidoDAO.inserir(partido);
            
            try {
                partidoDAO.inserirJson(partido);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve algum erro ao salvar o partido no arquivo json.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            /*Antes de fazer algo usando a conexao verifica primeiro se tem internet*/
            if (!Conexao.getInternet()){
                JOptionPane.showMessageDialog(this, "Sem acesso a internet.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            try {
                partidoDAO.enviaDrive();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve erro ao enviar o arquivo para o drive.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            /*Se chegou aqui o cadastro foi efetuado com sucesso*/
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

            /*Depois de cadastrar, limpa os campos*/
            btnLimparActionPerformed(evt);
            
        } catch (IgualdadeDeObjetosException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoObrigatorioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            /*Volta o cursor para seu estado normal*/
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLimparMouseEntered

    private void btnLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnLimparMouseExited

    private void btnConfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseExited

    private void btnConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnConfirmarMouseEntered

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        /*Limpando todos os campos*/
        texNomePartido.setText("");
        texNumeroPartido.setText("");
        texSiglaPartido.setText("");
        
        /*Passa o foco para o campo de nome*/
        texNomePartido.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void texSiglaPartidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texSiglaPartidoKeyReleased
        
        /*Transforma o conteudo no mesmo conteudo so que com caixa alta*/
        String aux = texSiglaPartido.getText().toUpperCase();
        texSiglaPartido.setText("");
        texSiglaPartido.setText(aux);
    }//GEN-LAST:event_texSiglaPartidoKeyReleased

    private void texNumeroPartidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texNumeroPartidoKeyReleased
        texNumeroPartido.setText(texNumeroPartido.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_texNumeroPartidoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField texNomePartido;
    private javax.swing.JTextField texNumeroPartido;
    private javax.swing.JTextField texSiglaPartido;
    // End of variables declaration//GEN-END:variables
}