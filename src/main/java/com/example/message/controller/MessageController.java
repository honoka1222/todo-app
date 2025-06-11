package com.example.message.controller;


import com.example.message.service.MessageService;
import com.example.message.model.Message;

import org.springframework.scheduling.config.Task;
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

    @GetMapping("/todo/edit/{id}") public String showEditForm(@PathVariable Long id, Model model) {     Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));     model.addAttribute("todo", todo);     return "edit"; }
更新ボタン <a th:href="@{/todo/edit/{id}(id=${todo.id})}">編集</a>

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

      // 編集内容を保存
    @PostMapping("/edit/{id}")
    public String updateMessage(@PathVariable Integer id, @ModelAttribute Message message) {
        service.updateMessage(id, message);
        return "redirect:/";
    }

// ...existing code...
}





