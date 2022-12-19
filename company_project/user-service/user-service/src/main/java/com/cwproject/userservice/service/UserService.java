package com.cwproject.userservice.service;

import com.cwproject.userservice.VO.Department;
import com.cwproject.userservice.VO.ResponseTemplateVO;
import com.cwproject.userservice.entity.User;
import com.cwproject.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    //get by id
    public User getUser(Long userId) {

        return userRepository.findByUserId(userId);
    }

    public void addUser(User user) {
        userRepository.save(user);

    }

    public void updateUser(Long userId, User user) {
        userRepository.save(user);

    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        , Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;


    }

}