package com.safeway.ecommerce.services;

import com.safeway.ecommerce.entities.ItemVenda;
import com.safeway.ecommerce.entities.Produto;
import com.safeway.ecommerce.entities.Venda;
import com.safeway.ecommerce.entities.dtos.VendaDto;
import com.safeway.ecommerce.repositories.ProdutoRepository;
import com.safeway.ecommerce.repositories.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Venda criarVenda(VendaDto vendaDto) {
        vendaDto.setId(null);
        Venda newObj = new Venda(vendaDto);

        List<ItemVenda> itens = vendaDto.getItemVendas();
        if (itens.isEmpty()) {
            throw new IllegalArgumentException("A lista de itens de venda não pode estar vazia");
        }
        itens.forEach(item -> {
            Produto produto = item.getProduto();
            Integer quantidadeVendida = item.getQuantidade();
            validarQuantidadeEstoque(produto, quantidadeVendida);
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidadeVendida);
            produtoRepository.save(produto);
        });
        return vendaRepository.save(newObj);
    }

    private void validarQuantidadeEstoque(Produto produto, Integer quantidadeVendida) {
        Integer quantidadeAtual = produto.getQuantidadeEstoque();
        if (quantidadeVendida > quantidadeAtual) {
            throw new RuntimeException("Produto com quantidade insuficiente");
        }
    }

    public List<Venda> listaVendas() {
        return vendaRepository.findAll();
    }
}
