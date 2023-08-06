package com.protick.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());
 private static final List<Todo> TODOS_LIST =
         List.of(new Todo("protick1","Learn AWS"),
                 new Todo("protick","Get AWS certified"),
                 new Todo("admin","Get Admin certified"));

 @GetMapping("/todos")
 private List<Todo> retrieveAllTodos() {
     return TODOS_LIST;
 }


    @GetMapping("/users/{username}/todos")
//    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'protick'")
    private Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }


    @PostMapping("/users/{username}/todos")
    private void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Creating {} for {}",todo,username);
    }



}

record Todo (String username, String description){}