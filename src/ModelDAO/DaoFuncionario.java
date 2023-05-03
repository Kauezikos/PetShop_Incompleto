/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Conexão.ConnectionFactory;
import java.sql.*;
import ModelBean.BeanFuncionario;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoFuncionario {

    private Connection conecta; // Variavel que receberá a conexão

    public DaoFuncionario() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }

    // método de cadastro
    public void inserirDados(BeanFuncionario obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into funcionario(nome_func,cpf_Func,endereco_Func,telefone_func) values(?,?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_Func()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCpf_Func());
            stmt.setString(3, obj.getEndereco_Func());
            stmt.setString(4, obj.getTelefone_Func());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Funcionário"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de funcionarios
    
    public List<BeanFuncionario> ListadeFuncionario(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanFuncionario> listaFunc = new ArrayList<BeanFuncionario>();
            
            // comando sql de busca
            
            String sql = "select * from funcionario";
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
                BeanFuncionario bf = new BeanFuncionario(); // cria objeto pra acessar os dados
                
                bf.setCod_Func(rs.getInt("cod_Func"));
                bf.setNome_Func(rs.getString("nome_Func"));
                bf.setCpf_Func(rs.getInt("cpf_Func"));
                bf.setEndereco_Func(rs.getString("endereco_Func"));
                bf.setTelefone_Func(rs.getString("telefone_Func"));
            
                // adiciona na lista o valor do objeto
                
                listaFunc.add(bf);
            
            }
            // retorna a lista no void do metodo
            return listaFunc;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    // método de atualizar um cadastro
    
    public void AlterarFuncionario(BeanFuncionario obj){
        try {
             // cria o comando sql
    
    String sql = "update funcionario set nome_Func=?,cpf_Func=?,endereco_Func=?,telefone_Func=? where cod_Func like ?";
    
    PreparedStatement stmt = conecta.prepareStatement(sql);
      stmt.setString(1, obj.getNome_Func()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCpf_Func());
            stmt.setString(3, obj.getEndereco_Func());
            stmt.setString(4, obj.getTelefone_Func());
            stmt.setInt(5, obj.getCod_Func());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
             throw new RuntimeException("DEU ERRO NA ALTERAÇÃO"+e);
        }
    
    
    }

}
