package com.pedidos.androidapp.service;

import com.pedidos.androidapp.model.User;

public interface IUserService extends ICRUD<User>{

    User getUserLogin(String user, String pass);
}
