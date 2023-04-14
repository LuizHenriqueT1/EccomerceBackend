package com.safeway.ecommerce.entities;

import com.safeway.ecommerce.entities.dtos.ProdutoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(ProdutoDto objDto) {
        this.id = objDto.getId();
        this.nome = objDto.getNome();
        this.preco = objDto.getPreco();
        this.quantidadeEstoque = objDto.getQuantidadeEstoque();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
