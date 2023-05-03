/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;
import Conexão.ConnectionFactory;
import java.sql.*;
import ModelBean.BeanUsuario;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author anton
 */
public class DaoUsuario {
     private Connection conecta; // Variavel que receberá a conexão

    public DaoUsuario() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }

      // método de cadastro
    public void inserirDados(BeanUsuario obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into usuario(nome_User,senha_User,fk_cod_Func) values(?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_User()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setString(2, obj.getSenha_User());
            stmt.setInt(3, obj.getFk_cod_Func());
            
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Usuário"+e); // se der erro
        }

    }
    
    public boolean Login(String usuario,String senha){
        try {
              // comando sql que será usado para fazer o insert

            String sql = "select * from usuario where nome_User=? and senha_User=?";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1,usuario); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery(); // realiza busca no banco de dados e armazena na variavel rs
            
            if(rs.first()){
            return true;
            
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na verificação do Login"+e);
        }
         return false;
         
 
    }
    
}
