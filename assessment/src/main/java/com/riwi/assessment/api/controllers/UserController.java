package com.riwi.assessment.api.controllers;

import com.riwi.assessment.api.dtos.request.UserRequest;
import com.riwi.assessment.domain.entities.User;
import com.riwi.assessment.infrastructure.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
@Tag(name = "User")
public class UserController {

    @Autowired
    private final UserService service;

    @GetMapping
    public List<User> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public User update(@Validated
                       @RequestBody UserRequest request){
        return this.service.create(request);
    }
}
