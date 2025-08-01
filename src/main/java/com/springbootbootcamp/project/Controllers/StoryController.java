package com.springbootbootcamp.project.Controllers;

import com.springbootbootcamp.project.Models.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springbootbootcamp.project.Services.implementation.StoryServiceImplementation;

@RestController
@RequestMapping("/api/v1/story")
public class StoryController {
    @Autowired
    private StoryServiceImplementation storyService;
    @PostMapping
    public ResponseEntity<Story> addStory(@RequestBody Story story){
        return storyService.addStory(story);
    }

    @GetMapping("/{storyId}")
    public ResponseEntity<Story> getStoryById(@PathVariable int storyId){
        return storyService.getStoryById(storyId);
    }

    @DeleteMapping("/{storyId}")
    public ResponseEntity<String> removeStory(@PathVariable int storyId){
        return storyService.removeStory(storyId);
    }
}
