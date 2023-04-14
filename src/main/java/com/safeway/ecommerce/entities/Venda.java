package com.safeway.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.safeway.ecommerce.entities.dtos.VendaDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemVenda> itemVendas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda = LocalDate.now();

    public Venda() {
    }

    public Venda(Integer id, Usuario usuario, List<ItemVenda> itemVendas, LocalDate dataVenda) {
        this.id = id;
        this.usuario = usuario;
        this.itemVendas = itemVendas;
        this.dataVenda = dataVenda;
    }

    public Venda(VendaDto vendaDto) {
        this.id = vendaDto.getId();
        this.usuario = vendaDto.getUsuario();
        this.itemVendas = vendaDto.getItemVendas();
        this.dataVenda = vendaDto.getDataVenda();
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
