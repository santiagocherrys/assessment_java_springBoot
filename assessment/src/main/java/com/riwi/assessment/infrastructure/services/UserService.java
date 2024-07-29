package com.riwi.assessment.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.assessment.api.dtos.request.UserReq;
import com.riwi.assessment.api.dtos.response.UserResp;
import com.riwi.assessment.domain.entities.Users;
import com.riwi.assessment.domain.repositories.UserRepository;
import com.riwi.assessment.infrastructure.abstract_services.IUserClass;
import com.riwi.assessment.infrastructure.helpers.SupportService;
import com.riwi.assessment.infrastructure.helpers.mappers.UserMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserClass {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final SupportService<Users> methodSupportService;

    @Override
    public UserResp create(UserReq request) {
        Users user = this.userMapper.userRequestToEntity(request);
        user.setCoupon(new ArrayList<>());
        user.setCouponRedeemed(new ArrayList<>());
        return this.userMapper.userEntityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResp update(UserReq request, Long id) {
        Users user = this.methodSupportService.findById(this.userRepository, id, "User");
        Users userUpdate = this.userMapper.userRequestToEntity(request);
        userUpdate.setId(id);
        userUpdate.setCoupon(user.getCoupon());
        userUpdate.setCouponRedeemed(user.getCouponRedeemed());
        return this.userMapper.userEntityToResponse(this.userRepository.save(userUpdate));
    }

    @Override
    public void delete(Long id) {
        Users user = this.methodSupportService.findById(this.userRepository, id, "User");
        this.userRepository.delete(user);
    }

    @Override
    public Page<UserResp> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

 }
