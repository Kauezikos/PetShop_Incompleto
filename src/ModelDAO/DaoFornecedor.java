/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.*;
import ModelBean.BeanFornecedor;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoFornecedor {
       private Connection conecta; // Variavel que receberá a conexão

    public DaoFornecedor() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }
    // método de cadastro
    public void inserirDados(BeanFornecedor obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into fornecedor(nome_Forn,cnpj_Forn,endereco_Forn) values(?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_Forn()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCnpj_Form());
            stmt.setString(3, obj.getEndereco_Forn());
            
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Fornecedor"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de funcionarios
    
    public List<BeanFornecedor> ListadeFornecedor(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanFornecedor> listaForn = new ArrayList<BeanFornecedor>();
            
            // comando sql de busca
            
            String sql = "select * from fornecedor";
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
                BeanFornecedor bF = new BeanFornecedor(); // cria objeto pra acessar os dados
                
                bF.setCod_Forn(rs.getInt("cod_Forn"));
                bF.setNome_Forn(rs.getString("nome_Forn"));
                bF.setCnpj_Form(rs.getInt("cnpj_Forn"));
                bF.setEndereco_Forn(rs.getString("endereco_Forn"));
               
            
                // adiciona na lista o valor do objeto
                
                listaForn.add(bF);
            
            }
            // retorna a lista no void do metodo
            return listaForn;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    // método de atualizar um cadastro
    
    public void AlterarFornecedor(BeanFornecedor obj){
        try {
             // cria o comando sql
    
    String sql = "update fornecedor set nome_Forn=?,cnpj_Forn=?,endereco_Forn=? where cod_Forn like ?";
    
    PreparedStatement stmt = conecta.prepareStatement(sql);
     stmt.setString(1, obj.getNome_Forn()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getCnpj_Form());
            stmt.setString(3, obj.getEndereco_Forn());
            stmt.setInt(4, obj.getCod_Forn());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
             throw new RuntimeException("DEU ERRO NA ALTERAÇÃO"+e);
        }
    
    
    }

}
