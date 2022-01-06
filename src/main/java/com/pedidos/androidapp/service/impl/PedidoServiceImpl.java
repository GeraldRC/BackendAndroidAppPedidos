package com.pedidos.androidapp.service.impl;

import com.pedidos.androidapp.model.Pedido;
import com.pedidos.androidapp.repo.IPedidoRepo;
import com.pedidos.androidapp.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepo repo;

    @Override
    public List<Pedido> getAll() {
        return repo.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> op = repo.findById(id);
        return op.orElseGet(Pedido::new);
    }

    @Override
    public Pedido register(Pedido obj) {
        return repo.save(obj);
    }

    @Override
    public Pedido modify(Pedido obj) {
        return repo.save(obj);
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return true;
    }
}
