package com.protick.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int countTodo = 0;

	static {
		todos.add(new Todo(++countTodo, "protick", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo, "protick", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++countTodo, "protick", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsrName(String userName) {
		return todos;
	}
	
	public void addTodo(String userName, String decription, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(++countTodo, userName, decription, targetDate, isDone);
		todos.add(todo);
		
	}
}
