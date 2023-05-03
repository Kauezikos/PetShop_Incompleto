/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelBean;

/**
 *
 * @author anton
 */
public class BeanAnimal {
    private int cod_Ani;
    private String nome_Ani;
    private String tipo_Ani;
    private int fk_cod_Clie;
    public BeanCliente clie;

    public int getCod_Ani() {
        return cod_Ani;
    }

    public void setCod_Ani(int cod_Ani) {
        this.cod_Ani = cod_Ani;
    }

    public String getNome_Ani() {
        return nome_Ani;
    }

    public void setNome_Ani(String nome_Ani) {
        this.nome_Ani = nome_Ani;
    }

    public String getTipo_Ani() {
        return tipo_Ani;
    }

    public void setTipo_Ani(String tipo_Ani) {
        this.tipo_Ani = tipo_Ani;
    }

    public int getFk_cod_Clie() {
        return fk_cod_Clie;
    }

    public void setFk_cod_Clie(int fk_cod_Clie) {
        this.fk_cod_Clie = fk_cod_Clie;
    }

    public BeanCliente getClie() {
        return clie;
    }

    public void setClie(BeanCliente clie) {
        this.clie = clie;
    }
    
    
    
}
