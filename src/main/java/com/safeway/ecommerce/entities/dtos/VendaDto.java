package com.safeway.ecommerce.entities.dtos;

import com.safeway.ecommerce.entities.ItemVenda;
import com.safeway.ecommerce.entities.Usuario;
import com.safeway.ecommerce.entities.Venda;

import java.time.LocalDate;
import java.util.List;

public class VendaDto {
    private Integer id;
    private Usuario usuario;
    private List<ItemVenda> itemVendas;
    private LocalDate dataVenda = LocalDate.now();

    public VendaDto() {
    }

    public VendaDto(Venda venda) {
        this.id = venda.getId();
        this.usuario = venda.getUsuario();
        this.itemVendas = venda.getItemVendas();
        this.dataVenda = venda.getDataVenda();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }

    public void setItemVendas(List<ItemVenda> itemVendas) {
        this.itemVendas = itemVendas;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}


