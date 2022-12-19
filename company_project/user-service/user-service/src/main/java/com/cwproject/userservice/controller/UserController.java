package com.cwproject.userservice.controller;

import com.cwproject.userservice.VO.ResponseTemplateVO;
import com.cwproject.userservice.entity.User;
import com.cwproject.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

//_________________________________ get by id--
    @RequestMapping(method = RequestMethod.GET,value = "/users/{userId}")
    public User getUser(@PathVariable Long userId , User user){

        return userService.getUser(userId);
    }
//-----------------------------------
    @RequestMapping(method = RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/users/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User user)
    {
        userService.updateUser(userId, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/users/{userId}")
    public void DeleteUser(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
    }


}


//@RestController
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//

