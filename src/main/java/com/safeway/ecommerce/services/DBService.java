package com.safeway.ecommerce.services;

import com.safeway.ecommerce.entities.ItemVenda;
import com.safeway.ecommerce.entities.Produto;
import com.safeway.ecommerce.entities.Usuario;
import com.safeway.ecommerce.entities.Venda;
import com.safeway.ecommerce.repositories.ItemVendaRepository;
import com.safeway.ecommerce.repositories.ProdutoRepository;
import com.safeway.ecommerce.repositories.UsuarioRepository;
import com.safeway.ecommerce.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public void instanciaDB() {
        Usuario u1 = new Usuario(null, "Henrique", "739.421.070-74", "henrique@gmail.com");
        Usuario u2 = new Usuario(null, "Luiz", "825.315.000-81", "luiz@gmail.com");

        Produto p1 = new Produto(null, "celular", 500.00, 10);
        Produto p2 = new Produto(null, "tv", 900.00, 5);

        ItemVenda i1 = new ItemVenda(null, p1, 2);
        ItemVenda i2 = new ItemVenda(null, p2, 3);
        List<ItemVenda> itemVendas = new ArrayList<>();
        itemVendas.add(i1);
        itemVendas.add(i2);

        Venda venda = new Venda(null, u1, itemVendas, LocalDate.now());


        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        produtoRepository.saveAll(Arrays.asList(p1, p2));
        vendaRepository.saveAll(List.of(venda));
        itemVendaRepository.saveAll(Arrays.asList(i1, i2));
    }
}
