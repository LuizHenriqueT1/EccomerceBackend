package com.safeway.ecommerce.controllers;

import com.safeway.ecommerce.entities.Venda;
import com.safeway.ecommerce.entities.dtos.VendaDto;
import com.safeway.ecommerce.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDto>> listaVendas() {
        List<Venda> list = vendaService.listaVendas();
        List<VendaDto> listDto = list.stream()
                .map(x -> new VendaDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<VendaDto> criarVenda(@Valid @RequestBody VendaDto vendaDto) {
        Venda newObj = vendaService.criarVenda(vendaDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
