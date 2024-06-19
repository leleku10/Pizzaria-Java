package com.senac.pizzademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.pizzademo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByLogin(String login);
    
}
