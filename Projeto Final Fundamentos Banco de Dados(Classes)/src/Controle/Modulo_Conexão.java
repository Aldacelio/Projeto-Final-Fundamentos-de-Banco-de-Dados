/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aldac
 */
public class Modulo_Conexão {
   //metodo responasavel por estabelecer a conexão
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // a linha abaixo "chama" o driver
        String driver = "org.postgresql.Driver";
        
        //armazenando informações referente ao banco
        String url = "jdbc:postgresql://localhost:5432/PF";
        String usuario = "postgres";
        String senha = "mav081501";
        
        //estabelecendo conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);//usando parametros para criar a conexao do BD
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            return null;
        }
    }
        
}
