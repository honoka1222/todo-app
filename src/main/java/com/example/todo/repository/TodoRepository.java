package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


// Todoエンティティ用のリポジトリインターフェース（CRUD全対応）
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
