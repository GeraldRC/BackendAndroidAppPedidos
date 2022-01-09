package com.pedidos.androidapp.service.impl;

import com.pedidos.androidapp.model.User;
import com.pedidos.androidapp.repo.IUserRepo;
import com.pedidos.androidapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> op = repo.findById(id);
        return op.orElseGet(User::new);
    }

    @Override
    public User register(User obj) {
        return repo.save(obj);
    }

    @Override
    public User modify(User obj) {
        return repo.save(obj);
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public User getUserLogin(String user, String pass) {
        Optional<User> op = repo.getUserLogin(user,pass);
        return op.orElseGet(User::new);
    }
}
