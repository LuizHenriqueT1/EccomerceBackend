package com.safeway.ecommerce.controllers;

import com.safeway.ecommerce.entities.Produto;
import com.safeway.ecommerce.entities.dtos.ProdutoDto;
import com.safeway.ecommerce.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarProdutos() {
        List<Produto> list = produtoService.listarProdutos();
        List<ProdutoDto> listDto = list.stream()
                .map(x -> new ProdutoDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> adicionaProduto(@Valid @RequestBody ProdutoDto objDto) {
        Produto newObj = produtoService.adicionaProduto(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
