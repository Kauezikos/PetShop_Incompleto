/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TesteBanco;

import javax.swing.JOptionPane;
import java.sql.*;
import Conexão.ConnectionFactory;

/**
 *
 * @author anton
 */
public class Teste {

    public static void main(String[] args) {
        try {
            //teste do Banco
            JOptionPane.showMessageDialog(null, "Testando");
            // A variavel con recebe a conexao
            Connection con = new ConnectionFactory().conecta();
            // avisa que funcionou
            JOptionPane.showMessageDialog(null, "Funcionando");
        } catch (Exception e) {
            //caso dê erro
            JOptionPane.showMessageDialog(null, "erro" + e);
        }
        
        

        
        
    }
}
