package com.pedidos.androidapp.repo;

import com.pedidos.androidapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    @Query("from User u where u.user = :user and u.pass= :pass")
    Optional<User> getUserLogin(@Param("user") String user, @Param("pass") String pass);

}
