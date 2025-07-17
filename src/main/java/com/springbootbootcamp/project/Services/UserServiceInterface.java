package com.springbootbootcamp.project.Services;


import com.springbootbootcamp.project.DTO.PaginationDTO;
import com.springbootbootcamp.project.Models.UserModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServiceInterface {

    public PaginationDTO<UserModel> getUsers(Integer limit, Integer offset, String searchParam);

    public UserModel getUserById(Integer _id);

    public UserModel addUser(UserModel user);

    public List<UserModel> bulkAddUsers(List<UserModel> users);

    public String updateUser(Integer _id, UserModel user);

}
