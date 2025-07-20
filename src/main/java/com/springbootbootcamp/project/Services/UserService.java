package com.springbootbootcamp.project.Services;

import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Mapper.PaginationMapper;
import com.springbootbootcamp.project.Models.User;
import com.springbootbootcamp.project.Repositories.AssetRepository;
import com.springbootbootcamp.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;

    public PaginationDTO<User> getUsers(Integer limit, Integer offset, String searchParam){
        List<User> users = userRepository.getUsersByLimitOffsetAndSearchParam(limit, offset, searchParam);
        PaginationMapper<User> mappedData = new PaginationMapper<>();
        return mappedData.getMappedData(users, users.size(), userRepository.findAll().size());
    }

    public User getUserById(Integer _id){
        return userRepository.findById(_id).get();
    }

    public String updateUser(Integer _id, User user){
        User userFromDB = userRepository.findById(_id).get();
        userFromDB.setName(user.getName());
        userFromDB.setProfession(user.getProfession());
        userRepository.save(userFromDB);
        return "User updated successfully!";
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
