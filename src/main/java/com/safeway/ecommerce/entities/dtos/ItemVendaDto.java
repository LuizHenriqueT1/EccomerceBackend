package com.safeway.ecommerce.entities.dtos;

import com.safeway.ecommerce.entities.Produto;

public class ItemVendaDto {
    private Integer id;

    private Produto produto;
    private Integer quantidade;

    public ItemVendaDto() {
    }

    public ItemVendaDto(Integer id, Produto produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
