/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.dto;

import br.com.organizerooms.models.Receita;
import br.com.organizerooms.models.Venda;
import br.com.organizerooms.models.VendaItem;
import java.util.Date;

/**
 *
 * @author Eder Jean Dias
 */
public class VendaItemDTO {
    private Long id;

    private Integer quantidade;

    private Double valor;
    
    private Venda venda;
    
    private Receita receita;
    
    public VendaItemDTO() {
    }

    public VendaItemDTO(Long id, Integer quantidade, Double valor, Venda venda, Receita receita) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.venda = venda;
        this.receita = receita;
    }
    
    public VendaItemDTO(VendaItem obj) {
        this.id = obj.getId();
        this.quantidade = obj.getQuantidade();
        this.valor = obj.getValor();
        this.venda = obj.getVenda();
        this.receita = obj.getReceita();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    @Override
    public String toString() {
        return "VendaItemDTO{" + "id=" + id + ", quantidade=" + quantidade + ", valor=" + valor + ", venda=" + venda + ", receita=" + receita + '}';
    }
    
    
    
    


}
