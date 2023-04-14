package com.safeway.ecommerce.repositories;

import com.safeway.ecommerce.entities.ItemVenda;
import com.safeway.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
}
