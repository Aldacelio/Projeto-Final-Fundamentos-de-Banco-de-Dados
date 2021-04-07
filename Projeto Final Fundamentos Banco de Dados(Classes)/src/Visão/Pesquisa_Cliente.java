/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visão;

import Controle.Modulo_Conexão;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aldac
 */
public class Pesquisa_Cliente extends javax.swing.JFrame {
    Connection conexao = null; //Variavel de conexao 
    PreparedStatement pst = null; //Variavel de execução das sql
    ResultSet rs = null; //Variavel para exibir resultados
    
    public void pesquisa(){
        String sql_buscandoDados_cliente = "Select * from clientes where cpf=?";
        
        try {
                pst = conexao.prepareStatement(sql_buscandoDados_cliente);
                pst.setString(1,JT_cpf.getText());
                rs = pst.executeQuery();
                if(rs.next()){
                JT_id.setText(rs.getString(1));
                JT_cpf.setText(rs.getString(2));
                JT_nome.setText(rs.getString(3));
                JT_idade.setText(rs.getString(4));
                JT_endereco.setText(rs.getString(5));
                JT_bairro.setText(rs.getString(6));
                rs = pst.executeQuery();//executando a query
                rs.next();//positivando a execução da query
                JB_editar.setEnabled(true);
                JB_excluir.setEnabled(true);
                JT_nome.enable();
                JT_idade.enable();
                JT_endereco.enable();
                JT_bairro.enable();
                }else{
                    JOptionPane.showMessageDialog(null, "Cliente não cadastrado ou CPF incorreto");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void editar(){
        String sql_editar_cliente = "update clientes set cpf=?,nome=?,idade=?,endereco=?,bairro=?";
        
        try {
            pst = conexao.prepareStatement(sql_editar_cliente);
            pst.setString(1, JT_cpf.getText());
            pst.setString(2, JT_nome.getText());
            pst.setString(3, JT_idade.getText());
            pst.setString(4, JT_endereco.getText());
            pst.setString(5, JT_bairro.getText());
            pst.executeUpdate();//executando a query
            JT_id.setText("");
            JT_cpf.setText("");
            JT_nome.setText("");
            JT_idade.setText("");
            JT_endereco.setText("");
            JT_bairro.setText("");
            JB_editar.setEnabled(false);
            JB_excluir.setEnabled(false);
            JT_nome.disable();
            JT_idade.disable();
            JT_endereco.disable();
            JT_bairro.disable();
            JOptionPane.showMessageDialog(null,"Cadastro editado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Consulte o suporte e forneça a informação que ocorreu erro no try/catch de lembre-se de mim erro encontrado foi : "+e);
        }
        
    }
    
    public void excluir(){
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente ?");
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql_excluir_cliente = "delete from clientes where cpf=?";
            
            
            try {
                pst = conexao.prepareStatement(sql_excluir_cliente);
                pst.setString(1, JT_cpf.getText());
                pst.executeUpdate();//executando a query
                JT_id.setText("");
                JT_cpf.setText("");
                JT_nome.setText("");
                JT_idade.setText("");
                JT_endereco.setText("");
                JT_bairro.setText("");
                JB_editar.setEnabled(false);
                JB_excluir.setEnabled(false);
                JT_nome.disable();
                JT_idade.disable();
                JT_endereco.disable();
                JT_bairro.disable();
                JOptionPane.showMessageDialog(null,"Cadastro ecluido com sucesso com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Consulte o suporte e forneça a informação que ocorreu erro no try/catch de lembre-se de mim erro encontrado foi : "+e);
        }
            
        }
        
    }
    private void setIcon(){
            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/icon.png")));
        
    }
    /**
     * Creates new form Pesquisa_Cliente_Gestor
     */
    public Pesquisa_Cliente() {
        initComponents();
        conexao = Modulo_Conexão.conector();
        JT_cpf.setDocument(new TeclasPermitidas());
        setIcon();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JT_id = new javax.swing.JTextField();
        JL_id = new javax.swing.JLabel();
        JL_cpf = new javax.swing.JLabel();
        JT_cpf = new javax.swing.JTextField();
        JL_nome = new javax.swing.JLabel();
        JT_nome = new javax.swing.JTextField();
        JT_idade = new javax.swing.JTextField();
        JL_idade = new javax.swing.JLabel();
        JL_endereco = new javax.swing.JLabel();
        JT_endereco = new javax.swing.JTextField();
        JL_bairro = new javax.swing.JLabel();
        JT_bairro = new javax.swing.JTextField();
        JB_excluir = new javax.swing.JButton();
        JB_editar = new javax.swing.JButton();
        JB_pesquisa = new javax.swing.JButton();
        JB_cadastrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Aluguel = new javax.swing.JMenu();
        Realizar_Aluguel = new javax.swing.JMenuItem();
        Realizar_Devolução = new javax.swing.JMenuItem();
        Menu_Livro = new javax.swing.JMenu();
        Cadastrar_Livro = new javax.swing.JMenuItem();
        Pesquisar_Livro = new javax.swing.JMenuItem();
        Editar_Livro = new javax.swing.JMenuItem();
        Excluir_Livro = new javax.swing.JMenuItem();
        Menu_Cliente = new javax.swing.JMenu();
        Cadastrar_Cliente = new javax.swing.JMenuItem();
        Pesquisar_Cliente = new javax.swing.JMenuItem();
        Editar_Cliente = new javax.swing.JMenuItem();
        Excluir_Cliente = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 290));
        setMinimumSize(new java.awt.Dimension(600, 290));
        setPreferredSize(new java.awt.Dimension(600, 290));
        setResizable(false);
        getContentPane().setLayout(null);

        JT_id.setEnabled(false);
        getContentPane().add(JT_id);
        JT_id.setBounds(70, 20, 60, 30);

        JL_id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_id.setForeground(new java.awt.Color(255, 255, 255));
        JL_id.setText("id:");
        getContentPane().add(JL_id);
        JL_id.setBounds(50, 20, 30, 30);

        JL_cpf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_cpf.setForeground(new java.awt.Color(255, 255, 255));
        JL_cpf.setText("Cpf:");
        getContentPane().add(JL_cpf);
        JL_cpf.setBounds(140, 20, 50, 30);
        getContentPane().add(JT_cpf);
        JT_cpf.setBounds(170, 20, 250, 30);

        JL_nome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_nome.setForeground(new java.awt.Color(255, 255, 255));
        JL_nome.setText("Nome:");
        getContentPane().add(JL_nome);
        JL_nome.setBounds(50, 70, 40, 14);

        JT_nome.setEnabled(false);
        getContentPane().add(JT_nome);
        JT_nome.setBounds(90, 60, 450, 30);

        JT_idade.setEnabled(false);
        getContentPane().add(JT_idade);
        JT_idade.setBounds(470, 20, 70, 30);

        JL_idade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_idade.setForeground(new java.awt.Color(255, 255, 255));
        JL_idade.setText("Idade:");
        getContentPane().add(JL_idade);
        JL_idade.setBounds(430, 20, 50, 30);

        JL_endereco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_endereco.setForeground(new java.awt.Color(255, 255, 255));
        JL_endereco.setText("Endereço: ");
        getContentPane().add(JL_endereco);
        JL_endereco.setBounds(50, 110, 60, 14);

        JT_endereco.setEnabled(false);
        getContentPane().add(JT_endereco);
        JT_endereco.setBounds(110, 100, 250, 30);

        JL_bairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JL_bairro.setForeground(new java.awt.Color(255, 255, 255));
        JL_bairro.setText("Bairro:");
        getContentPane().add(JL_bairro);
        JL_bairro.setBounds(370, 100, 60, 30);

        JT_bairro.setEnabled(false);
        getContentPane().add(JT_bairro);
        JT_bairro.setBounds(410, 100, 130, 30);

        JB_excluir.setBackground(new java.awt.Color(0, 0, 0));
        JB_excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_excluir.setForeground(new java.awt.Color(255, 255, 255));
        JB_excluir.setText("Excluir");
        JB_excluir.setEnabled(false);
        JB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_excluirActionPerformed(evt);
            }
        });
        getContentPane().add(JB_excluir);
        JB_excluir.setBounds(460, 160, 80, 40);

        JB_editar.setBackground(new java.awt.Color(0, 0, 0));
        JB_editar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_editar.setForeground(new java.awt.Color(255, 255, 255));
        JB_editar.setText("Editar");
        JB_editar.setEnabled(false);
        JB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_editarActionPerformed(evt);
            }
        });
        getContentPane().add(JB_editar);
        JB_editar.setBounds(340, 160, 70, 40);

        JB_pesquisa.setBackground(new java.awt.Color(0, 0, 0));
        JB_pesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        JB_pesquisa.setText("Pesquisar");
        JB_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_pesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(JB_pesquisa);
        JB_pesquisa.setBounds(190, 160, 100, 40);

        JB_cadastrar.setBackground(new java.awt.Color(0, 0, 0));
        JB_cadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        JB_cadastrar.setText("Cadastrar");
        JB_cadastrar.setEnabled(false);
        getContentPane().add(JB_cadastrar);
        JB_cadastrar.setBounds(50, 160, 90, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundinho.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-10, 0, 630, 310);

        Aluguel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minuta2-saberimobiliario.png"))); // NOI18N
        Aluguel.setText("Aluguel");

        Realizar_Aluguel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home_icons_contract.png"))); // NOI18N
        Realizar_Aluguel.setText("Realizar Aluguel");
        Realizar_Aluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Realizar_AluguelActionPerformed(evt);
            }
        });
        Aluguel.add(Realizar_Aluguel);

        Realizar_Devolução.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/a-icon-04.png"))); // NOI18N
        Realizar_Devolução.setText("Realizar Devolução");
        Realizar_Devolução.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Realizar_DevoluçãoActionPerformed(evt);
            }
        });
        Aluguel.add(Realizar_Devolução);

        jMenuBar1.add(Aluguel);

        Menu_Livro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Livro.png"))); // NOI18N
        Menu_Livro.setText("Livros");

        Cadastrar_Livro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ec41c9bd80d6e07d3dfe3097fabac99d-abra-o-livro-aberto.png"))); // NOI18N
        Cadastrar_Livro.setText("Cadastrar Livro");
        Cadastrar_Livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar_LivroActionPerformed(evt);
            }
        });
        Menu_Livro.add(Cadastrar_Livro);

        Pesquisar_Livro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/71646d7673e8847ab07b3b7e78928777-icone-do-circulo-de-pesquisa.png"))); // NOI18N
        Pesquisar_Livro.setText("Pesquisar Livro");
        Pesquisar_Livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pesquisar_LivroActionPerformed(evt);
            }
        });
        Menu_Livro.add(Pesquisar_Livro);

        Editar_Livro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2186768.png"))); // NOI18N
        Editar_Livro.setText("Editar Livro");
        Editar_Livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_LivroActionPerformed(evt);
            }
        });
        Menu_Livro.add(Editar_Livro);

        Excluir_Livro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/4135100.png"))); // NOI18N
        Excluir_Livro.setText("Excluir Livro");
        Excluir_Livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir_LivroActionPerformed(evt);
            }
        });
        Menu_Livro.add(Excluir_Livro);

        jMenuBar1.add(Menu_Livro);

        Menu_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user-male.png"))); // NOI18N
        Menu_Cliente.setText("Clientes");
        Menu_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_ClienteMouseClicked(evt);
            }
        });
        Menu_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ClienteActionPerformed(evt);
            }
        });

        Cadastrar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/unnamed.png"))); // NOI18N
        Cadastrar_Cliente.setText("Cadastrar cliente");
        Cadastrar_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cadastrar_ClienteMouseClicked(evt);
            }
        });
        Cadastrar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar_ClienteActionPerformed(evt);
            }
        });
        Menu_Cliente.add(Cadastrar_Cliente);

        Pesquisar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/71646d7673e8847ab07b3b7e78928777-icone-do-circulo-de-pesquisa.png"))); // NOI18N
        Pesquisar_Cliente.setText("Pesquisar cliente");
        Pesquisar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pesquisar_ClienteActionPerformed(evt);
            }
        });
        Menu_Cliente.add(Pesquisar_Cliente);

        Editar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Users-Edit-User-icon.png"))); // NOI18N
        Editar_Cliente.setText("Editar cliente");
        Editar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_ClienteActionPerformed(evt);
            }
        });
        Menu_Cliente.add(Editar_Cliente);

        Excluir_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/000000010.png"))); // NOI18N
        Excluir_Cliente.setText("Excluir cliente");
        Excluir_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir_ClienteActionPerformed(evt);
            }
        });
        Menu_Cliente.add(Excluir_Cliente);

        jMenuBar1.add(Menu_Cliente);

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/close+door+exit+out+signout+icon-1320191203404268178.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(Logout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_pesquisaActionPerformed
        // TODO add your handling code here:
        pesquisa();
    }//GEN-LAST:event_JB_pesquisaActionPerformed

    private void JB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_editarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_JB_editarActionPerformed

    private void JB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_excluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_JB_excluirActionPerformed

    private void Realizar_AluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Realizar_AluguelActionPerformed
        // TODO add your handling code here:
        Cadastro_Aluguel e = new Cadastro_Aluguel();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Realizar_AluguelActionPerformed

    private void Realizar_DevoluçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Realizar_DevoluçãoActionPerformed
        // TODO add your handling code here:
        Devolucao e = new Devolucao();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Realizar_DevoluçãoActionPerformed

    private void Cadastrar_LivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_LivroActionPerformed
        // TODO add your handling code here:
        Cadastro_Livro e = new Cadastro_Livro();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Cadastrar_LivroActionPerformed

    private void Pesquisar_LivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pesquisar_LivroActionPerformed
        // TODO add your handling code here:
        Pesquisa_Livro e = new Pesquisa_Livro();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Pesquisar_LivroActionPerformed

    private void Editar_LivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_LivroActionPerformed
        // TODO add your handling code here:
        Pesquisa_Livro e = new Pesquisa_Livro();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Editar_LivroActionPerformed

    private void Excluir_LivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir_LivroActionPerformed
        // TODO add your handling code here:
        Pesquisa_Livro e = new Pesquisa_Livro();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Excluir_LivroActionPerformed

    private void Cadastrar_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cadastrar_ClienteMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Cadastrar_ClienteMouseClicked

    private void Cadastrar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_ClienteActionPerformed
        // TODO add your handling code here:
        Cadastro_Cliente e = new Cadastro_Cliente();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Cadastrar_ClienteActionPerformed

    private void Pesquisar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pesquisar_ClienteActionPerformed
        // TODO add your handling code here:
        Pesquisa_Cliente e = new Pesquisa_Cliente();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Pesquisar_ClienteActionPerformed

    private void Editar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_ClienteActionPerformed
        // TODO add your handling code here:
        Pesquisa_Cliente e = new Pesquisa_Cliente();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Editar_ClienteActionPerformed

    private void Excluir_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir_ClienteActionPerformed
        // TODO add your handling code here:
        Pesquisa_Cliente e = new Pesquisa_Cliente();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Excluir_ClienteActionPerformed

    private void Menu_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_ClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu_ClienteMouseClicked

    private void Menu_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ClienteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Menu_ClienteActionPerformed

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        Login e = new Login();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogoutMouseClicked

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_LogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aluguel;
    private javax.swing.JMenuItem Cadastrar_Cliente;
    private javax.swing.JMenuItem Cadastrar_Livro;
    private javax.swing.JMenuItem Editar_Cliente;
    private javax.swing.JMenuItem Editar_Livro;
    private javax.swing.JMenuItem Excluir_Cliente;
    private javax.swing.JMenuItem Excluir_Livro;
    private javax.swing.JButton JB_cadastrar;
    private javax.swing.JButton JB_editar;
    private javax.swing.JButton JB_excluir;
    private javax.swing.JButton JB_pesquisa;
    private javax.swing.JLabel JL_bairro;
    private javax.swing.JLabel JL_cpf;
    private javax.swing.JLabel JL_endereco;
    private javax.swing.JLabel JL_id;
    private javax.swing.JLabel JL_idade;
    private javax.swing.JLabel JL_nome;
    private javax.swing.JTextField JT_bairro;
    private javax.swing.JTextField JT_cpf;
    private javax.swing.JTextField JT_endereco;
    private javax.swing.JTextField JT_id;
    private javax.swing.JTextField JT_idade;
    private javax.swing.JTextField JT_nome;
    private javax.swing.JMenu Logout;
    private javax.swing.JMenu Menu_Cliente;
    private javax.swing.JMenu Menu_Livro;
    private javax.swing.JMenuItem Pesquisar_Cliente;
    private javax.swing.JMenuItem Pesquisar_Livro;
    private javax.swing.JMenuItem Realizar_Aluguel;
    private javax.swing.JMenuItem Realizar_Devolução;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
