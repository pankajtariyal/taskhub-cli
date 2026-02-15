package com.taskhub_cli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private String title;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private TaskStatus status;


    @SuppressWarnings("unused")
    public Task(){}

    public Task(int id,String title,TaskStatus status){
        this.id = id;
        this.title = title;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "["+this.id+"]\t" + this.title+" | "  + this.created_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"))+" | " +this.updated_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"))+" | " + this.status;
    }
}
