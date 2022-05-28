package com.example.gsondb.controller;

import com.example.gsondb.exception.ResourceNotFoundException;
import com.example.gsondb.model.Post;
import com.example.gsondb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts(){ return postRepository.findAll();}

    @PostMapping
    public Post createPost(@RequestBody Post post){ return postRepository.save(post);}

    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Post not exist with id:"+id));
        return ResponseEntity.ok(post);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id,@RequestBody Post postDetails){
        Post postUpdate = postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post not exist with id:"+id));
        postUpdate.setPost_text(postDetails.getPost_text());

        postRepository.save(postUpdate);

        return ResponseEntity.ok(postUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post not exist with id:" + id));
        postRepository.delete(post);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
