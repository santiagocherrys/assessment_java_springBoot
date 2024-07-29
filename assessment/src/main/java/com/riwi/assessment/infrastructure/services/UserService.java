package com.riwi.assessment.infrastructure.services;

import com.riwi.assessment.api.dtos.request.UserRequest;
import com.riwi.assessment.domain.entities.User;
import com.riwi.assessment.domain.repositories.UserRepository;
import com.riwi.assessment.infrastructure.helpers.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public User create(UserRequest request){
        //User user = new User();
        //user.setName(request.getName());
        //user.setLastName(request.getLastName());
        return this.userRepository.save(this.userMapper.toEntity(request));
    }
}
