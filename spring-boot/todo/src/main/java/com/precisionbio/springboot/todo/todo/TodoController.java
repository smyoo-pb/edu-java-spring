package com.precisionbio.springboot.todo.todo;

import java.time.LocalDate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoController {
    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoController(TodoService service, TodoRepository repo) {
        todoService = service;
        todoRepository = repo;
    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        model.put("todos", todoRepository.findByUsername(username));
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now(), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername();
        todo.setUsername(username);
        todoRepository.save(todo);

        return "redirect:todos";
    }
}
