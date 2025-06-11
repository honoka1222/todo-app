package com.example.todo.controller;


import com.example.todo.service.TodoService;
import com.example.todo.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addMessage((name), text);
        }
        
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }
}




