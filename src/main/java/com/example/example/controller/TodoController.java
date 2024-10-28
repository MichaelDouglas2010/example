package com.example.example.controller;

import com.example.example.entity.Todo;

import com.example.example.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService  todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //Expondo endpoint
    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    @PutMapping
    List<Todo> update(@RequestBody @Valid Todo todo){
        return todoService.update(todo);
    }
    //Vai pegar o id na path e injetar
    @DeleteMapping("/{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
