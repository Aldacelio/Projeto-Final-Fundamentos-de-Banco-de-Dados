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
public class Pesquisa_Livro extends javax.swing.JFrame {
    Connection conexao = null; //Variavel de conexao 
    PreparedStatement pst = null; //Variavel de execução das sql
    ResultSet rs = null; //Variavel para exibir resultados
    
    public void pesquisa(){
        String sql_buscandoDados_livro = "Select * from livros where nome=?";
        
        try {
                pst = conexao.prepareStatement(sql_buscandoDados_livro);
                pst.setString(1,JT_nome.getText());
                rs = pst.executeQuery();
                if(rs.next()){
                JT_id.setText(rs.getString(1));
                JT_nome.setText(rs.getString(2));
                JT_editora.setText(rs.getString(3));
                JT_autor.setText(rs.getString(4));
                JT_genero.setText(rs.getString(5));
                JT_numero.setText(rs.getString(6));
                JT_ilustrador.setText(rs.getString(7));
                rs = pst.executeQuery();//executando a query
                rs.next();//positivando a execução da query
                JB_editar.setEnabled(true);
                JB_excluir.setEnabled(true);
                JT_editora.enable();
                JT_autor.enable();
                JT_genero.enable();
                JT_numero.enable();
                JT_ilustrador.enable();
                
                }else{
                    JOptionPane.showMessageDialog(null, "Livro não cadastrado ou Nome incorreto");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void editar(){
        String sql_editar_cliente = "update livros set nome=?,editora=?,autor=?,genero=?,numero=?,ilustrador=?";
        
        try {
            pst = conexao.prepareStatement(sql_editar_cliente);
            pst.setString(1, JT_nome.getText());
            pst.setString(2, JT_editora.getText());
            pst.setString(3, JT_autor.getText());
            pst.setString(4, JT_editora.getText());
            pst.setString(5, JT_numero.getText());
            pst.setString(6, JT_ilustrador.getText());
            pst.executeUpdate();//executando a query
            JT_id.setText("");
            JT_nome.setText("");
            JT_editora.setText("");
            JT_autor.setText("");
            JT_genero.setText("");
            JT_numero.setText("");
            JT_ilustrador.setText("");
            JB_editar.setEnabled(false);
            JB_excluir.setEnabled(false);
            JT_editora.disable();
            JT_autor.disable();
            JT_genero.disable();
            JT_numero.disable();
            JT_ilustrador.disable();
            
            JOptionPane.showMessageDialog(null,"Cadastro editado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Consulte o suporte e forneça a informação que ocorreu erro no try/catch de lembre-se de mim erro encontrado foi : "+e);
        }
        
    }
    
    public void excluir(){
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este livro ?");
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql_excluir_cliente = "delete from livros where nome=?";
            
            
            try {
                pst = conexao.prepareStatement(sql_excluir_cliente);
                pst.setString(1, JT_nome.getText());
                pst.executeUpdate();//executando a query
                JT_id.setText("");
                JT_nome.setText("");
                JT_editora.setText("");
                JT_autor.setText("");
                JT_genero.setText("");
                JT_numero.setText("");
                JT_ilustrador.setText("");
                JB_editar.setEnabled(false);
                JB_excluir.setEnabled(false);
                JT_editora.disable();
                JT_autor.disable();
                JT_genero.disable();
                JT_numero.disable();
                JT_ilustrador.disable();
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
     * Creates new form Pesquisa_Livro
     */
    public Pesquisa_Livro() {
        initComponents();
        conexao = Modulo_Conexão.conector();
        
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

        jButton2 = new javax.swing.JButton();
        JB_excluir = new javax.swing.JButton();
        JB_editar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JT_ilustrador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JT_genero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JT_numero = new javax.swing.JTextField();
        JT_autor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JT_editora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JT_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JT_nome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
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
        setMaximumSize(new java.awt.Dimension(590, 346));
        setMinimumSize(new java.awt.Dimension(590, 346));
        setPreferredSize(new java.awt.Dimension(590, 346));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cadastrar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 240, 100, 40);

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
        JB_excluir.setBounds(450, 240, 80, 40);

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
        JB_editar.setBounds(330, 240, 70, 40);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(180, 240, 100, 40);

        JT_ilustrador.setEnabled(false);
        getContentPane().add(JT_ilustrador);
        JT_ilustrador.setBounds(130, 180, 380, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ilustradores :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 174, 110, 40);

        JT_genero.setEnabled(false);
        getContentPane().add(JT_genero);
        JT_genero.setBounds(110, 130, 170, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gêneros :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 124, 80, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Numero de livro :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 130, 110, 30);

        JT_numero.setEnabled(false);
        getContentPane().add(JT_numero);
        JT_numero.setBounds(390, 130, 120, 30);

        JT_autor.setEnabled(false);
        getContentPane().add(JT_autor);
        JT_autor.setBounds(340, 80, 170, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Autor :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 74, 40, 40);

        JT_editora.setEnabled(false);
        getContentPane().add(JT_editora);
        JT_editora.setBounds(100, 80, 180, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editora: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 74, 90, 40);

        JT_id.setEnabled(false);
        getContentPane().add(JT_id);
        JT_id.setBounds(70, 30, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 24, 30, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 30, 50, 30);
        getContentPane().add(JT_nome);
        JT_nome.setBounds(200, 30, 310, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundinho.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-10, 0, 600, 310);

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

        jMenuBar3.add(Aluguel);

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

        jMenuBar3.add(Menu_Livro);

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

        jMenuBar3.add(Menu_Cliente);

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
        jMenuBar3.add(Logout);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        pesquisa();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Pesquisa_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa_Livro().setVisible(true);
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
    private javax.swing.JButton JB_editar;
    private javax.swing.JButton JB_excluir;
    private javax.swing.JTextField JT_autor;
    private javax.swing.JTextField JT_editora;
    private javax.swing.JTextField JT_genero;
    private javax.swing.JTextField JT_id;
    private javax.swing.JTextField JT_ilustrador;
    private javax.swing.JTextField JT_nome;
    private javax.swing.JTextField JT_numero;
    private javax.swing.JMenu Logout;
    private javax.swing.JMenu Menu_Cliente;
    private javax.swing.JMenu Menu_Livro;
    private javax.swing.JMenuItem Pesquisar_Cliente;
    private javax.swing.JMenuItem Pesquisar_Livro;
    private javax.swing.JMenuItem Realizar_Aluguel;
    private javax.swing.JMenuItem Realizar_Devolução;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar3;
    // End of variables declaration//GEN-END:variables
}
