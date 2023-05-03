/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelBean;

/**
 *
 * @author anton
 */
public class BeanProduto {
    private int cod_Prod;
    private String nome_Prod;
    private int fk_cod_Forn;
    private double preco_Prod;
    public BeanFornecedor forn;

    public BeanFornecedor getForn() {
        return forn;
    }

    public void setForn(BeanFornecedor forn) {
        this.forn = forn;
    }
    

    public int getCod_Prod() {
        return cod_Prod;
    }

    public void setCod_Prod(int cod_Prod) {
        this.cod_Prod = cod_Prod;
    }

    public String getNome_Prod() {
        return nome_Prod;
    }

    public void setNome_Prod(String nome_Prod) {
        this.nome_Prod = nome_Prod;
    }

    public int getFk_cod_Forn() {
        return fk_cod_Forn;
    }

    public void setFk_cod_Forn(int fk_cod_Forn) {
        this.fk_cod_Forn = fk_cod_Forn;
    }

    public double getPreco_Prod() {
        return preco_Prod;
    }

    public void setPreco_Prod(double preco_Prod) {
        this.preco_Prod = preco_Prod;
    }
    
}
