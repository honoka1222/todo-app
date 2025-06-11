package com.example.message.controller;


import com.example.message.service.MessageService;
import com.example.message.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        System.out.println("Editing message with ID: " + id);
        Message message = service.findById(id);
        model.addAttribute("message", message);
        return "edit-message"; // thymeleafのテンプレート名
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("todo", todo);
        return "edit";
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




