/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelBean;

/**
 *
 * @author anton
 */
public class BeanUsuario {
    private int cod_User;
    private String nome_User;
    private String senha_User;
    private int fk_cod_Func;
    private BeanFuncionario func;

    public int getCod_User() {
        return cod_User;
    }

    public void setCod_User(int cod_User) {
        this.cod_User = cod_User;
    }

    public String getNome_User() {
        return nome_User;
    }

    public void setNome_User(String nome_User) {
        this.nome_User = nome_User;
    }

    public String getSenha_User() {
        return senha_User;
    }

    public void setSenha_User(String senha_User) {
        this.senha_User = senha_User;
    }

    public int getFk_cod_Func() {
        return fk_cod_Func;
    }

    public void setFk_cod_Func(int fk_cod_Func) {
        this.fk_cod_Func = fk_cod_Func;
    }

    public BeanFuncionario getFunc() {
        return func;
    }

    public void setFunc(BeanFuncionario func) {
        this.func = func;
    }
    
}
