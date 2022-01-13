package com.pedidos.androidapp.service;

import com.pedidos.androidapp.model.Pedido;

import java.util.Optional;

public interface IPedidoService extends ICRUD<Pedido>{

    Pedido getPedidoByNumPed(Integer numped);
}
