package com.pedidos.androidapp.controller;

import com.pedidos.androidapp.exception.ModelNotFoundException;
import com.pedidos.androidapp.model.Pedido;
import com.pedidos.androidapp.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable("id") Long id){
        Pedido pedido = service.findById(id);
        if (pedido.getId() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido){
        Pedido obj = service.register(pedido);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Pedido> modify(@Valid @RequestBody Pedido pedido){
        Pedido obj = service.modify(pedido);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Pedido obj = service.findById(id);
        if (obj.getId() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " +id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
