package com.safeway.ecommerce.services;

import com.safeway.ecommerce.entities.Produto;
import com.safeway.ecommerce.entities.dtos.ProdutoDto;
import com.safeway.ecommerce.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto adicionaProduto(@Valid ProdutoDto objDto) {
        objDto.setId(null);
        Produto newObj = new Produto(objDto);
        return repository.save(newObj);
    }
}
