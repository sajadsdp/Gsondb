package com.example.gsondb.repository;

import com.example.gsondb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    //all crud data base method
}
