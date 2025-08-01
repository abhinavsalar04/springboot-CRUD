package com.springbootbootcamp.project.Repositories;

import com.springbootbootcamp.project.Models.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

}
