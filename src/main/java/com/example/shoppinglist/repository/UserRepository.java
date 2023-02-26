package com.example.shoppinglist.repository;

import com.example.shoppinglist.domain.entity.User;
import com.example.shoppinglist.domain.serviceModel.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
