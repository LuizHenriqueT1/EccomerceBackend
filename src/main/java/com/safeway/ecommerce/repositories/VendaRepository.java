package com.safeway.ecommerce.repositories;

import com.safeway.ecommerce.entities.Usuario;
import com.safeway.ecommerce.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
