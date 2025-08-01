package com.springbootbootcamp.project.Services.interfaces;


import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface {

    public PaginationDTO<User> getUsers(Integer limit, Integer offset, String searchParam);

    public ResponseEntity<User> getUserById(Integer _id);

    public User addUser(User user);

    public List<User> bulkAddUsers(List<User> users);

    public ResponseEntity<String> updateUser(Integer _id, User user);

}
