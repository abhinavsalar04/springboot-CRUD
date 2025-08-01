package com.springbootbootcamp.project.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="book_id_fk", referencedColumnName = "book_id")
    private List<Story> stories = new ArrayList<>();

    public Book(){}

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    // Helper methods
    public void addStory(Story story){
        this.stories.add(story);
        System.out.println("Story with id: " + story.getId() + " added in book with id: " + this.getId());
    }

    public void removeStory(Story story){
        this.stories.remove(story);
        System.out.println("Story with id: " + story.getId() + " removed from book with id: " + this.getId());
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}
