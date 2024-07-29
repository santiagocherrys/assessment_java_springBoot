package com.riwi.assessment.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.assessment.api.dtos.request.UserReq;
import com.riwi.assessment.api.dtos.response.UserResp;
import com.riwi.assessment.domain.entities.Users;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @InheritInverseConfiguration
    UserResp toUserResponse(Users userEntity);

    
    @Mapping(source = "name", target = "name")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserReq userEntityToRequest(Users userEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "email", target = "email")
    UserResp userEntityToResponse(Users userEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserReq userEntityToRequest(UserReq request);

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    Users userRequestToEntity(UserReq userRequest);

}
