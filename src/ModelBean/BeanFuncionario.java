/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelBean;

/**
 *
 * @author anton
 */
public class BeanFuncionario {
    // Variaveis que vão receber os valores das entidades
    private int cod_Func;
    private String nome_Func;
    private int cpf_Func;
    private String endereco_Func;
    private String telefone_Func;
    
    //métodos de get e set das variaveis 

    public int getCod_Func() {
        return cod_Func;
    }

    public void setCod_Func(int cod_Func) {
        this.cod_Func = cod_Func;
    }

    public String getNome_Func() {
        return nome_Func;
    }

    public void setNome_Func(String nome_Func) {
        this.nome_Func = nome_Func;
    }

    public int getCpf_Func() {
        return cpf_Func;
    }

    public void setCpf_Func(int cpf_Func) {
        this.cpf_Func = cpf_Func;
    }

    public String getEndereco_Func() {
        return endereco_Func;
    }

    public void setEndereco_Func(String endereco_Func) {
        this.endereco_Func = endereco_Func;
    }

    public String getTelefone_Func() {
        return telefone_Func;
    }

    public void setTelefone_Func(String telefone_Func) {
        this.telefone_Func = telefone_Func;
    }
    
    
}
