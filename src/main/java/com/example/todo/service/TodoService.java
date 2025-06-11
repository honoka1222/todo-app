package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // サービス層として定義
public class TodoService {

    private final TodoRepository repository;

    // コンストラクタによる依存性注入（DI）
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // 全てのToDoを取得（一覧表示用）
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    // 新しいToDoを追加（期限付き）
    public void addTodo(String title, String description, LocalDate deadline) {
        Todo todo = new Todo(title, description, deadline);
        repository.save(todo);
    }

    // 指定IDのToDoを完了にする
    public void completeTodo(Integer id) {
        Todo todo = repository.findById(id).orElseThrow();
        todo.setCompleted(true);
        repository.save(todo);
    }

    // ID指定でToDoを取得（編集・詳細表示用）
    public Todo findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}
