package com.springbootbootcamp.project.Services.interfaces;

import com.springbootbootcamp.project.Models.Story;
import org.springframework.http.ResponseEntity;

public interface StoryServiceInterface {
    public ResponseEntity<Story> addStory(Story story);

    public ResponseEntity<Story> getStoryById(int storyId);

   // public ResponseEntity<Story> updateStory(Story story);

    public ResponseEntity<String> removeStory(int storyId);

}
