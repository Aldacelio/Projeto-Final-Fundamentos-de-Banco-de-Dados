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
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author aldac
 */
public class Cadastro_Aluguel extends javax.swing.JFrame {
    Connection conexao = null; //Variavel de conexao 
    PreparedStatement pst = null; //Variavel de execução das sql
    ResultSet rs = null; //Variavel para exibir resultados
    
    public void pesquisar_cliente(){
        String sql_pesquisa_cliente = "select * from clientes where nome like ?";
        
        try {
            pst = conexao.prepareStatement(sql_pesquisa_cliente);
            pst.setString(1, JT_pesquisa.getText() + "%");
            rs=pst.executeQuery();
            TBL_clientes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setar_campos_cliente(){
        int setar_cliente = TBL_clientes.getSelectedRow();
        JT_cpf.setText(TBL_clientes.getModel().getValueAt(setar_cliente, 1).toString());
        JT_nomeC.setText(TBL_clientes.getModel().getValueAt(setar_cliente, 2).toString());
        JT_endereco.setText(TBL_clientes.getModel().getValueAt(setar_cliente, 4).toString());
        JT_bairro.setText(TBL_clientes.getModel().getValueAt(setar_cliente, 5).toString());
    }
    
    public void pesquisar_livros(){
        String sql_pesquisa_livros = "select * from livros where nome like ?";
        
        try {
            pst = conexao.prepareStatement(sql_pesquisa_livros);
            pst.setString(1, JT_pesquisa_livro.getText() + "%");
            rs=pst.executeQuery();
            TBL_Livros.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setar_campos_livro(){
        int setar_cliente = TBL_Livros.getSelectedRow();
        JT_nomeL.setText(TBL_Livros.getModel().getValueAt(setar_cliente, 1).toString());
        JT_genero.setText(TBL_Livros.getModel().getValueAt(setar_cliente, 4).toString());
    }
    
    public void cadastrar(){
        String sql_cadastro = "insert into aluguel(cpf,cliente,endereco,bairro,livro,genero) values(?,?,?,?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql_cadastro);
            pst.setString(1, JT_cpf.getText());
            pst.setString(2, JT_nomeC.getText());
            pst.setString(3, JT_endereco.getText());
            pst.setString(4, JT_bairro.getText());
            pst.setString(5, JT_nomeL.getText());
            pst.setString(6, JT_genero.getText());
            int adcionado = pst.executeUpdate();
            
            if(adcionado>0){
                JT_cpf.setText("");
                JT_nomeC.setText("");
                JT_endereco.setText("");
                JT_genero.setText("");
                JT_bairro.setText("");
                JT_nomeL.setText("");
                
                JOptionPane.showMessageDialog(null, "Alugado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    private void setIcon(){
            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/icon.png")));
        
    }

    /**
     * Creates new form Cadastro_Aluguel
     */
    public Cadastro_Aluguel() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JT_genero = new javax.swing.JTextField();
        JT_cpf = new javax.swing.JTextField();
        JT_nomeC = new javax.swing.JTextField();
        JT_nomeL = new javax.swing.JTextField();
        JT_endereco = new javax.swing.JTextField();
        JT_bairro = new javax.swing.JTextField();
        Menu_Principal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_clientes = new javax.swing.JTable();
        JT_pesquisa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_Livros = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        JT_pesquisa_livro = new javax.swing.JTextField();
        Cadastrar_Aluguel = new javax.swing.JButton();
        Fundo = new javax.swing.JLabel();
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
        setMinimumSize(new java.awt.Dimension(646, 670));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bairro:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 260, 70, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Genero :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 480, 80, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cpf do cliente :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 170, 90, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Endereço :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 270, 70, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome do cliente :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 220, 120, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nome do livro :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 490, 100, 30);

        JT_genero.setEnabled(false);
        JT_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_generoActionPerformed(evt);
            }
        });
        getContentPane().add(JT_genero);
        JT_genero.setBounds(440, 490, 120, 30);

        JT_cpf.setEnabled(false);
        JT_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_cpfActionPerformed(evt);
            }
        });
        getContentPane().add(JT_cpf);
        JT_cpf.setBounds(170, 180, 350, 30);

        JT_nomeC.setEnabled(false);
        JT_nomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_nomeCActionPerformed(evt);
            }
        });
        getContentPane().add(JT_nomeC);
        JT_nomeC.setBounds(190, 220, 330, 30);

        JT_nomeL.setEnabled(false);
        JT_nomeL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_nomeLActionPerformed(evt);
            }
        });
        getContentPane().add(JT_nomeL);
        JT_nomeL.setBounds(150, 490, 220, 30);

        JT_endereco.setEnabled(false);
        JT_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(JT_endereco);
        JT_endereco.setBounds(150, 270, 200, 30);

        JT_bairro.setEnabled(false);
        JT_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_bairroActionPerformed(evt);
            }
        });
        getContentPane().add(JT_bairro);
        JT_bairro.setBounds(400, 270, 120, 30);

        Menu_Principal.setBackground(new java.awt.Color(0, 0, 0));
        Menu_Principal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Menu_Principal.setForeground(new java.awt.Color(255, 255, 255));
        Menu_Principal.setText("Menu principal");
        Menu_Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_PrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(Menu_Principal);
        Menu_Principal.setBounds(380, 550, 120, 40);

        TBL_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBL_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_clientes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 630, 90);

        JT_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JT_pesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(JT_pesquisa);
        JT_pesquisa.setBounds(10, 40, 290, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CLIENTE QUE SOLICITA ALUGUEL :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 10, 240, 20);

        TBL_Livros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBL_Livros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_LivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBL_Livros);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 380, 630, 90);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LIVRO QUE DESEJA ALUGAR :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 310, 240, 30);

        JT_pesquisa_livro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JT_pesquisa_livroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JT_pesquisa_livroKeyReleased(evt);
            }
        });
        getContentPane().add(JT_pesquisa_livro);
        JT_pesquisa_livro.setBounds(10, 340, 280, 30);

        Cadastrar_Aluguel.setBackground(new java.awt.Color(0, 0, 0));
        Cadastrar_Aluguel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cadastrar_Aluguel.setForeground(new java.awt.Color(255, 255, 255));
        Cadastrar_Aluguel.setText("Cadastrar");
        Cadastrar_Aluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cadastrar_AluguelActionPerformed(evt);
            }
        });
        getContentPane().add(Cadastrar_Aluguel);
        Cadastrar_Aluguel.setBounds(150, 550, 120, 40);

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundinho.png"))); // NOI18N
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 640, 650);

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

    private void JT_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_generoActionPerformed

    private void JT_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_cpfActionPerformed

    private void JT_nomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_nomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_nomeCActionPerformed

    private void JT_nomeLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_nomeLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_nomeLActionPerformed

    private void JT_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_enderecoActionPerformed

    private void JT_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_bairroActionPerformed

    private void Menu_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_PrincipalActionPerformed
        // TODO add your handling code here:
        Tela_Principal e = new Tela_Principal();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_Menu_PrincipalActionPerformed

    private void JT_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_pesquisaKeyReleased
        // TODO add your handling code here:
        pesquisar_cliente();
    }//GEN-LAST:event_JT_pesquisaKeyReleased

    private void Cadastrar_AluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cadastrar_AluguelActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_Cadastrar_AluguelActionPerformed

    private void JT_pesquisa_livroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_pesquisa_livroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_pesquisa_livroKeyPressed

    private void JT_pesquisa_livroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_pesquisa_livroKeyReleased
        // TODO add your handling code here:
        pesquisar_livros();
    }//GEN-LAST:event_JT_pesquisa_livroKeyReleased

    private void TBL_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_clientesMouseClicked
        // TODO add your handling code here:
        setar_campos_cliente();
    }//GEN-LAST:event_TBL_clientesMouseClicked

    private void TBL_LivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_LivrosMouseClicked
        // TODO add your handling code here:
        setar_campos_livro();
    }//GEN-LAST:event_TBL_LivrosMouseClicked

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
            java.util.logging.Logger.getLogger(Cadastro_Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Aluguel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aluguel;
    private javax.swing.JButton Cadastrar_Aluguel;
    private javax.swing.JMenuItem Cadastrar_Cliente;
    private javax.swing.JMenuItem Cadastrar_Livro;
    private javax.swing.JMenuItem Editar_Cliente;
    private javax.swing.JMenuItem Editar_Livro;
    private javax.swing.JMenuItem Excluir_Cliente;
    private javax.swing.JMenuItem Excluir_Livro;
    private javax.swing.JLabel Fundo;
    private javax.swing.JTextField JT_bairro;
    private javax.swing.JTextField JT_cpf;
    private javax.swing.JTextField JT_endereco;
    private javax.swing.JTextField JT_genero;
    private javax.swing.JTextField JT_nomeC;
    private javax.swing.JTextField JT_nomeL;
    private javax.swing.JTextField JT_pesquisa;
    private javax.swing.JTextField JT_pesquisa_livro;
    private javax.swing.JMenu Logout;
    private javax.swing.JMenu Menu_Cliente;
    private javax.swing.JMenu Menu_Livro;
    private javax.swing.JButton Menu_Principal;
    private javax.swing.JMenuItem Pesquisar_Cliente;
    private javax.swing.JMenuItem Pesquisar_Livro;
    private javax.swing.JMenuItem Realizar_Aluguel;
    private javax.swing.JMenuItem Realizar_Devolução;
    private javax.swing.JTable TBL_Livros;
    private javax.swing.JTable TBL_clientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
