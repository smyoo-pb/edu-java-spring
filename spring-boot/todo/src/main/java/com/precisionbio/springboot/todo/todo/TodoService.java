package com.precisionbio.springboot.todo.todo;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int newId() {
        return todos.size() + 1;
    }

    static {
        todos.add(new Todo(
                newId(), "smyoo", "Learn Spring Boot",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(
                newId(), "smyoo", "Learn Spring MVC",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(
                newId(), "smyoo", "Learn Spring Security",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        todos.add(new Todo(newId(), username, description, targetDate, isDone));

    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
