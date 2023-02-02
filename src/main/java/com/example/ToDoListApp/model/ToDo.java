package com.example.ToDoListApp.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descriptions")
    @NotNull
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getDesc() {
        return desc;
    }

    public void setDesc(@NotNull String desc) {
        this.desc = desc;
    }
}
