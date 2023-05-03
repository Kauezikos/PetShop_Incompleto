/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;
import Conexão.ConnectionFactory;
import ModelBean.BeanFornecedor;
import java.sql.*;
import ModelBean.BeanProduto;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoProduto {

    private Connection conecta; // Variavel que receberá a conexão

    public DaoProduto() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }

    // método de cadastro
    public void inserirDados(BeanProduto obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into produto(nome_Prod,fk_cod_Forn,preco_Prod) values(?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_Prod()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getFk_cod_Forn());
            stmt.setDouble(3, obj.getPreco_Prod());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Produto"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de funcionarios
    
    public List<BeanProduto> ListadeProduto(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanProduto> listaProd = new ArrayList<BeanProduto>();
            
            // comando sql de busca
            
            String sql = "select P.cod_Prod as cdp, P.nome_Prod as nmp, P.preco_Prod as prp, F.nome_Forn as nmf from "
                    + "produto P inner join fornecedor F on F.cod_Forn = P.fk_cod_Forn ";
            
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
                BeanProduto bp = new BeanProduto(); // cria objeto pra acessar os dados
                
                bp.setCod_Prod(rs.getInt("cdp"));
                bp.setNome_Prod(rs.getString("nmp"));
               bp.setPreco_Prod(rs.getDouble("prp"));
              BeanFornecedor bf = new BeanFornecedor();
              bf.setNome_Forn(rs.getString("nmf"));
              
              bp.setForn(bf);
            
                // adiciona na lista o valor do objeto
                
                listaProd.add(bp);
            
            }
            // retorna a lista no void do metodo
            return listaProd;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    // método de atualizar um cadastro
    
    public void AlterarProduto(BeanProduto obj){
        try {
             // cria o comando sql
    
    String sql = "update produto set nome_Prod=?,fk_cod_Prod=?,preco_Prod=? where cod_Prod like ?";
    
    PreparedStatement stmt = conecta.prepareStatement(sql);
        stmt.setString(1, obj.getNome_Prod()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setInt(2, obj.getFk_cod_Forn());
            stmt.setDouble(3, obj.getPreco_Prod());
            stmt.setInt(4, obj.getCod_Prod());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
             throw new RuntimeException("DEU ERRO NA ALTERAÇÃO"+e);
        }
    
    
    }

}

