package com.pedidos.androidapp.controller;

import com.pedidos.androidapp.model.User;
import com.pedidos.androidapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}