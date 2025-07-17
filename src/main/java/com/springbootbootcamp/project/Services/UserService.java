package com.springbootbootcamp.project.Services;

import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Mapper.PaginationMapper;
import com.springbootbootcamp.project.Models.UserModel;
import com.springbootbootcamp.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    public PaginationDTO<UserModel> getUsers(Integer limit, Integer offset, String searchParam){
        List<UserModel> users = userRepository.getUsersByLimitOffsetAndSearchParam(limit, offset, searchParam);
        PaginationMapper<UserModel> mappedData = new PaginationMapper<>();
        return mappedData.getMappedData(users, users.size(), userRepository.findAll().size());
    }

    public UserModel getUserById(Integer _id){
        return userRepository.findById(_id).get();
    }

    public String updateUser(Integer _id, UserModel user){
        UserModel userFromDB = userRepository.findById(_id).get();
        userFromDB.setName(user.getName());
        userFromDB.setProfession(user.getProfession());
        userRepository.save(userFromDB);
        return "User updated successfully!";
//        return "User with _id: " + _id + " not found!";
    }

    public UserModel addUser(UserModel user){
        return userRepository.save(user);
    }

    public List<UserModel> bulkAddUsers(List<UserModel> users){
        return userRepository.saveAll(users);
    }
}
