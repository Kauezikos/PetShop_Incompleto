/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.*;
import ModelBean.BeanCliente;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoCliente {
       private Connection conecta; // Variavel que receberá a conexão

    public DaoCliente() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }
    // método de cadastro
    public void inserirDados(BeanCliente obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into cliente(nome_Clie,cpf_Clie,endereco_Clie,telefone_Clie) values(?,?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_Clie()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCpf_Clie());
            stmt.setString(3, obj.getEndereco_Clie());
            stmt.setString(4, obj.getTelefone_Clie());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Cliente"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de funcionarios
    
    public List<BeanCliente> ListadeCliente(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanCliente> listaClie = new ArrayList<BeanCliente>();
            
            // comando sql de busca
            
            String sql = "select * from cliente";
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
                BeanCliente bc = new BeanCliente(); // cria objeto pra acessar os dados
                
                bc.setCod_Clie(rs.getInt("cod_Clie"));
                bc.setNome_Clie(rs.getString("nome_Clie"));
                bc.setCpf_Clie(rs.getInt("cpf_Clie"));
                bc.setEndereco_Clie(rs.getString("endereco_Clie"));
                bc.setTelefone_Clie(rs.getString("telefone_Clie"));
            
                // adiciona na lista o valor do objeto
                
                listaClie.add(bc);
            
            }
            // retorna a lista no void do metodo
            return listaClie;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    // método de atualizar um cadastro
    
    public void AlterarCliente(BeanCliente obj){
        try {
             // cria o comando sql
    
    String sql = "update cliente set nome_Clie=?,cpf_Clie=?,endereco_Clie=?,telefone_Clie=? where cod_Clie like ?";
    
    PreparedStatement stmt = conecta.prepareStatement(sql);
      stmt.setString(1, obj.getNome_Clie()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCpf_Clie());
            stmt.setString(3, obj.getEndereco_Clie());
            stmt.setString(4, obj.getTelefone_Clie());
            stmt.setInt(5, obj.getCod_Clie());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
             throw new RuntimeException("DEU ERRO NA ALTERAÇÃO"+e);
        }
    
    
    }

}
