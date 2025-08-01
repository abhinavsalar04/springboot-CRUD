package com.springbootbootcamp.project.Services.implementation;


import com.springbootbootcamp.project.Exceptions.StoryNotFoundException;
import com.springbootbootcamp.project.Models.Story;
import com.springbootbootcamp.project.Repositories.StoryRepository;
import com.springbootbootcamp.project.Services.interfaces.StoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoryServiceImplementation implements StoryServiceInterface {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryServiceImplementation(StoryRepository storyRepository){
        this.storyRepository = storyRepository;
    }

    public ResponseEntity<Story> addStory(Story story){
        Story storyResponse  = storyRepository.save(story);
        return new ResponseEntity<Story>(storyResponse, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Story> getStoryById(int storyId){
        Optional<Story> storyResponse  = storyRepository.findById(storyId);
        if(storyResponse.isEmpty()){
            throw new StoryNotFoundException("Story not found with id: " + storyId);
        }
        Story story = storyResponse.get();
        return new ResponseEntity<Story>(story, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> removeStory(int storyId){
        if (!storyRepository.existsById(storyId)) {
            throw new StoryNotFoundException("Story not found with id: " + storyId);
        }
        storyRepository.deleteById(storyId);
        return new ResponseEntity<String>(("Story removed with id: " + storyId), HttpStatus.ACCEPTED);
    }
}
