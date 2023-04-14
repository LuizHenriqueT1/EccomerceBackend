package com.safeway.ecommerce.controllers;

import com.safeway.ecommerce.entities.Produto;
import com.safeway.ecommerce.entities.Usuario;
import com.safeway.ecommerce.entities.dtos.ProdutoDto;
import com.safeway.ecommerce.entities.dtos.UsuarioDto;
import com.safeway.ecommerce.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        List<Usuario> list = service.listarUsuarios();
        List<UsuarioDto> listDto = list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @PostMapping
    public ResponseEntity<ProdutoDto> criarUsuario(@Valid @RequestBody UsuarioDto objDto) {
        Usuario newObj = service.criarUsuario(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
