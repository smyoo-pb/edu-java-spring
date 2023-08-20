package com.precisionbio.springboot.todo.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String username;

    @Size(min = 10, message = "Enter atleast 10 characters")
    @Size(max = 50, message = "Enter no more than 50 characters")
    private String description;
    private LocalDate targetDate;
    private boolean isDone;

    public Todo() {

    }

    /**
     * @param id
     * @param username
     * @param description
     * @param targetDate
     * @param isDone
     */
    public Todo(int id, String username, String description, LocalDate targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the targetDate
     */
    public LocalDate getTargetDate() {
        return targetDate;
    }

    /**
     * @param targetDate the targetDate to set
     */
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * @return the isDone
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", isDone=" + isDone + "]";
    }
}
