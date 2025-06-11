package com.example.todo.controller;

import com.example.todo.service.TodoService;
import com.example.todo.model.Todo;

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
        List<Todo> todos = service.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        System.out.println("Editing todo with ID: " + id);
        Todo todo = service.findById(id);
        model.addAttribute("todo", todo);
        return "edit-todo"; // thymeleafのテンプレート名
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditForm(@PathVariable Long id) {
        // TODO: ここでIDに基づいてTodoを取得し、モデルに追加する
        return "edit";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addTodo(name, text);
        }

        List<Todo> todos = service.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }
}




