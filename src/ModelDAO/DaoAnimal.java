/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;
import Conexão.ConnectionFactory;
import ModelBean.BeanAnimal;
import java.sql.*;
import ModelBean.BeanCliente;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class DaoAnimal {

    private Connection conecta; // Variavel que receberá a conexão

    public DaoAnimal() {
        this.conecta = new ConnectionFactory().conecta(); // atribuição da conexão na variavel

    }

    // método de cadastro
    public void inserirDados(BeanAnimal obj) {
        try {
            // comando sql que será usado para fazer o insert

            String sql = "insert into animal(nome_Ani,tipo_Ani,fk_cod_Clie) values(?,?,?)";

            // Preparar o comando 
            PreparedStatement stmt = conecta.prepareStatement(sql);

            // setando os parametros
            stmt.setString(1, obj.getNome_Ani()); // o tipo de variavel e o get correspondente ao banco de dados
            stmt.setString(2, obj.getTipo_Ani());
            stmt.setInt(3, obj.getFk_cod_Clie());
            
            stmt.execute(); // executa o comando
            
            stmt.close(); //encerra a conexão

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql na inserção do Animal"+e); // se der erro
        }

    }
    
    // metodo de mostrar na tabela de funcionarios
    
    public List<BeanAnimal> ListadeAnimal(){
        try {
            // Array que vai armazenar os dados
            
            List<BeanAnimal> listaAni = new ArrayList<BeanAnimal>();
            
            // comando sql de busca
            
            String sql = "select A.cod_Ani as cda, A.nome_Ani as nma, A.tipo_Ani as tpa, C.nome_Clie as nmd from "
                    + "animal A inner join cliente C on C.cod_Clie = A.fk_cod_Clie ";
            
            
            //prepara o comando
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            // cria um resultset para armazenar o resultado da busca
            
            ResultSet rs = stmt.executeQuery();
            
            // Lista o resultado
            
            while(rs.next()){
            
                BeanAnimal bp = new BeanAnimal(); // cria objeto pra acessar os dados
                
                bp.setCod_Ani(rs.getInt("cda"));
                bp.setNome_Ani(rs.getString("nma"));
               bp.setTipo_Ani(rs.getString("tpa"));
              
               BeanCliente bc = new BeanCliente();
                           
              bc.setNome_Clie(rs.getString("nmd"));
              
              bp.setClie(bc);
            
                // adiciona na lista o valor do objeto
                
                listaAni.add(bp);
            
            }
            // retorna a lista no void do metodo
            return listaAni;
        } catch (SQLException e) {
            throw new RuntimeException(e); // se der erros
        }
        
    
    }
    
    
    }

