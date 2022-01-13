package com.pedidos.androidapp.repo;

import com.pedidos.androidapp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPedidoRepo extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByNumPed(Integer numped);
}
