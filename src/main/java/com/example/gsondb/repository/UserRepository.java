package com.example.gsondb.repository;

import com.example.gsondb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserRepository extends JpaRepository<User,Long> {
    //all crud data base method
}
