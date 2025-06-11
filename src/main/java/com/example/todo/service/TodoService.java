package com.example.todo.service;

import com.example.todo.model.Message;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
     private final TodoRepository repository;

       public TodoService(TodoRepository repository){
           this.repository = repository;
    }

        public List<Message> getAllMessages(){
                 return repository.findAll();
        }

          public void addMessage(String name, String text){
               repository.save(new Message(name,text));
          }
    
}
