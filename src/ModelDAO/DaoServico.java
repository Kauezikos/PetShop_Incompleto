/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;
import Conexão.ConnectionFactory;
import java.sql.*;
import ModelBean.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoServico {

    private Connection conecta; // Variavel que receberá a conexão

    public DaoServico() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }

    // método de cadastro
    public void inserirDados(BeanServico obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into servico(nome_Func_Serv,descri_Serv,fk_cod_Ani,fk_cod_Func) values(?,?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            
            stmt.setString(1, obj.getNome_Func_Serv());
            stmt.setString(2, obj.getDescri_Serv());
            stmt.setInt(3, obj.getFk_cod_Ani());
            stmt.setInt(4, obj.getFk_cod_Func());
            
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Serviço"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de Serviços
    // Em desenvolvimento
    public List<BeanServico> ListadeServicos(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanServico> listaServicos = new ArrayList<BeanServico>();
            
            // comando sql de busca
            
            String sql = "select S.cod_Serv as cds,S.nome_Func_Serv as nfs,S.descri_Serv as ds,"
                    + "S.fk_cod_Ani as cda, S.fk_cod_Func as cdf from servico S inner join ";
            
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
               
            }
            // retorna a lista no void do metodo
            return listaServicos;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    // método de atualizar um cadastro
    // EM DESENVOLVIMENTO
    public void AlterarServico(BeanServico obj){
        try {
             // cria o comando sql
    
    String sql = "update servico set nome_Func_Serv=?,descri_Serv=?,"
            + "fk_cod_Ani=?,fk_cod_Func=? where  ?";
    
    PreparedStatement stmt = conecta.prepareStatement(sql);
        
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
             throw new RuntimeException("DEU ERRO NA ALTERAÇÃO"+e);
        }
    
    
    }
}
