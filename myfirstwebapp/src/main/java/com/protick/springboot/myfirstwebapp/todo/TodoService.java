package com.protick.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int countTodo = 0;

    static {
        todos.add(new Todo(++countTodo, "protick", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++countTodo, "protick", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(
                new Todo(++countTodo, "protick", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsrName(String userName) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(userName);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String userName, String decription, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++countTodo, userName, decription, targetDate, isDone);
        todos.add(todo);

    }

    public void deleteByID(int id) {
        Predicate<? super Todo> predicare = todo -> todo.getId() == id;
        todos.removeIf(predicare);

    }

    public Todo findTodoByID(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteByID(todo.getId());
        todos.add(todo);

    }
}
