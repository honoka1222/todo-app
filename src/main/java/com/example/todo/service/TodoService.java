package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
     private final TodoRepository repository;

       public TodoService(TodoRepository repository){
           this.repository = repository;
    }

     public List<Todo> getAllTodos(){
               return repository.findAll();
     }

     public void addTodo(String title, String description){
          repository.save(new Todo(title, description));
     }

     public Todo findById(Integer id) {
          return repository.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
     }
}
