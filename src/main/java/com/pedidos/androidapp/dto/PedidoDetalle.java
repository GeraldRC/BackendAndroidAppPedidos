package com.pedidos.androidapp.dto;

import com.pedidos.androidapp.model.Images;
import com.pedidos.androidapp.model.Pedido;

import java.util.List;

public class PedidoDetalle {

    private Pedido pedido;
    private List<Images> imagesList;


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }
}
