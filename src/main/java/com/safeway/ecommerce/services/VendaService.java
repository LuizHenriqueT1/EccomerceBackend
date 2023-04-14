package com.safeway.ecommerce.services;

import com.safeway.ecommerce.entities.Venda;
import com.safeway.ecommerce.entities.dtos.VendaDto;
import com.safeway.ecommerce.repositories.ProdutoRepository;
import com.safeway.ecommerce.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;
    public Venda criarVenda(VendaDto vendaDto) {
        vendaDto.setId(null);
        Venda newObj = new Venda(vendaDto);
        return repository.save(newObj);
    }

    public List<Venda> listaVendas() {
        return repository.findAll();
    }
}
