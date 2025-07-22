package com.springbootbootcamp.project.Controllers;

import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Models.Asset;
import com.springbootbootcamp.project.Models.User;
import com.springbootbootcamp.project.Repositories.AssetRepository;
import com.springbootbootcamp.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AssetRepository assetRepository;

    @GetMapping
    public PaginationDTO<User> getUsers(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "") String searchParam) {
        return userService.getUsers(limit, offset, searchParam);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        Asset asset = user.getAsset();
        if(asset != null){
            assetRepository.save(asset);
        }
        return userService.addUser(user);
    }

    @PostMapping("/bulk")
    public List<User> bulkAddUsers(@RequestBody List<User> users) {
        return userService.bulkAddUsers(users);
    }

}
