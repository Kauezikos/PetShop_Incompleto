/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelBean;

/**
 *
 * @author anton
 */
public class BeanServico {
    private int cod_Serv;
    private String nome_Func_Serv;
    private String descri_Serv;
    private int fk_cod_Ani;
    private int fk_cod_Func;
    public BeanFornecedor forn;
    public BeanFuncionario func;
    public BeanUsuario user;

    public int getCod_Serv() {
        return cod_Serv;
    }

    public void setCod_Serv(int cod_Serv) {
        this.cod_Serv = cod_Serv;
    }

 
    public String getNome_Func_Serv() {
        return nome_Func_Serv;
    }

    public void setNome_Func_Serv(String nome_Func_Serv) {
        this.nome_Func_Serv = nome_Func_Serv;
    }

    public String getDescri_Serv() {
        return descri_Serv;
    }

    public void setDescri_Serv(String descri_Serv) {
        this.descri_Serv = descri_Serv;
    }

    public int getFk_cod_Ani() {
        return fk_cod_Ani;
    }

    public void setFk_cod_Ani(int fk_cod_Ani) {
        this.fk_cod_Ani = fk_cod_Ani;
    }

    public int getFk_cod_Func() {
        return fk_cod_Func;
    }

    public void setFk_cod_Func(int fk_cod_Func) {
        this.fk_cod_Func = fk_cod_Func;
    }

    public BeanFornecedor getForn() {
        return forn;
    }

    public void setForn(BeanFornecedor forn) {
        this.forn = forn;
    }

    public BeanFuncionario getFunc() {
        return func;
    }

    public void setFunc(BeanFuncionario func) {
        this.func = func;
    }

    public BeanUsuario getUser() {
        return user;
    }

    public void setUser(BeanUsuario user) {
        this.user = user;
    }
    
    
    
    
    
    
}
