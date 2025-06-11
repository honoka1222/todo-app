
package com.example.todo.model;
 
import jakarta.persistence.*;
>>>>>>>> main:src/main/java/com/example/todo/model/Todo.java

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    private boolean completed;

    private LocalDateTime createdAt;

    public Task() {
        this.createdAt = LocalDateTime.now();
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}