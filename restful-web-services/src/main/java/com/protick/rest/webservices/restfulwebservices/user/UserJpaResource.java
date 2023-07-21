package com.protick.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
public class UserJpaResource {

    private UserRepository userRepository;
    private PostRepository postRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("user-all"));
        return entityModel;
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retrieveUserPost(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User id: " + id);
        }
        return user.get().getPosts();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id,@Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User id: " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


//    http://localhost:8080/jpa/users/10001/posts/1
    @GetMapping(path = "/jpa/users/{user_id}/posts/{post_id}")
    public Post retrieveUserSpecificPost(@PathVariable int user_id, @PathVariable int post_id) {
        Optional<User> user = userRepository.findById(user_id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User id: " + user_id);
        }
        Predicate<? super Post> filter = post -> post.getId() == post_id;
        Post post = user.get().getPosts().stream().filter(filter).findFirst().orElse(null);
        logger.info("Post: "+post);
        return post;
    }

}
