package com.springbootbootcamp.project.Controllers;

import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Models.UserModel;
import com.springbootbootcamp.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public PaginationDTO<UserModel> getUsers(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "") String searchParam) {
        return userService.getUsers(limit, offset, searchParam);
    }

    @GetMapping("{_id}")
    public UserModel getUserById(@PathVariable int _id) {
        return userService.getUserById(_id);
    }

    @PutMapping("{_id}")
    public String updateUser(@PathVariable int _id, @RequestBody UserModel user) {
        return userService.updateUser(_id, user);
    }

    @PostMapping
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @PostMapping("/bulk")
    public List<UserModel> bulkAddUsers(@RequestBody List<UserModel> users) {
        return userService.bulkAddUsers(users);
    }

}
