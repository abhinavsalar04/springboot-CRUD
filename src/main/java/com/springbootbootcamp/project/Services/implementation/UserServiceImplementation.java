package com.springbootbootcamp.project.Services.implementation;

import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Exceptions.UserNotFoundException;
import com.springbootbootcamp.project.Mapper.PaginationMapper;
import com.springbootbootcamp.project.Models.User;
import com.springbootbootcamp.project.Repositories.AssetRepository;
import com.springbootbootcamp.project.Repositories.UserRepository;
import com.springbootbootcamp.project.Services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;

    public PaginationDTO<User> getUsers(Integer limit, Integer offset, String searchParam){
        List<User> users = userRepository.getUsersByLimitOffsetAndSearchParam(limit, offset, searchParam);
        PaginationMapper<User> mappedData = new PaginationMapper<>();
        return mappedData.getMappedData(users, users.size(), userRepository.findAll().size());
    }

    public ResponseEntity<User> getUserById(Integer userId){
        Optional<User> userResponse = userRepository.findById(userId);
        if(userResponse.isEmpty()){
            throw new UserNotFoundException("User not found with id: " + userId);
        }
        User user = userResponse.get();
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

    }

    public ResponseEntity<String> updateUser(Integer userId, User user){
        Optional<User> userFromDB = userRepository.findById(userId);
        if(userFromDB.isEmpty()){
            throw new UserNotFoundException("User not found with id: " + userId);
        }
        User existingUser = userFromDB.get();

        existingUser.setName(user.getName());
        existingUser.setProfession(user.getProfession());

        userRepository.save(existingUser);
        return new ResponseEntity<>("User record updated!", HttpStatus.ACCEPTED);
    }

    public User addUser(User user){
        /*Asset asset = user.getAsset();
        if(asset != null ){
            assetRepository.save(asset);
        }*/
        return userRepository.save(user);
    }

    public List<User> bulkAddUsers(List<User> users){
        return userRepository.saveAll(users);
    }
}
