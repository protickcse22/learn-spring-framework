package com.protick.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {
    private TodoRepository todoRepository;

    public TodoControllerJPA(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoRepository.findByUsername(getLoggedinUserName());
        modelMap.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "", null, false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggedinUserName());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showupdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggedinUserName());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    public String getLoggedinUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
