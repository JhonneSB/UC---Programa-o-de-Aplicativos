/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;
import java.math.BigDecimal;

/**
 *
 * @author carlos_js_santos
 */
public class Filme {
    private String nome,des,desc;
    private BigDecimal preco;
    private Integer cod;
    

    public Filme(String nome, String des, String desc, BigDecimal preco) {
        this.nome = nome;
        this.des = des;
        this.desc = desc;
        this.preco = preco;
        this.cod = cod;
    }
    public Filme(String nome, String desc, BigDecimal preco) {
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.cod = cod;
    }
        public Filme() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
    
    
    
}
