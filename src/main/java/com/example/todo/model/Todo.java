
package com.example.todo.model;

import jakarta.persistence.*;

// データベースに保存されるエンティティ（テーブル）として指定
@Entity
public class Todo {

    // 主キー（ID）を自動生成
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // タスクのタイトル
    private String title;

    // タスクの説明
    private String description;

    // 完了フラグ（true = 完了、false = 未完了）
    private boolean completed;

    // 締切日（ユーザーが入力）
    private LocalDate deadline;


    // デフォルトコンストラクタ（Spring用）・completed初期値はfalse
    public Todo() {
        this.completed = false;
    }

    // タイトル・説明・締切を指定して新しいタスクを作成
    public Todo(String title, String description, LocalDate deadline) {

        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
    }

    // --- Getter メソッド（値を取り出す）---

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

    public LocalDate getDeadline() {
        return deadline;
    }

    // --- Setter メソッド（値を設定する）---

    // タイトルを変更
    public void setTitle(String title) {
        this.title = title;
    }

    // 説明を変更
    public void setDescription(String description) {
        this.description = description;
    }

    // 完了状態を設定（true/false）
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // 締切日を設定
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
