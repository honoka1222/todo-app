package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller // HTMLページを返すコントローラ
@RequestMapping("/todos") // すべて /todos で始まるURLに対応
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    // タスク一覧表示：GET /todos
    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = service.getAllTodos();
        model.addAttribute("todos", todos); // テンプレートに渡す
        return "todo-list"; // resources/templates/todo-list.html を返す
    }

    // 新規タスク追加処理：POST /todos
    @PostMapping
    public String addTodo(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam LocalDate deadline
    ) {
        service.addTodo(title, description, deadline);
        return "redirect:/todos"; // 登録後、一覧画面にリダイレクト
    }

    // タスク完了処理：POST /todos/{id}/complete
    @PostMapping("/{id}/complete")
    public String completeTodo(@PathVariable Integer id) {
        service.completeTodo(id);
        return "redirect:/todos";
    }
}