package com.safeway.ecommerce.entities;

import com.safeway.ecommerce.entities.dtos.ItemVendaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_venda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    private Produto produto;
    @Column(nullable = false)
    private Integer quantidade;

    public ItemVenda() {
    }

    public ItemVenda(Integer id, Produto produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemVenda(ItemVendaDto objDto) {
        this.id = objDto.getId();
        this.produto = objDto.getProduto();
        this.quantidade = objDto.getQuantidade();
    }

    public void atualizarQuantidadeProduto(EntityManager entityManager) {
        Produto produto = entityManager.find(Produto.class, this.getProduto().getId());

        if (produto.getQuantidade() >= this.getQuantidade()) {
            produto.setQuantidade(produto.getQuantidade() - this.getQuantidade());

            entityManager.persist(produto);
        } else {
            throw new RuntimeException("Quantidade de produto insuficiente para realizar a venda");
        }
    }

    public Integer getId() {
        return id;
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

    public void setQuanitdade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
