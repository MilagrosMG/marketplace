package edu.es.eoi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.es.eoi.marketplace.entity.ArticulosPedido;

@Repository
public interface ArticulosPedidoRepository extends JpaRepository<ArticulosPedido, Integer> {

}


