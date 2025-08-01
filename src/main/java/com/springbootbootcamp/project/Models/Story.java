package com.springbootbootcamp.project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue
    @Column(name = "story_id")
    private int id;

    @Column(name = "story_title")
    private String title;

    @Column(name = "story_content")
    private String content;

    public Story(){}

    public Story(String title, String content){
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
