package com.safeway.ecommerce.entities;


import com.safeway.ecommerce.entities.dtos.UsuarioDto;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuario(UsuarioDto objDto) {
        this.id = objDto.getId();
        this.nome = objDto.getNome();
        this.cpf = objDto.getCpf();
        this.email = objDto.getEmail();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
