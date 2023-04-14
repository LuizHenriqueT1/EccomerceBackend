package com.safeway.ecommerce.services;

import com.safeway.ecommerce.entities.Usuario;
import com.safeway.ecommerce.entities.Venda;
import com.safeway.ecommerce.entities.dtos.UsuarioDto;
import com.safeway.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario criarUsuario(UsuarioDto objDto) {
        objDto.setId(null);
        Usuario newObj = new Usuario(objDto);
        return repository.save(newObj);
    }
}
